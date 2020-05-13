package danbroid.util.demo.menu

import android.os.Bundle
import android.view.View
import danbroid.menu.ui.menulist.AbstractMenuListFragment
import danbroid.menu.ui.model.menuListModel

class MenuListFragment : AbstractMenuListFragment() {
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    model = menuListModel(arguments?.getString("id")!!, rootContent)
    super.onViewCreated(view, savedInstanceState)
  }
}

private val log = org.slf4j.LoggerFactory.getLogger(MenuListFragment::class.java)
