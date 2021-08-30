package danbroid.util.menu


import danbroid.util.format.uriEncode
import danbroid.util.menu.ui.MenuContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlin.reflect.KProperty

@DslMarker
annotation class MenuDSL

@Serializable
data class Menu(
  var id: String,
  var title: String,
  var subTitle: String = "",
  var iconUrl: String? = null,
  var isBrowsable: Boolean = false,
  var isPlayable: Boolean = false,
  var isHidden: Boolean = false,
  @Transient
  var onClicked: (suspend MenuContext.() -> Unit)? = null,
) {
  @Transient
  private var iconData: Any? = null

  private object IconProperty {

    operator fun getValue(menu: Menu, property: KProperty<*>): Any? {
      AppIcon.lookupIcon(menu.iconData)?.also {
        return it
      }
      AppIcon.lookupIcon(menu.iconUrl)?.also {
        return it
      }
      return menu.iconData ?: menu.iconUrl
    }

    operator fun setValue(menu: Menu, property: KProperty<*>, value: Any?) {
      when (value) {
        is CharSequence -> menu.iconUrl = value.toString()
        is AppIcon<*> -> menu.iconUrl = value.uri
      }
      menu.iconData = value
    }

  }

  var icon: Any? by IconProperty
}

@Serializable
data class Menus(val title: String, val menus: List<Menu>)

fun menuNavRoute(menuID:String) = "menu?id=${menuID.uriEncode()}"

val Menu.navRoute: String
  get() = menuNavRoute(id)



//private val log = danbroid.logging.getLog(Menu::class)
