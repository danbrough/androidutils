package danbroid.util.menu.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import danbroid.util.menu.MenuConfiguration
import danbroid.util.menu.MenuConfiguration.menuClickHandler
import danbroid.util.menu.MenuItem
import danbroid.util.menu.R
import danbroid.util.menu.model.MenuModel
import danbroid.util.menu.model.menuViewModel
import kotlinx.android.synthetic.main.fragment_menu_list.*
import kotlinx.coroutines.launch

class MenuFragment : Fragment(R.layout.fragment_menu_list) {

  val model: MenuModel by lazy {
    menuViewModel()
  }

  lateinit var adapter: MenuListAdapter


  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    log.debug("onViewCreated() model $model")

    adapter = MenuListAdapter(this)
    recycler_view.adapter = adapter
    recycler_view.layoutManager = LinearLayoutManager(requireContext())

    model.menu.observe(viewLifecycleOwner, ::onMenuItem)
    model.children.observe(viewLifecycleOwner, ::onMenuChildren)

    adapter.onClick = { menuItem ->
      log.trace("clicked $menuItem builder:${menuItem.menuItemBuilder}")

      menuItem.menuItemBuilder?.onClick?.also { clickHandler ->
        lifecycleScope.launch {
          if (clickHandler.invoke(this@MenuFragment))
            menuClickHandler.invoke(this@MenuFragment, menuItem)
        }
      } ?: menuClickHandler.invoke(this@MenuFragment, menuItem)
    }


  }


  fun onMenuItem(item: MenuItem) {
    MenuConfiguration.setToolbarTitle.invoke(this, item.title)
  }

  fun onMenuChildren(children: List<MenuItem>?) {
    if (children == null) {
      progress_bar.visibility = View.VISIBLE
      recycler_view.visibility = View.GONE
      return
    }
    progress_bar.visibility = View.GONE
    recycler_view.visibility = View.VISIBLE
    children.filter { it.isVisible }.also {
      adapter.submitList(it)
      recycler_view.invalidate()
    }
  }
}

private val log = org.slf4j.LoggerFactory.getLogger(MenuFragment::class.java)
