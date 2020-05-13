package danbroid.util.demo.menu

import android.widget.Toast
import danbroid.menu.MenuItemBuilder
import danbroid.menu.menu
import danbroid.menu.rootMenu

val rootContent = rootMenu<MenuItemBuilder> {
  menu {
    title = "First Menu"
    onClick = {
      Toast.makeText(context,"Clicked the first menu",Toast.LENGTH_SHORT).show()
    }
  }
}