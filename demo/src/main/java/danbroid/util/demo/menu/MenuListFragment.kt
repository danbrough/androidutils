package danbroid.util.demo.menu

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import danbroid.menu.find
import danbroid.menu.ui.menulist.AbstractMenuListFragment
import danbroid.menu.ui.model.menuListModel

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
