package danbroid.util.menu.ui

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import danbroid.util.menu.MenuItemBuilder
import danbroid.util.menu.R

object MenuImplementation {

  @LayoutRes
  var layoutID: Int = R.layout.fragment_menu_list

  var setToolbarTitle: FragmentActivity.(CharSequence) -> Unit = {
    setTitle(it)
  }

  var menuID: Fragment.() -> String = {
    arguments!!.getString("menuID")!!
  }

  lateinit var rootContent: Fragment.() -> MenuItemBuilder
}

private val log = org.slf4j.LoggerFactory.getLogger(MenuImplementation::class.java)
