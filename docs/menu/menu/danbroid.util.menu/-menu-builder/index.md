//[menu](../../../index.md)/[danbroid.util.menu](../index.md)/[MenuBuilder](index.md)



# MenuBuilder  
 [androidJvm] open class [MenuBuilder](index.md)(**context**: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html))   


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="danbroid.util.menu/MenuBuilder/addChild/#danbroid.util.menu.MenuBuilder/PointingToDeclaration/"></a>[addChild](add-child.md)| <a name="danbroid.util.menu/MenuBuilder/addChild/#danbroid.util.menu.MenuBuilder/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [addChild](add-child.md)(child: [MenuBuilder](index.md))  <br><br><br>|
| <a name="danbroid.util.menu/MenuBuilder/depthFirst/#/PointingToDeclaration/"></a>[depthFirst](depth-first.md)| <a name="danbroid.util.menu/MenuBuilder/depthFirst/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [depthFirst](depth-first.md)(): [Sequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.sequences/-sequence/index.html)<[MenuBuilder](index.md)>  <br><br><br>|
| <a name="danbroid.util.menu/MenuBuilder/requireContext/#/PointingToDeclaration/"></a>[requireContext](require-context.md)| <a name="danbroid.util.menu/MenuBuilder/requireContext/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [requireContext](require-context.md)(): [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)  <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="danbroid.util.menu/MenuBuilder/children/#/PointingToDeclaration/"></a>[children](children.md)| <a name="danbroid.util.menu/MenuBuilder/children/#/PointingToDeclaration/"></a> [androidJvm] var [children](children.md): [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)<[MenuBuilder](index.md)>? = null   <br>|
| <a name="danbroid.util.menu/MenuBuilder/contextMenu/#/PointingToDeclaration/"></a>[contextMenu](context-menu.md)| <a name="danbroid.util.menu/MenuBuilder/contextMenu/#/PointingToDeclaration/"></a> [androidJvm] var [contextMenu](context-menu.md): [ContextMenuProvider](../index.md#%5Bdanbroid.util.menu%2FContextMenuProvider%2F%2F%2FPointingToDeclaration%2F%5D%2FClasslikes%2F1967064354)? = null   <br>|
| <a name="danbroid.util.menu/MenuBuilder/icon/#/PointingToDeclaration/"></a>[icon](icon.md)| <a name="danbroid.util.menu/MenuBuilder/icon/#/PointingToDeclaration/"></a> [androidJvm] open var [icon](icon.md): [DrawableProvider](../index.md#%5Bdanbroid.util.menu%2FDrawableProvider%2F%2F%2FPointingToDeclaration%2F%5D%2FClasslikes%2F1967064354)? = null   <br>|
| <a name="danbroid.util.menu/MenuBuilder/id/#/PointingToDeclaration/"></a>[id](id.md)| <a name="danbroid.util.menu/MenuBuilder/id/#/PointingToDeclaration/"></a> [androidJvm] open lateinit var [id](id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)   <br>|
| <a name="danbroid.util.menu/MenuBuilder/imageID/#/PointingToDeclaration/"></a>[imageID](image-i-d.md)| <a name="danbroid.util.menu/MenuBuilder/imageID/#/PointingToDeclaration/"></a> [androidJvm] @[DrawableRes](https://developer.android.com/reference/kotlin/androidx/annotation/DrawableRes.html)()  <br>  <br>open var [imageID](image-i-d.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0   <br>|
| <a name="danbroid.util.menu/MenuBuilder/imageURI/#/PointingToDeclaration/"></a>[imageURI](image-u-r-i.md)| <a name="danbroid.util.menu/MenuBuilder/imageURI/#/PointingToDeclaration/"></a> [androidJvm] var [imageURI](image-u-r-i.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null   <br>|
| <a name="danbroid.util.menu/MenuBuilder/inlineChildren/#/PointingToDeclaration/"></a>[inlineChildren](inline-children.md)| <a name="danbroid.util.menu/MenuBuilder/inlineChildren/#/PointingToDeclaration/"></a> [androidJvm] open var [inlineChildren](inline-children.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false   <br>|
| <a name="danbroid.util.menu/MenuBuilder/isBrowsable/#/PointingToDeclaration/"></a>[isBrowsable](is-browsable.md)| <a name="danbroid.util.menu/MenuBuilder/isBrowsable/#/PointingToDeclaration/"></a> [androidJvm] open var [isBrowsable](is-browsable.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false   <br>|
| <a name="danbroid.util.menu/MenuBuilder/isVisible/#/PointingToDeclaration/"></a>[isVisible](is-visible.md)| <a name="danbroid.util.menu/MenuBuilder/isVisible/#/PointingToDeclaration/"></a> [androidJvm] open var [isVisible](is-visible.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true   <br>|
| <a name="danbroid.util.menu/MenuBuilder/provides/#/PointingToDeclaration/"></a>[provides](provides.md)| <a name="danbroid.util.menu/MenuBuilder/provides/#/PointingToDeclaration/"></a> [androidJvm] var [provides](provides.md): ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -> [MenuBuilder](index.md)?   <br>|
| <a name="danbroid.util.menu/MenuBuilder/subtitle/#/PointingToDeclaration/"></a>[subtitle](subtitle.md)| <a name="danbroid.util.menu/MenuBuilder/subtitle/#/PointingToDeclaration/"></a> [androidJvm] open var [subtitle](subtitle.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)   <br>|
| <a name="danbroid.util.menu/MenuBuilder/subtitleID/#/PointingToDeclaration/"></a>[subtitleID](subtitle-i-d.md)| <a name="danbroid.util.menu/MenuBuilder/subtitleID/#/PointingToDeclaration/"></a> [androidJvm] @[StringRes](https://developer.android.com/reference/kotlin/androidx/annotation/StringRes.html)()  <br>  <br>open var [subtitleID](subtitle-i-d.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0   <br>|
| <a name="danbroid.util.menu/MenuBuilder/title/#/PointingToDeclaration/"></a>[title](title.md)| <a name="danbroid.util.menu/MenuBuilder/title/#/PointingToDeclaration/"></a> [androidJvm] open var [title](title.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null   <br>|
| <a name="danbroid.util.menu/MenuBuilder/titleID/#/PointingToDeclaration/"></a>[titleID](title-i-d.md)| <a name="danbroid.util.menu/MenuBuilder/titleID/#/PointingToDeclaration/"></a> [androidJvm] @[StringRes](https://developer.android.com/reference/kotlin/androidx/annotation/StringRes.html)()  <br>  <br>open var [titleID](title-i-d.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0   <br>|


## Inheritors  
  
|  Name | 
|---|
| <a name="danbroid.util.menu/MenuItemBuilder///PointingToDeclaration/"></a>[MenuItemBuilder](../-menu-item-builder/index.md)|

