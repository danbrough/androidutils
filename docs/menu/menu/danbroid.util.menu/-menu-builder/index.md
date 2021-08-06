//[menu](../../../index.md)/[danbroid.util.menu](../index.md)/[MenuBuilder](index.md)

# MenuBuilder

[androidJvm]\
open class [MenuBuilder](index.md)(**context**: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html))

## Functions

| Name | Summary |
|---|---|
| [addChild](add-child.md) | [androidJvm]<br>open fun [addChild](add-child.md)(child: [MenuBuilder](index.md)) |
| [depthFirst](depth-first.md) | [androidJvm]<br>fun [depthFirst](depth-first.md)(): [Sequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.sequences/-sequence/index.html)<[MenuBuilder](index.md)> |
| [requireContext](require-context.md) | [androidJvm]<br>fun [requireContext](require-context.md)(): [Context](https://developer.android.com/reference/kotlin/android/content/Context.html) |

## Properties

| Name | Summary |
|---|---|
| [children](children.md) | [androidJvm]<br>var [children](children.md): [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)<[MenuBuilder](index.md)>? = null |
| [contextMenu](context-menu.md) | [androidJvm]<br>var [contextMenu](context-menu.md): [ContextMenuProvider](../index.md#1636045883%2FClasslikes%2F1173194265)? = null |
| [icon](icon.md) | [androidJvm]<br>open var [icon](icon.md): [DrawableProvider](../index.md#-1166866407%2FClasslikes%2F1173194265)? = null |
| [id](id.md) | [androidJvm]<br>open lateinit var [id](id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [imageID](image-i-d.md) | [androidJvm]<br>@[DrawableRes](https://developer.android.com/reference/kotlin/androidx/annotation/DrawableRes.html)()<br>open var [imageID](image-i-d.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0 |
| [imageURI](image-u-r-i.md) | [androidJvm]<br>var [imageURI](image-u-r-i.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [inlineChildren](inline-children.md) | [androidJvm]<br>open var [inlineChildren](inline-children.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false |
| [isBrowsable](is-browsable.md) | [androidJvm]<br>open var [isBrowsable](is-browsable.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false |
| [isVisible](is-visible.md) | [androidJvm]<br>open var [isVisible](is-visible.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true |
| [provides](provides.md) | [androidJvm]<br>var [provides](provides.md): ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -> [MenuBuilder](index.md)? |
| [subtitle](subtitle.md) | [androidJvm]<br>open var [subtitle](subtitle.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [subtitleID](subtitle-i-d.md) | [androidJvm]<br>@[StringRes](https://developer.android.com/reference/kotlin/androidx/annotation/StringRes.html)()<br>open var [subtitleID](subtitle-i-d.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0 |
| [title](title.md) | [androidJvm]<br>open var [title](title.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [titleID](title-i-d.md) | [androidJvm]<br>@[StringRes](https://developer.android.com/reference/kotlin/androidx/annotation/StringRes.html)()<br>open var [titleID](title-i-d.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0 |

## Inheritors

| Name |
|---|
| [MenuItemBuilder](../-menu-item-builder/index.md) |
