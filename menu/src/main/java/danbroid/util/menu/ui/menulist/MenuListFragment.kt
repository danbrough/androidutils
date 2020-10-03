package danbroid.util.menu.ui.menulist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import danbroid.util.menu.MenuActionContext
import danbroid.util.menu.MenuItem
import danbroid.util.menu.find
import danbroid.util.menu.navigation.MenuNavGraph
import danbroid.util.menu.ui.MenuImplementation
import danbroid.util.menu.ui.MenuImplementation.menuClickHandler
import danbroid.util.menu.ui.MenuImplementation.menuContextMenuHandler
import danbroid.util.menu.ui.MenuImplementation.rootContent
import danbroid.util.menu.ui.model.MenuListModel
import danbroid.util.menu.ui.model.menuListModel
import kotlinx.android.synthetic.main.fragment_menu_list.*
import kotlinx.coroutines.launch
import org.slf4j.LoggerFactory

open class MenuListFragment : Fragment() {

  protected open lateinit var model: MenuListModel

  override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
  ) = inflater.inflate(MenuImplementation.layoutID, container, false)


  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    val adapter = MenuListAdapter(requireContext())

    val menuID = requireArguments().getString(MenuNavGraph.args.menuID)
        ?: throw IllegalArgumentException("Fragment argument ${MenuNavGraph.args.menuID} not specified")

    val builder = rootContent.invoke(this).find(menuID)
        ?: throw IllegalArgumentException("No content found for $menuID")

    log.trace("menuID: $menuID builder: $builder")
    model = menuListModel(menuID, builder)

    adapter.also {
      it.onClick = { menuItem ->
        menuItem.menuItemBuilder?.onClick?.also { clickHandler ->
          requireActivity().lifecycleScope.launch {
            clickHandler(MenuActionContext(requireContext(), menuItem, this@MenuListFragment)) {
              if (it) menuClickHandler.invoke(this@MenuListFragment, menuItem)
            }
          }
        } ?: menuClickHandler.invoke(this@MenuListFragment, menuItem)
      }

      it.onContextMenu = { menuItem, contextMenu, view, menuInfo ->
        menuContextMenuHandler.invoke(this@MenuListFragment, menuItem, contextMenu, view, menuInfo)

      }
    }

    recycler_view.adapter = adapter
    recycler_view.layoutManager = LinearLayoutManager(requireContext())

    model.menu.observe<MenuItem>(viewLifecycleOwner) {
      onMenuChanged(it, adapter)
    }
  }

  override fun onContextItemSelected(item: android.view.MenuItem): Boolean {
    log.trace("onContextItemSelected() $item")
    return super.onContextItemSelected(item)
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
