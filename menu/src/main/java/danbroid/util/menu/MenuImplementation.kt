package danbroid.util.menu

import androidx.annotation.LayoutRes
import danbroid.util.context.Singleton
import danbroid.util.menu.ui.menulist.AbstractMenuListFragment

class MenuImplementation(fragment: AbstractMenuListFragment) : Singleton<AbstractMenuListFragment>(fragment) {

  init {
    log.info("menuID ${context.arguments?.getString("menuID")}")
  }

  @LayoutRes
  var layoutID: Int = R.layout.fragment_menu_list

  var setToolbarTitle: (CharSequence) -> Unit = {
    context.requireActivity().setTitle(it)
  }

  lateinit var rootContent: () -> MenuItemBuilder
}

fun AbstractMenuListFragment.menuImplementation(): MenuImplementation =
    Singleton.getInstance(this)

private val log = org.slf4j.LoggerFactory.getLogger(MenuImplementation::class.java)
