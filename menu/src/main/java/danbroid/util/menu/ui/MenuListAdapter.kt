package danbroid.util.menu.ui

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.ImageViewCompat
import androidx.fragment.app.Fragment
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
import danbroid.util.menu.MENU_TINT_DISABLED
import danbroid.util.menu.MenuItem
import danbroid.util.menu.R
import danbroid.util.menu.databinding.MenuItemFragmentBinding
import danbroid.util.resource.*

typealias ContextMenuHandler = MenuListAdapter.MenuViewHolder.(
    menu: ContextMenu,
    view: View,
    menuInfo: ContextMenu.ContextMenuInfo?
) -> Unit

open class MenuListAdapter(val fragment: Fragment,
                           diffCallback: DiffUtil.ItemCallback<MenuItem> = MenuItemDiffCallback
) : ListAdapter<MenuItem, MenuListAdapter.MenuViewHolder>(diffCallback) {

  val context: Context = fragment.requireContext()

  @DrawableRes
  var DEFAULT_FOLDER_ICON: Int = R.attr.dbMenuIconFolder.getThemeDrawableRes(context, R.drawable.ic_folder)

  @DrawableRes
  var DEFAULT_FILE_ICON = R.attr.dbMenuIconFile.getThemeDrawableRes(context, R.drawable.ic_file)

  var onClick: ((MenuItem) -> Unit)? = null

  override fun onViewRecycled(holder: MenuViewHolder) {
    super.onViewRecycled(holder)
    holder.recycle()
  }

  inner class MenuViewHolder(val binding: MenuItemFragmentBinding) : RecyclerView.ViewHolder(binding.root) {


    init {
      onClick?.also { handler ->
        itemView.setOnClickListener {
          handler.invoke(menuItem!!)
        }
      } ?: itemView.setOnClickListener(null)

    }

    fun recycle() {
      menuItem = null
    }

    var menuItem: MenuItem? = null


  }

  val iconSize = context.resources.getDimension(R.dimen.media_item_icon_size)
  val iconCornerRadius = (iconSize / 8).toInt()

  protected open fun bind(viewHolder: MenuViewHolder, payloads: MutableList<Any>) {
    val menuItem = viewHolder.menuItem!!
    //log.trace("bind() ${viewHolder.menuItem}")
    val itemView = viewHolder.itemView

    menuItem.menuItemBuilder?.contextMenu?.also { provider ->
      itemView.setOnCreateContextMenuListener { contextMenu, _, _ ->
        provider.invoke(contextMenu, fragment)
      }

    } ?: itemView.setOnCreateContextMenuListener(null)

    //log.trace("bind() payloads: $payloads")
    viewHolder.binding.subtitle.visibility = if (menuItem.subtitle.isBlank()) {
      // log.error("${menu.title} has no subtitle")
      View.GONE
    } else View.VISIBLE

    if (!payloads.isEmpty()) {
      val changes = payloads.fold(0) { r, t ->
        r or t as Int
      }
      if (changes and MEDIA_ITEM_PAYLOAD_TITLE != 0) {
        //  log.trace("MEDIA_ITEM_PAYLOAD_TITLE")
        viewHolder.binding.title.text = menuItem.title
      }
      if (changes and MEDIA_ITEM_PAYLOAD_SUBTITLE != 0) {
        // log.trace("MEDIA_ITEM_PAYLOAD_SUBTITLE")
        viewHolder.binding.subtitle.text = menuItem.subtitle
      }
      if (changes and MEDIA_ITEM_PAYLOAD_IMAGE != 0) {
        // log.trace("MEDIA_ITEM_PAYLOAD_IMAGE")
        setIcon(viewHolder)
      }
      return
    }
    viewHolder.binding.title.text = menuItem.title
    viewHolder.binding.subtitle.text = menuItem.subtitle

    viewHolder.binding.stateInPlaylist.visibility = View.GONE
    setIcon(viewHolder)
  }


  protected open fun setIcon(viewHolder: MenuViewHolder) {
    val itemView = viewHolder.itemView
    val menu = viewHolder.menuItem!!

    val iconContext = viewHolder.binding.icon.context

    if (menu.tint != MENU_TINT_DISABLED) {
      @ColorInt
      val tint = if (menu.tint != 0) menu.tint.toResourceColour(iconContext) else
        R.attr.dbMenuIconTint.toThemeColour(iconContext).let {
          if (it != -1) it else
            R.attr.colorPrimary.toThemeColour(iconContext)
        }

      viewHolder.binding.icon.setTintColor(tint)
    }

    if (menu.icon != null) {
      viewHolder.binding.icon.setImageDrawable(menu.icon!!)
      return
    }


    val image = menu.imageURI
    val resID: Int = if (image == null)
      if (menu.isBrowsable) DEFAULT_FOLDER_ICON else DEFAULT_FILE_ICON
    else
      image.resolveDrawableURI(context)


    //itemView.icon.setTintColor(if (menu.tint != 0) menu.tint else R.attr.colorPrimary.toThemeColour(context))

    if (resID != 0) {
      viewHolder.binding.icon.setImageDrawable(
          ResourcesCompat.getDrawable(
              context.resources,
              resID,
              context.theme
          )
      )
    } else {

      val roundedCorners = R.attr.dbMenuIconRoundedCorners.getThemeBoolean(viewHolder.binding.icon.context, menu.roundedCorners)
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
              ImageViewCompat.setImageTintList(viewHolder.binding.icon, null)
              return false
            }

          })
          .into(viewHolder.binding.icon)
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder =
      MenuViewHolder(MenuItemFragmentBinding.inflate(LayoutInflater.from(parent.context), parent, false))

  /*override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
      MenuViewHolder(
          LayoutInflater.from(parent.context).inflate(
              R.layout.menu_item_fragment,
              parent,
              false
          ) as ViewGroup
      )
*/

  override fun onBindViewHolder(holder: MenuViewHolder, position: Int): Unit =
      onBindViewHolder(holder, position, mutableListOf())

  override fun onBindViewHolder(holder: MenuViewHolder, position: Int, payloads: MutableList<Any>) {
    holder.menuItem = getItem(position)
    bind(holder, payloads)
  }

}

private const val MEDIA_ITEM_PAYLOAD_TITLE = 1
private const val MEDIA_ITEM_PAYLOAD_SUBTITLE = 2
private const val MEDIA_ITEM_PAYLOAD_IMAGE = 4


object MenuItemDiffCallback : DiffUtil.ItemCallback<MenuItem>() {
  override fun areItemsTheSame(oldItem: MenuItem, newItem: MenuItem) = oldItem.id == newItem.id


  override fun areContentsTheSame(oldItem: MenuItem, newItem: MenuItem) =
      (oldItem.title == newItem.title &&
          oldItem.subtitle == newItem.subtitle &&
          oldItem.imageURI == newItem.imageURI)

  override fun getChangePayload(oldItem: MenuItem, newItem: MenuItem): Any? {
    var payload = 0
    if (oldItem.title != newItem.title) {
      // log.trace("ADDING MEDIA_ITEM_PAYLOAD_TITLE")
      payload = payload or MEDIA_ITEM_PAYLOAD_TITLE
    }
    if (oldItem.subtitle != newItem.subtitle) {
      // log.trace("ADDING MEDIA_ITEM_PAYLOAD_SUBTITLE")
      payload = payload or MEDIA_ITEM_PAYLOAD_SUBTITLE
    }
    if (oldItem.imageURI != newItem.imageURI) {
      //log.trace("ADDING MEDIA_ITEM_PAYLOAD_IMAGE")
      payload = payload or MEDIA_ITEM_PAYLOAD_IMAGE
    }
    return if (payload == 0) null else payload
  }
}

private val log = org.slf4j.LoggerFactory.getLogger(MenuListAdapter::class.java)
