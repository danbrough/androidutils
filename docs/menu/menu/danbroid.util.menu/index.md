//[menu](../index.md)/[danbroid.util.menu](index.md)



# Package danbroid.util.menu  


## Types  
  
|  Name|  Summary| 
|---|---|
| [DrawableProvider](index.md#danbroid.util.menu/DrawableProvider///PointingToDeclaration/)| [androidJvm]  <br>Content  <br>typealias [DrawableProvider](index.md#danbroid.util.menu/DrawableProvider///PointingToDeclaration/) = [Context](https://developer.android.com/reference/kotlin/android/content/Context.html).() -> [Drawable](https://developer.android.com/reference/kotlin/android/graphics/drawable/Drawable.html)?  <br><br><br>
| [Icons](-icons/index.md)| [androidJvm]  <br>Content  <br>object [Icons](-icons/index.md)  <br><br><br>
| [LiveItemProducer](index.md#danbroid.util.menu/LiveItemProducer///PointingToDeclaration/)| [androidJvm]  <br>Content  <br>typealias [LiveItemProducer](index.md#danbroid.util.menu/LiveItemProducer///PointingToDeclaration/) = [SuspendFunction3](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-suspend-function3/index.html)<[Fragment](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html), [MenuItem](-menu-item/index.md), [MenuModel](../danbroid.util.menu.model/-menu-model/index.md), [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)>  <br><br><br>
| [MenuActivity](-menu-activity/index.md)| [androidJvm]  <br>Content  <br>abstract class [MenuActivity](-menu-activity/index.md)(@[LayoutRes](https://developer.android.com/reference/kotlin/androidx/annotation/LayoutRes.html)()**layoutID**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) : [AppCompatActivity](https://developer.android.com/reference/kotlin/androidx/appcompat/app/AppCompatActivity.html)  <br><br><br>
| [MenuBuilder](-menu-builder/index.md)| [androidJvm]  <br>Content  <br>open class [MenuBuilder](-menu-builder/index.md)  <br><br><br>
| [MenuConfiguration](-menu-configuration/index.md)| [androidJvm]  <br>Content  <br>object [MenuConfiguration](-menu-configuration/index.md)  <br><br><br>
| [MenuDSL](-menu-d-s-l/index.md)| [androidJvm]  <br>Content  <br>@[DslMarker](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-dsl-marker/index.html)()  <br>  <br>annotation class [MenuDSL](-menu-d-s-l/index.md)  <br><br><br>
| [MenuItem](-menu-item/index.md)| [androidJvm]  <br>Content  <br>data class [MenuItem](-menu-item/index.md)(**id**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **title**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **subtitle**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **imageURI**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, **icon**: [Drawable](https://developer.android.com/reference/kotlin/android/graphics/drawable/Drawable.html)?, @[MenuRes](https://developer.android.com/reference/kotlin/androidx/annotation/MenuRes.html)()**contextMenuID**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), **isBrowsable**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), **isVisible**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), **inlineChildren**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), @[ColorRes](https://developer.android.com/reference/kotlin/androidx/annotation/ColorRes.html)()**tint**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), **roundedCorners**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))  <br><br><br>
| [MenuItemBuilder](-menu-item-builder/index.md)| [androidJvm]  <br>Content  <br>class [MenuItemBuilder](-menu-item-builder/index.md) : [MenuBuilder](-menu-builder/index.md)  <br><br><br>
| [MenuItemClickHandler](index.md#danbroid.util.menu/MenuItemClickHandler///PointingToDeclaration/)| [androidJvm]  <br>Content  <br>typealias [MenuItemClickHandler](index.md#danbroid.util.menu/MenuItemClickHandler///PointingToDeclaration/) = [SuspendFunction2](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-suspend-function2/index.html)<[Fragment](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html), ([Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)>  <br><br><br>
| [MenuNavGraph](-menu-nav-graph/index.md)| [androidJvm]  <br>Content  <br>object [MenuNavGraph](-menu-nav-graph/index.md) : UniqueIDS  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [createMenuNavGraph](create-menu-nav-graph.md)| [androidJvm]  <br>Content  <br>fun [NavController](https://developer.android.com/reference/kotlin/androidx/navigation/NavController.html).[createMenuNavGraph](create-menu-nav-graph.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), homeID: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), defaultMenuID: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), menuNavOptions: [NavOptionsBuilder](https://developer.android.com/reference/kotlin/androidx/navigation/NavOptionsBuilder.html).() -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), builder: [NavGraphBuilder](https://developer.android.com/reference/kotlin/androidx/navigation/NavGraphBuilder.html).() -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)?): [NavGraph](https://developer.android.com/reference/kotlin/androidx/navigation/NavGraph.html)  <br><br><br>
| [find](find.md)| [androidJvm]  <br>Content  <br>inline fun <[T](find.md) : [MenuBuilder](-menu-builder/index.md)> [T](find.md).[find](find.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [T](find.md)?  <br><br><br>
| [menu](menu.md)| [androidJvm]  <br>Content  <br>inline fun <[T](menu.md) : [MenuBuilder](-menu-builder/index.md)> [T](menu.md).[menu](menu.md)(child: [T](menu.md), block: [T](menu.md).() -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [T](menu.md)  <br><br><br>
| [navigateToHome](navigate-to-home.md)| [androidJvm]  <br>Content  <br>fun [NavController](https://developer.android.com/reference/kotlin/androidx/navigation/NavController.html).[navigateToHome](navigate-to-home.md)()  <br><br><br>
| [navigateToMenuID](navigate-to-menu-i-d.md)| [androidJvm]  <br>Content  <br>fun [NavController](https://developer.android.com/reference/kotlin/androidx/navigation/NavController.html).[navigateToMenuID](navigate-to-menu-i-d.md)(menuID: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))  <br><br><br>
| [rootMenu](root-menu.md)| [androidJvm]  <br>Content  <br>inline fun <[T](root-menu.md) : [MenuBuilder](-menu-builder/index.md)> [rootMenu](root-menu.md)(builder: [T](root-menu.md), block: [T](root-menu.md).() -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [T](root-menu.md)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [defaultMenuNavOptions](index.md#danbroid.util.menu//defaultMenuNavOptions/#/PointingToDeclaration/)|  [androidJvm] <br><br>Provides animations for menu transitions<br><br>val [defaultMenuNavOptions](index.md#danbroid.util.menu//defaultMenuNavOptions/#/PointingToDeclaration/): [NavOptionsBuilder](https://developer.android.com/reference/kotlin/androidx/navigation/NavOptionsBuilder.html).() -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)   <br>
| [MENU_TINT_DEFAULT](index.md#danbroid.util.menu//MENU_TINT_DEFAULT/#/PointingToDeclaration/)|  [androidJvm] const val [MENU_TINT_DEFAULT](index.md#danbroid.util.menu//MENU_TINT_DEFAULT/#/PointingToDeclaration/): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)   <br>
| [MENU_TINT_DISABLED](index.md#danbroid.util.menu//MENU_TINT_DISABLED/#/PointingToDeclaration/)|  [androidJvm] const val [MENU_TINT_DISABLED](index.md#danbroid.util.menu//MENU_TINT_DISABLED/#/PointingToDeclaration/): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)   <br>

