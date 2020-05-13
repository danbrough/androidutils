package danbroid.util.menu
import androidx.annotation.DrawableRes
import androidx.annotation.MenuRes
import androidx.annotation.StringRes
import kotlin.reflect.full.createInstance

@DslMarker
annotation class MenuDSL

open class MenuBuilder {

  @MenuDSL
  open var id: String? = null

  @MenuDSL
  var title: String? = null
    set(value) {
      field = value
      titleID = 0
    }

  @MenuDSL
  @StringRes
  var titleID: Int = 0

  @MenuDSL
  var subtitle: String = ""
    set(value) {
      field = value
      subtitleID = 0
    }

  @MenuDSL
  @StringRes
  var subtitleID: Int = 0

  @MenuDSL
  var imageURI: String? = null
    set(value) {
      field = value
      imageID = 0
    }

  @MenuDSL
  @DrawableRes
  var imageID: Int = 0

  @MenuDSL
  @MenuRes
  var menuID: Int = 0


  @MenuDSL
  @MenuRes
  var contextMenuID: Int = 0

  @MenuDSL
  var isBrowsable = false
    get() = field || !children.isNullOrEmpty()

  @MenuDSL
  var isVisible = true

  @MenuDSL
  var inlineChildren = false


  @MenuDSL
  var provides: ((String) -> MenuBuilder?) = {
    if (it == id) this else null
  }

  var children: MutableList<MenuBuilder>? = null

  open fun addChild(child: MenuBuilder) {
    // log.error("addChild() $id -> child: ${child.id}")
    isBrowsable = true
    val childBuilders = children ?: mutableListOf<MenuBuilder>().also {
      children = it
    }
    childBuilders.add(child)
  }

  fun depthFirst(): Sequence<MenuBuilder> = sequence {
    yield(this@MenuBuilder)
    children?.forEach {
      yieldAll(it.depthFirst())
    }
  }

}

@Suppress("UNCHECKED_CAST")
inline fun <reified T : MenuBuilder> T.find(id: String): T? {
  depthFirst().forEach {
    it.provides.invoke(id)?.also {
      return it as T
    }
  }
  return null
}


@MenuDSL
inline fun <reified T : MenuBuilder> T.menu(
    child: T = T::class.createInstance(),
    block: T.() -> Unit
) {
  addChild(child)
  if (child.id == null) {
    child.id = if (id!!.endsWith('/')) "$id${children!!.size}" else "${id}/${children!!.size}"
  }
  child.block()
}


@MenuDSL
inline fun <reified T : MenuBuilder> rootMenu(
    builder: T = T::class.createInstance(),
    block: T.() -> Unit
) = builder.apply(block)


private val log = org.slf4j.LoggerFactory.getLogger(MenuBuilder::class.java)
