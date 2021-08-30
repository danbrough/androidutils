package danbroid.util.menu

import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.Serializable

@Serializable
sealed class MenuState {
  @Serializable
  data class LOADING(val title: String) : MenuState()

  @Serializable
  data class LOADED(val title: String, val menus: List<Menu>) : MenuState()

  @Serializable
  data class ERROR(val message: String) : MenuState()
}


interface MenuLoader {
  fun loadMenus(menuID: String): Flow<MenuState>?
}

object RootMenuLoader : MenuLoader {

  private val registry = mutableListOf<MenuLoader>()

  fun register(vararg loaders: MenuLoader) =
    synchronized(this) {
      loaders.forEach {
        if (!registry.contains(it))
          registry.add(it)
      }
    }


  override fun loadMenus(menuID: String): Flow<MenuState>? =
    registry.firstNotNullOfOrNull {
      it.loadMenus(menuID)
    }


}