package danbroid.util.menu.ui.menulist

import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import danbroid.habitrack.ui.menulist.MenuListAdapter
import danbroid.util.menu.MenuActionContext
import danbroid.util.menu.MenuItem
import danbroid.util.menu.menuImplementation
import danbroid.util.menu.ui.model.MenuListModel
import kotlinx.android.synthetic.main.fragment_menu_list.*
import kotlinx.coroutines.launch

abstract class AbstractMenuListFragment : Fragment() {

  interface MenuItemHandler {

    fun onClicked(menu: MenuItem)

    fun onCreateContextMenu(
        menuItem: MenuItem,
        menu: ContextMenu,
        view: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    )

    fun setToolbarTitle(title: CharSequence)
  }

  protected open val menuItemClickHandler: MenuItemHandler?
    get() = activity as? MenuItemHandler

  protected val menuImpl by lazy {
    menuImplementation()
  }

  protected open lateinit var model: MenuListModel

  override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
  ) = inflater.inflate(menuImpl.layoutID, container, false)


  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    val adapter = MenuListAdapter()

    adapter.also {
      it.onClick = { menuItem ->
        menuItem.menuItemBuilder?.onClick?.also { clickHandler ->
          requireActivity().lifecycleScope.launch {
            clickHandler(MenuActionContext(requireContext(), menuItem, this@AbstractMenuListFragment)) {
              if (it) menuItemClickHandler?.onClicked(menuItem)
            }
          }
        } ?: menuItemClickHandler?.onClicked(menuItem)
      }
      it.onContextMenu = menuItemClickHandler?.let { it::onCreateContextMenu }
    }

    recycler_view.adapter = adapter
    recycler_view.layoutManager = LinearLayoutManager(requireContext())

    model.menu.observe(viewLifecycleOwner) {
      onMenuChanged(it, adapter)
    }
  }


  open fun onMenuChanged(menu: MenuItem, adapter: MenuListAdapter) {
    //log.trace("onMenuChanged() $menu")
    //activityInterface.setToolbarTitle(menu.title)
    menuImpl.setToolbarTitle(menu.title)

    menu.children?.also {
      progress_bar.visibility = View.GONE
      recycler_view.visibility = View.VISIBLE
      adapter.submitList(it.filter { it.isVisible })
    }
  }

}

//private val log = LoggerFactory.getLogger(AbstractMenuListFragment::class.java)
