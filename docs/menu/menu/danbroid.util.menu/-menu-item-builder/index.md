//[menu](../../../index.md)/[danbroid.util.menu](../index.md)/[MenuItemBuilder](index.md)

# MenuItemBuilder

[androidJvm]\
class [MenuItemBuilder](index.md)(**context**: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) : [MenuBuilder](../-menu-builder/index.md)

## Functions

| Name | Summary |
|---|---|
| [addChild](../-menu-builder/add-child.md) | [androidJvm]<br>open fun [addChild](../-menu-builder/add-child.md)(child: [MenuBuilder](../-menu-builder/index.md)) |
| [createItem](create-item.md) | [androidJvm]<br>suspend fun [createItem](create-item.md)(fragment: [Fragment](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html), itemID: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = id, depth: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1): [MenuItem](../-menu-item/index.md) |
| [depthFirst](../-menu-builder/depth-first.md) | [androidJvm]<br>fun [depthFirst](../-menu-builder/depth-first.md)(): [Sequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.sequences/-sequence/index.html)<[MenuBuilder](../-menu-builder/index.md)> |
| [requireContext](../-menu-builder/require-context.md) | [androidJvm]<br>fun [requireContext](../-menu-builder/require-context.md)(): [Context](https://developer.android.com/reference/kotlin/android/content/Context.html) |
| [toString](to-string.md) | [androidJvm]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [children](index.md#233103599%2FProperties%2F1173194265) | [androidJvm]<br>var [children](index.md#233103599%2FProperties%2F1173194265): [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)<[MenuBuilder](../-menu-builder/index.md)>? = null |
| [contextMenu](index.md#1658623966%2FProperties%2F1173194265) | [androidJvm]<br>var [contextMenu](index.md#1658623966%2FProperties%2F1173194265): [ContextMenuProvider](../index.md#1636045883%2FClasslikes%2F1173194265)? = null |
| [icon](index.md#-130863051%2FProperties%2F1173194265) | [androidJvm]<br>open var [icon](index.md#-130863051%2FProperties%2F1173194265): [DrawableProvider](../index.md#-1166866407%2FClasslikes%2F1173194265)? = null |
| [id](index.md#-531072493%2FProperties%2F1173194265) | [androidJvm]<br>open lateinit var [id](index.md#-531072493%2FProperties%2F1173194265): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [imageID](index.md#675158102%2FProperties%2F1173194265) | [androidJvm]<br>@[DrawableRes](https://developer.android.com/reference/kotlin/androidx/annotation/DrawableRes.html)()<br>open var [imageID](index.md#675158102%2FProperties%2F1173194265): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0 |
| [imageURI](index.md#1534310685%2FProperties%2F1173194265) | [androidJvm]<br>var [imageURI](index.md#1534310685%2FProperties%2F1173194265): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [inlineChildren](index.md#-998869866%2FProperties%2F1173194265) | [androidJvm]<br>open var [inlineChildren](index.md#-998869866%2FProperties%2F1173194265): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false |
| [isBrowsable](index.md#1316370209%2FProperties%2F1173194265) | [androidJvm]<br>open var [isBrowsable](index.md#1316370209%2FProperties%2F1173194265): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false |
| [isVisible](index.md#-1071760220%2FProperties%2F1173194265) | [androidJvm]<br>open var [isVisible](index.md#-1071760220%2FProperties%2F1173194265): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true |
| [onClick](on-click.md) | [androidJvm]<br>var [onClick](on-click.md): [MenuItemClickHandler](../index.md#-585949676%2FClasslikes%2F1173194265)? = null |
| [onCreate](on-create.md) | [androidJvm]<br>var [onCreate](on-create.md): [MenuItemOnCreated](../index.md#2071487011%2FClasslikes%2F1173194265)? = null |
| [onLongClick](on-long-click.md) | [androidJvm]<br>var [onLongClick](on-long-click.md): [MenuItemClickHandler](../index.md#-585949676%2FClasslikes%2F1173194265)? = null |
| [provides](index.md#-196149156%2FProperties%2F1173194265) | [androidJvm]<br>var [provides](index.md#-196149156%2FProperties%2F1173194265): ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -> [MenuBuilder](../-menu-builder/index.md)? |
| [roundedCorners](rounded-corners.md) | [androidJvm]<br>var [roundedCorners](rounded-corners.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true |
| [subtitle](index.md#2040582390%2FProperties%2F1173194265) | [androidJvm]<br>open var [subtitle](index.md#2040582390%2FProperties%2F1173194265): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [subtitleID](index.md#-2115878405%2FProperties%2F1173194265) | [androidJvm]<br>@[StringRes](https://developer.android.com/reference/kotlin/androidx/annotation/StringRes.html)()<br>open var [subtitleID](index.md#-2115878405%2FProperties%2F1173194265): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0 |
| [tintRes](tint-res.md) | [androidJvm]<br>@[ColorRes](https://developer.android.com/reference/kotlin/androidx/annotation/ColorRes.html)()<br>var [tintRes](tint-res.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0 |
| [title](index.md#-1838600268%2FProperties%2F1173194265) | [androidJvm]<br>open var [title](index.md#-1838600268%2FProperties%2F1173194265): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [titleID](index.md#-1978799815%2FProperties%2F1173194265) | [androidJvm]<br>@[StringRes](https://developer.android.com/reference/kotlin/androidx/annotation/StringRes.html)()<br>open var [titleID](index.md#-1978799815%2FProperties%2F1173194265): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0 |
