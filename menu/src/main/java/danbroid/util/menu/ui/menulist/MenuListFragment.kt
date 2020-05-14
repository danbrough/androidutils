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
import danbroid.util.menu.find
import danbroid.util.menu.ui.MenuImplementation
import danbroid.util.menu.ui.MenuImplementation.rootContent
import danbroid.util.menu.ui.model.MenuListModel
import danbroid.util.menu.ui.model.menuListModel
import kotlinx.android.synthetic.main.fragment_menu_list.*
import kotlinx.coroutines.launch
import org.slf4j.LoggerFactory

class MenuListFragment : Fragment() {

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


  protected open lateinit var model: MenuListModel

  override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
  ) = inflater.inflate(MenuImplementation.layoutID, container, false)


  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    val adapter = MenuListAdapter()

    val menuID = MenuImplementation.menuID(this)
    val builder = rootContent.invoke(this).find(menuID)
    log.trace("menuID: $menuID builder: $builder")
    model = menuListModel(menuID, builder!!)

    adapter.also {
      it.onClick = { menuItem ->
        menuItem.menuItemBuilder?.onClick?.also { clickHandler ->
          requireActivity().lifecycleScope.launch {
            clickHandler(MenuActionContext(requireContext(), menuItem, this@MenuListFragment)) {
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
    MenuImplementation.setToolbarTitle.invoke(requireActivity(), menu.title)

    menu.children?.also {
      progress_bar.visibility = View.GONE
      recycler_view.visibility = View.VISIBLE
      adapter.submitList(it.filter { it.isVisible })
    }
  }

}

private val log = LoggerFactory.getLogger(MenuListFragment::class.java)
