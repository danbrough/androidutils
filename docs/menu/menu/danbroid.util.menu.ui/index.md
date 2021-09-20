//[menu](../../index.md)/[danbroid.util.menu.ui](index.md)

# Package danbroid.util.menu.ui

## Types

| Name | Summary |
|---|---|
| [MenuContext](-menu-context/index.md) | [androidJvm]<br>open class [MenuContext](-menu-context/index.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), navController: [NavHostController](https://developer.android.com/reference/kotlin/androidx/navigation/NavHostController.html), snackbarHostState: SnackbarHostState?) |

## Functions

| Name | Summary |
|---|---|
| [IconImage](-icon-image.md) | [androidJvm]<br>@Composable<br>fun [IconImage](-icon-image.md)(imageUrl: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), contentDescription: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, modifier: Modifier = Modifier) |
| [menu](menu.md) | [androidJvm]<br>inline fun LazyListScope.[menu](menu.md)(menu: [Menu](../danbroid.util.menu/-menu/index.md), sticky: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, highLighted: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, clickable: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true)<br>inline fun LazyListScope.[menu](menu.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = "_${MenuContext.NEXT_ID++}", menu: [Menu](../danbroid.util.menu/-menu/index.md) = Menu(id, "Untitled"), sticky: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, highLighted: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, clickable: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, crossinline onCreate: @Composable[Menu](../danbroid.util.menu/-menu/index.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [MenuListIcon](-menu-list-icon.md) | [androidJvm]<br>@Composable<br>fun [MenuListIcon](-menu-list-icon.md)(_icon: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?, title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = "") |
| [MenuListItemImpl](-menu-list-item-impl.md) | [androidJvm]<br>@Composable<br>fun [MenuListItemImpl](-menu-list-item-impl.md)(modifier: Modifier, title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), subTitle: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), _icon: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?, highLighted: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false) |
| [Menus](-menus.md) | [androidJvm]<br>@Composable<br>fun [Menus](-menus.md)(menuState: [MenuState](../danbroid.util.menu/-menu-state/index.md)) |
| [menuScreen](menu-screen.md) | [androidJvm]<br>@Composable<br>fun [menuScreen](menu-screen.md)(block: LazyListScope.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [Test](-test.md) | [androidJvm]<br>@Composable<br>@Preview<br>fun [Test](-test.md)() |

## Properties

| Name | Summary |
|---|---|
| [LocalMenuContext](-local-menu-context.md) | [androidJvm]<br>val [LocalMenuContext](-local-menu-context.md): ProvidableCompositionLocal&lt;[MenuContext](-menu-context/index.md)&gt; |
