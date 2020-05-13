package danbroid.habitrack.ui.menulist

import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import danbroid.util.menu.MenuItem
import danbroid.util.menu.R
import kotlinx.android.synthetic.main.menu_item_fragment.view.*

class MenuListAdapter(
    diffCallback: DiffUtil.ItemCallback<MenuItem> = MenuItemDiffCallback
) :
    ListAdapter<MenuItem, MenuListAdapter.MenuViewHolder>(diffCallback) {

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
      log.warn("RECYCLED: $menu")
      menu = null
    }

    var menu: MenuItem? = null

    fun bind(menu: MenuItem, payloads: MutableList<Any>) {
      this.menu = menu
      itemView.title.text = menu.title
      itemView.subtitle.text = menu.subtitle

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

  private val emptyPayloads = mutableListOf<Any>()

  override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
    holder.bind(getItem(position), emptyPayloads)
  }

  override fun onBindViewHolder(holder: MenuViewHolder, position: Int, payloads: MutableList<Any>) {
    holder.bind(getItem(position), payloads)
  }

}

object MenuItemDiffCallback : DiffUtil.ItemCallback<MenuItem>() {
  override fun areItemsTheSame(oldItem: MenuItem, newItem: MenuItem) = oldItem.id == newItem.id


  override fun areContentsTheSame(oldItem: MenuItem, newItem: MenuItem) =
      oldItem == newItem

}

private val log = org.slf4j.LoggerFactory.getLogger(MenuListAdapter::class.java)
