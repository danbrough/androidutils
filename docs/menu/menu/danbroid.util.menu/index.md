//[menu](../index.md)/[danbroid.util.menu](index.md)



# Package danbroid.util.menu  


## Types  
  
|  Name|  Summary| 
|---|---|
| [ContentManager](-content-manager/index.md)| [androidJvm]  <br>Content  <br>class [ContentManager](-content-manager/index.md)(**context**: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) : Singleton<[Context](https://developer.android.com/reference/kotlin/android/content/Context.html)>   <br><br><br>
| [LiveChildrenProducer](index.md#danbroid.util.menu/LiveChildrenProducer///PointingToDeclaration/)| [androidJvm]  <br>Content  <br>typealias [LiveChildrenProducer](index.md#danbroid.util.menu/LiveChildrenProducer///PointingToDeclaration/) = [SuspendFunction3](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-suspend-function3/index.html)<[Context](https://developer.android.com/reference/kotlin/android/content/Context.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [MenuItem](-menu-item/index.md)?, [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[MenuItem](-menu-item/index.md)>?>  <br><br><br>
| [LiveItemProducer](index.md#danbroid.util.menu/LiveItemProducer///PointingToDeclaration/)| [androidJvm]  <br>Content  <br>typealias [LiveItemProducer](index.md#danbroid.util.menu/LiveItemProducer///PointingToDeclaration/) = [SuspendFunction3](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-suspend-function3/index.html)<[Context](https://developer.android.com/reference/kotlin/android/content/Context.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [MenuItem](-menu-item/index.md)?, [MenuItem](-menu-item/index.md)?>  <br><br><br>
| [MenuActionContext](-menu-action-context/index.md)| [androidJvm]  <br>Content  <br>class [MenuActionContext](-menu-action-context/index.md)(**context**: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), **menuItem**: [MenuItem](-menu-item/index.md), **fragment**: [Fragment](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html)?)  <br><br><br>
| [MenuBuilder](-menu-builder/index.md)| [androidJvm]  <br>Content  <br>open class [MenuBuilder](-menu-builder/index.md)  <br><br><br>
| [MenuDSL](-menu-d-s-l/index.md)| [androidJvm]  <br>Content  <br>@[DslMarker](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-dsl-marker/index.html)()  <br>  <br>annotation class [MenuDSL](-menu-d-s-l/index.md)  <br><br><br>
| [MenuItem](-menu-item/index.md)| [androidJvm]  <br>Content  <br>data class [MenuItem](-menu-item/index.md)(**id**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **title**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **subtitle**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **imageURI**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, @[MenuRes](https://developer.android.com/reference/kotlin/androidx/annotation/MenuRes.html)()**menuID**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), @[MenuRes](https://developer.android.com/reference/kotlin/androidx/annotation/MenuRes.html)()**contextMenuID**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), **isBrowsable**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), **isVisible**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), **inlineChildren**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), **menuItemBuilder**: [MenuItemBuilder](-menu-item-builder/index.md)?, @[ColorRes](https://developer.android.com/reference/kotlin/androidx/annotation/ColorRes.html)()**tint**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))  <br><br><br>
| [MenuItemBuilder](-menu-item-builder/index.md)| [androidJvm]  <br>Content  <br>class [MenuItemBuilder](-menu-item-builder/index.md) : [MenuBuilder](-menu-builder/index.md)  <br><br><br>
| [MenuItemClickHandler](index.md#danbroid.util.menu/MenuItemClickHandler///PointingToDeclaration/)| [androidJvm]  <br>Content  <br>typealias [MenuItemClickHandler](index.md#danbroid.util.menu/MenuItemClickHandler///PointingToDeclaration/) = [SuspendFunction2](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-suspend-function2/index.html)<[MenuActionContext](-menu-action-context/index.md), ([Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)>  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [find](find.md)| [androidJvm]  <br>Content  <br>inline fun <[T](find.md) : [MenuBuilder](-menu-builder/index.md)> [T](find.md).[find](find.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [T](find.md)?  <br><br><br>
| [menu](menu.md)| [androidJvm]  <br>Content  <br>inline fun <[T](menu.md) : [MenuBuilder](-menu-builder/index.md)> [T](menu.md).[menu](menu.md)(child: [T](menu.md), block: [T](menu.md).() -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [T](menu.md)  <br><br><br>
| [rootMenu](root-menu.md)| [androidJvm]  <br>Content  <br>inline fun <[T](root-menu.md) : [MenuBuilder](-menu-builder/index.md)> [rootMenu](root-menu.md)(builder: [T](root-menu.md), block: [T](root-menu.md).() -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [T](root-menu.md)  <br><br><br>

