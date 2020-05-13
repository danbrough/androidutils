package danbroid.util.demo.menu

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import danbroid.util.menu.find
import danbroid.util.menu.ui.menulist.AbstractMenuListFragment
import danbroid.util.menu.ui.model.menuListModel

class MenuListFragment : AbstractMenuListFragment() {
  val args: MenuListFragmentArgs by navArgs()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    val menuID = args.menuID
    val builder = rootContent.find(menuID)
    log.trace("menuID: $menuID builder: $builder")
    model = menuListModel(menuID, builder!!)
    super.onViewCreated(view, savedInstanceState)
  }
}

private val log = org.slf4j.LoggerFactory.getLogger(MenuListFragment::class.java)
