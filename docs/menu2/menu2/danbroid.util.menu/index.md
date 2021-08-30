//[menu2](../../index.md)/[danbroid.util.menu](index.md)

# Package danbroid.util.menu

## Types

| Name | Summary |
|---|---|
| [AppIcon](-app-icon/index.md) | [androidJvm]<br>interface [AppIcon](-app-icon/index.md)<[T](-app-icon/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<[T](-app-icon/index.md)>> |
| [Menu](-menu/index.md) | [androidJvm]<br>data class [Menu](-menu/index.md)(**id**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **title**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **subTitle**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **iconUrl**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, **isBrowsable**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), **isPlayable**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), **isHidden**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), **onClicked**: suspend [MenuContext](../danbroid.util.menu.ui/-menu-context/index.md).() -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)?) |
| [MenuDSL](-menu-d-s-l/index.md) | [androidJvm]<br>@[DslMarker](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-dsl-marker/index.html)()<br>annotation class [MenuDSL](-menu-d-s-l/index.md) |
| [MenuLoader](-menu-loader/index.md) | [androidJvm]<br>interface [MenuLoader](-menu-loader/index.md) |
| [MenuModel](-menu-model/index.md) | [androidJvm]<br>open class [MenuModel](-menu-model/index.md)(**menuID**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **context**: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html) |
| [MenuModelFactory](-menu-model-factory/index.md) | [androidJvm]<br>class [MenuModelFactory](-menu-model-factory/index.md)(**menuID**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **context**: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) : [ViewModelProvider.NewInstanceFactory](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModelProvider.NewInstanceFactory.html) |
| [Menus](-menus/index.md) | [androidJvm]<br>data class [Menus](-menus/index.md)(**title**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **menus**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Menu](-menu/index.md)>) |
| [MenuState](-menu-state/index.md) | [androidJvm]<br>sealed class [MenuState](-menu-state/index.md) |
| [RootMenuLoader](-root-menu-loader/index.md) | [androidJvm]<br>object [RootMenuLoader](-root-menu-loader/index.md) : [MenuLoader](-menu-loader/index.md) |

## Functions

| Name | Summary |
|---|---|
| [menuModel](menu-model.md) | [androidJvm]<br>@Composable()<br>inline fun <[T](menu-model.md) : [MenuModel](-menu-model/index.md)> [menuModel](menu-model.md)(menuID: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [T](menu-model.md) |
| [menuNavRoute](menu-nav-route.md) | [androidJvm]<br>fun [menuNavRoute](menu-nav-route.md)(menuID: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [navRoute](nav-route.md) | [androidJvm]<br>val [Menu](-menu/index.md).[navRoute](nav-route.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
