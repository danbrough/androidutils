package danbroid.util.menu.ui.menulist

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import danbroid.util.menu.MenuItem
import danbroid.util.menu.R
import danbroid.util.resource.*
import kotlinx.android.synthetic.main.menu_item_fragment.view.*

open class MenuListAdapter(val context: Context,
                           diffCallback: DiffUtil.ItemCallback<MenuItem> = MenuItemDiffCallback
) : ListAdapter<MenuItem, MenuListAdapter.MenuViewHolder>(diffCallback) {

  @DrawableRes
  var DEFAULT_FOLDER_ICON = R.drawable.ic_folder

  @DrawableRes
  var DEFAULT_FILE_ICON = R.drawable.ic_file

  var onClick: ((MenuItem) -> Unit)? = null

  var onContextMenu: ((
      menuItem: MenuItem,
      menu: ContextMenu,
      view: View,
      menuInfo: ContextMenu.ContextMenuInfo?
  ) -> Unit)? = null

  override fun onViewRecycled(holder: MenuViewHolder) {
    super.onViewRecycled(holder)
    holder.recycle()
  }

  inner class MenuViewHolder(itemView: ViewGroup) : RecyclerView.ViewHolder(itemView) {

    init {
      itemView.setOnCreateContextMenuListener { contextMenu, v, menuInfo ->
        onContextMenu?.invoke(menu!!, contextMenu, v, menuInfo)
      }
      itemView.setOnClickListener {
        onClick?.invoke(menu!!)
      }
    }

    fun recycle() {
      menu = null
    }

    var menu: MenuItem? = null


  }

  val iconSize = context.resources.getDimension(R.dimen.media_item_icon_size)
  val iconCornerRadius = (iconSize / 8).toInt()

  protected open fun bind(viewHolder: MenuViewHolder, menu: MenuItem, payloads: MutableList<Any>) {
    val itemView = viewHolder.itemView
    if (!payloads.isEmpty()) {
      val changes = payloads.fold(0) { r, t ->
        r or t as Int
      }
      if (changes or MEDIA_ITEM_PAYLOAD_TITLE != 0) {
        itemView.title.text = menu.title
      }
      if (changes or MEDIA_ITEM_PAYLOAD_SUBTITLE != 0) {
        itemView.subtitle.text = menu.subtitle
      }
      if (changes or MEDIA_ITEM_PAYLOAD_IMAGE != 0) {
        setIcon(viewHolder, menu)
      }
      return
    }
    itemView.title.text = menu.title
    itemView.subtitle.text = menu.subtitle
    itemView.state_in_playlist.visibility = View.GONE
    setIcon(viewHolder, menu)
  }


  protected open fun setIcon(viewHolder: MenuViewHolder, menu: MenuItem) {
    val itemView = viewHolder.itemView
    val image = menu.imageURI
    val resID: Int = if (image == null)
      if (menu.isBrowsable) DEFAULT_FOLDER_ICON else DEFAULT_FILE_ICON
    else
      image.resolveDrawableURI(context)


    val iconContext = itemView.icon.context

    @ColorInt
    val tint = if (menu.tint != 0) menu.tint.toResourceColour(iconContext) else
      R.attr.dbMenuIconTint.toThemeColour(iconContext)


    log.trace("setting tint on ${menu.title}")
    itemView.icon.setTintColor(tint)

    //itemView.icon.setTintColor(if (menu.tint != 0) menu.tint else R.attr.colorPrimary.toThemeColour(context))

    if (resID != 0) {
      itemView.icon.setImageDrawable(
          ResourcesCompat.getDrawable(
              context.resources,
              resID,
              context.theme
          )
      )
    } else {

      val roundedCorners = R.attr.dbMenuIconRoundedCorners.getThemeBoolean(itemView.icon.context)
      log.error("rounded corners: $roundedCorners")
      val placeholder = ResourcesCompat.getDrawable(
          context.resources,
          if (menu.isBrowsable) DEFAULT_FOLDER_ICON else DEFAULT_FILE_ICON,
          context.theme
      )!!


      Glide.with(itemView.context).load(menu.imageURI)
          //      .placeholder(circularProgressDrawable)
          .diskCacheStrategy(DiskCacheStrategy.DATA).let {
            if (roundedCorners)
              it.transform(RoundedCorners(iconCornerRadius))
            else it
          }

          .placeholder(placeholder)
          .addListener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ) = false

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
              ImageViewCompat.setImageTintList(itemView.icon, null)
              return false
            }

          })
          .into(itemView.icon)
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
      MenuViewHolder(
          LayoutInflater.from(parent.context).inflate(
              R.layout.menu_item_fragment,
              parent,
              false
          ) as ViewGroup
      )


  override fun onBindViewHolder(holder: MenuViewHolder, position: Int) =
      onBindViewHolder(holder, position, mutableListOf())


  override fun onBindViewHolder(holder: MenuViewHolder, position: Int, payloads: MutableList<Any>) =
      bind(holder, getItem(position).also { holder.menu = it }, payloads)


}

private const val MEDIA_ITEM_PAYLOAD_TITLE = 1
private const val MEDIA_ITEM_PAYLOAD_SUBTITLE = 2
private const val MEDIA_ITEM_PAYLOAD_IMAGE = 4


object MenuItemDiffCallback : DiffUtil.ItemCallback<MenuItem>() {
  override fun areItemsTheSame(oldItem: MenuItem, newItem: MenuItem) = oldItem.id == newItem.id


  override fun areContentsTheSame(oldItem: MenuItem, newItem: MenuItem) =
      oldItem.title == newItem.title &&
          oldItem.subtitle == newItem.subtitle &&
          oldItem.imageURI == newItem.imageURI

  override fun getChangePayload(oldItem: MenuItem, newItem: MenuItem): Any? {
    var payload = 0
    if (oldItem.title != newItem.title) payload = payload or MEDIA_ITEM_PAYLOAD_TITLE
    if (oldItem.subtitle != newItem.subtitle) payload = payload or MEDIA_ITEM_PAYLOAD_SUBTITLE
    if (oldItem.imageURI != newItem.imageURI) payload = payload or MEDIA_ITEM_PAYLOAD_IMAGE
    return if (payload == 0) null else payload
  }
}

private val log = org.slf4j.LoggerFactory.getLogger(MenuListAdapter::class.java)
