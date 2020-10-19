//[menu](../../index.md)/[danbroid.util.menu](../index.md)/[MenuBuilder](index.md)



# MenuBuilder  
 [androidJvm] open class [MenuBuilder](index.md)   


## Functions  
  
|  Name|  Summary| 
|---|---|
| [addChild](add-child.md)| [androidJvm]  <br>Content  <br>open fun [addChild](add-child.md)(child: [MenuBuilder](index.md))  <br><br><br>
| [depthFirst](depth-first.md)| [androidJvm]  <br>Content  <br>fun [depthFirst](depth-first.md)(): [Sequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.sequences/-sequence/index.html)<[MenuBuilder](index.md)>  <br><br><br>
| [equals](../../danbroid.util.menu.ui/-menu-item-diff-callback/index.md#kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>open operator override fun [equals](../../danbroid.util.menu.ui/-menu-item-diff-callback/index.md#kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](../../danbroid.util.menu.ui/-menu-item-diff-callback/index.md#kotlin/Any/hashCode/#/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>open override fun [hashCode](../../danbroid.util.menu.ui/-menu-item-diff-callback/index.md#kotlin/Any/hashCode/#/PointingToDeclaration/)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toString](../../danbroid.util.menu.ui/-menu-item-diff-callback/index.md#kotlin/Any/toString/#/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>open override fun [toString](../../danbroid.util.menu.ui/-menu-item-diff-callback/index.md#kotlin/Any/toString/#/PointingToDeclaration/)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [children](index.md#danbroid.util.menu/MenuBuilder/children/#/PointingToDeclaration/)|  [androidJvm] var [children](index.md#danbroid.util.menu/MenuBuilder/children/#/PointingToDeclaration/): [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)<[MenuBuilder](index.md)>?   <br>
| [contextMenuID](index.md#danbroid.util.menu/MenuBuilder/contextMenuID/#/PointingToDeclaration/)|  [androidJvm] @[MenuRes](https://developer.android.com/reference/kotlin/androidx/annotation/MenuRes.html)()  <br>  <br>var [contextMenuID](index.md#danbroid.util.menu/MenuBuilder/contextMenuID/#/PointingToDeclaration/): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)   <br>
| [icon](index.md#danbroid.util.menu/MenuBuilder/icon/#/PointingToDeclaration/)|  [androidJvm] open var [icon](index.md#danbroid.util.menu/MenuBuilder/icon/#/PointingToDeclaration/): [DrawableProvider](../index.md#danbroid.util.menu/DrawableProvider///PointingToDeclaration/)?   <br>
| [id](index.md#danbroid.util.menu/MenuBuilder/id/#/PointingToDeclaration/)|  [androidJvm] open lateinit var [id](index.md#danbroid.util.menu/MenuBuilder/id/#/PointingToDeclaration/): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)   <br>
| [imageID](index.md#danbroid.util.menu/MenuBuilder/imageID/#/PointingToDeclaration/)|  [androidJvm] @[DrawableRes](https://developer.android.com/reference/kotlin/androidx/annotation/DrawableRes.html)()  <br>  <br>open var [imageID](index.md#danbroid.util.menu/MenuBuilder/imageID/#/PointingToDeclaration/): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)   <br>
| [imageURI](index.md#danbroid.util.menu/MenuBuilder/imageURI/#/PointingToDeclaration/)|  [androidJvm] var [imageURI](index.md#danbroid.util.menu/MenuBuilder/imageURI/#/PointingToDeclaration/): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?   <br>
| [inlineChildren](index.md#danbroid.util.menu/MenuBuilder/inlineChildren/#/PointingToDeclaration/)|  [androidJvm] open var [inlineChildren](index.md#danbroid.util.menu/MenuBuilder/inlineChildren/#/PointingToDeclaration/): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>
| [isBrowsable](index.md#danbroid.util.menu/MenuBuilder/isBrowsable/#/PointingToDeclaration/)|  [androidJvm] open var [isBrowsable](index.md#danbroid.util.menu/MenuBuilder/isBrowsable/#/PointingToDeclaration/): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>
| [isVisible](index.md#danbroid.util.menu/MenuBuilder/isVisible/#/PointingToDeclaration/)|  [androidJvm] open var [isVisible](index.md#danbroid.util.menu/MenuBuilder/isVisible/#/PointingToDeclaration/): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>
| [provides](index.md#danbroid.util.menu/MenuBuilder/provides/#/PointingToDeclaration/)|  [androidJvm] var [provides](index.md#danbroid.util.menu/MenuBuilder/provides/#/PointingToDeclaration/): ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -> [MenuBuilder](index.md)?   <br>
| [subtitle](index.md#danbroid.util.menu/MenuBuilder/subtitle/#/PointingToDeclaration/)|  [androidJvm] open var [subtitle](index.md#danbroid.util.menu/MenuBuilder/subtitle/#/PointingToDeclaration/): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)   <br>
| [subtitleID](index.md#danbroid.util.menu/MenuBuilder/subtitleID/#/PointingToDeclaration/)|  [androidJvm] @[StringRes](https://developer.android.com/reference/kotlin/androidx/annotation/StringRes.html)()  <br>  <br>open var [subtitleID](index.md#danbroid.util.menu/MenuBuilder/subtitleID/#/PointingToDeclaration/): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)   <br>
| [title](index.md#danbroid.util.menu/MenuBuilder/title/#/PointingToDeclaration/)|  [androidJvm] open var [title](index.md#danbroid.util.menu/MenuBuilder/title/#/PointingToDeclaration/): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?   <br>
| [titleID](index.md#danbroid.util.menu/MenuBuilder/titleID/#/PointingToDeclaration/)|  [androidJvm] @[StringRes](https://developer.android.com/reference/kotlin/androidx/annotation/StringRes.html)()  <br>  <br>open var [titleID](index.md#danbroid.util.menu/MenuBuilder/titleID/#/PointingToDeclaration/): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)   <br>


## Inheritors  
  
|  Name| 
|---|
| [MenuItemBuilder](../-menu-item-builder/index.md)

