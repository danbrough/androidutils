package danbroid.menu.ui.menulist

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import danbroid.habitrack.ui.menulist.MenuListAdapter
import danbroid.menu.MenuActionContext
import danbroid.menu.MenuItem
import danbroid.menu.R
import danbroid.menu.ui.model.MenuListModel
import kotlinx.android.synthetic.main.fragment_menu_list.*
import kotlinx.coroutines.launch
import org.slf4j.LoggerFactory

abstract class MenuListFragment : Fragment() {

  //protected val args: MenuListFragmentArgs by navArgs()

  @LayoutRes
  protected open val layoutID: Int = R.layout.fragment_menu_list

  val model: MenuListModel by lazy {
    TODO("")
    // menuListModel(args.menuID)
  }


  override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
  ) = inflater.inflate(layoutID, container, false)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    val adapter = MenuListAdapter()

    adapter.also {
      it.onClick = { menuItem ->
        menuItem.menuItemBuilder?.onClick?.also { clickHandler ->
          requireActivity().lifecycleScope.launch {
            clickHandler(MenuActionContext(requireContext(), menuItem, this@MenuListFragment)) {
              // if (it) activityInterface.onClicked(menuItem)
            }
          }
        } //?: activityInterface.onClicked(menuItem)
      }
      //it.onContextMenu = activityInterface::onCreateContextMenu
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

    menu.children?.also {
      progress_bar.visibility = View.GONE
      recycler_view.visibility = View.VISIBLE
      adapter.submitList(it.filter { it.isVisible })
    }
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    log.error("onActivityResult() requestCode: $requestCode resultCode: $resultCode data: $data")
    log.error("uri:${data?.data} extras:${data?.extras}")

    super.onActivityResult(requestCode, resultCode, data)
  }

}

private val log = LoggerFactory.getLogger(MenuListFragment::class.java)
