//[menu](../../index.md)/[danbroid.util.menu](../index.md)/[MenuItemBuilder](index.md)



# MenuItemBuilder  
 [androidJvm] class [MenuItemBuilder](index.md) : [MenuBuilder](../-menu-builder/index.md)   


## Functions  
  
|  Name|  Summary| 
|---|---|
| [addChild](../-menu-builder/add-child.md)| [androidJvm]  <br>Content  <br>open override fun [addChild](../-menu-builder/add-child.md)(child: [MenuBuilder](../-menu-builder/index.md))  <br><br><br>
| [createItem](create-item.md)| [androidJvm]  <br>Content  <br>fun [createItem](create-item.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), itemID: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), depth: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [MenuItem](../-menu-item/index.md)  <br><br><br>
| [depthFirst](../-menu-builder/depth-first.md)| [androidJvm]  <br>Content  <br>override fun [depthFirst](../-menu-builder/depth-first.md)(): [Sequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.sequences/-sequence/index.html)<[MenuBuilder](../-menu-builder/index.md)>  <br><br><br>
| [equals](../../danbroid.util.menu.ui/-menu-item-diff-callback/index.md#kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>open operator override fun [equals](../../danbroid.util.menu.ui/-menu-item-diff-callback/index.md#kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](../../danbroid.util.menu.ui/-menu-item-diff-callback/index.md#kotlin/Any/hashCode/#/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>open override fun [hashCode](../../danbroid.util.menu.ui/-menu-item-diff-callback/index.md#kotlin/Any/hashCode/#/PointingToDeclaration/)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toString](to-string.md)| [androidJvm]  <br>Content  <br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [children](index.md#danbroid.util.menu/MenuItemBuilder/children/#/PointingToDeclaration/)|  [androidJvm] override var [children](index.md#danbroid.util.menu/MenuItemBuilder/children/#/PointingToDeclaration/): [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)<[MenuBuilder](../-menu-builder/index.md)>?   <br>
| [contextMenuID](index.md#danbroid.util.menu/MenuItemBuilder/contextMenuID/#/PointingToDeclaration/)|  [androidJvm] @[MenuRes](https://developer.android.com/reference/kotlin/androidx/annotation/MenuRes.html)()  <br>  <br>override var [contextMenuID](index.md#danbroid.util.menu/MenuItemBuilder/contextMenuID/#/PointingToDeclaration/): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)   <br>
| [icon](index.md#danbroid.util.menu/MenuItemBuilder/icon/#/PointingToDeclaration/)|  [androidJvm] open override var [icon](index.md#danbroid.util.menu/MenuItemBuilder/icon/#/PointingToDeclaration/): [DrawableProvider](../index.md#danbroid.util.menu/DrawableProvider///PointingToDeclaration/)?   <br>
| [id](index.md#danbroid.util.menu/MenuItemBuilder/id/#/PointingToDeclaration/)|  [androidJvm] open lateinit override var [id](index.md#danbroid.util.menu/MenuItemBuilder/id/#/PointingToDeclaration/): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)   <br>
| [imageID](index.md#danbroid.util.menu/MenuItemBuilder/imageID/#/PointingToDeclaration/)|  [androidJvm] @[DrawableRes](https://developer.android.com/reference/kotlin/androidx/annotation/DrawableRes.html)()  <br>  <br>open override var [imageID](index.md#danbroid.util.menu/MenuItemBuilder/imageID/#/PointingToDeclaration/): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)   <br>
| [imageURI](index.md#danbroid.util.menu/MenuItemBuilder/imageURI/#/PointingToDeclaration/)|  [androidJvm] override var [imageURI](index.md#danbroid.util.menu/MenuItemBuilder/imageURI/#/PointingToDeclaration/): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?   <br>
| [inlineChildren](index.md#danbroid.util.menu/MenuItemBuilder/inlineChildren/#/PointingToDeclaration/)|  [androidJvm] open override var [inlineChildren](index.md#danbroid.util.menu/MenuItemBuilder/inlineChildren/#/PointingToDeclaration/): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>
| [isBrowsable](index.md#danbroid.util.menu/MenuItemBuilder/isBrowsable/#/PointingToDeclaration/)|  [androidJvm] open override var [isBrowsable](index.md#danbroid.util.menu/MenuItemBuilder/isBrowsable/#/PointingToDeclaration/): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>
| [isVisible](index.md#danbroid.util.menu/MenuItemBuilder/isVisible/#/PointingToDeclaration/)|  [androidJvm] open override var [isVisible](index.md#danbroid.util.menu/MenuItemBuilder/isVisible/#/PointingToDeclaration/): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>
| [liveChildren](index.md#danbroid.util.menu/MenuItemBuilder/liveChildren/#/PointingToDeclaration/)|  [androidJvm] var [liveChildren](index.md#danbroid.util.menu/MenuItemBuilder/liveChildren/#/PointingToDeclaration/): [LiveItemProducer](../index.md#danbroid.util.menu/LiveItemProducer///PointingToDeclaration/)?   <br>
| [onClick](index.md#danbroid.util.menu/MenuItemBuilder/onClick/#/PointingToDeclaration/)|  [androidJvm] var [onClick](index.md#danbroid.util.menu/MenuItemBuilder/onClick/#/PointingToDeclaration/): [MenuItemClickHandler](../index.md#danbroid.util.menu/MenuItemClickHandler///PointingToDeclaration/)?   <br>
| [onCreate](index.md#danbroid.util.menu/MenuItemBuilder/onCreate/#/PointingToDeclaration/)|  [androidJvm] var [onCreate](index.md#danbroid.util.menu/MenuItemBuilder/onCreate/#/PointingToDeclaration/): [LiveItemProducer](../index.md#danbroid.util.menu/LiveItemProducer///PointingToDeclaration/)?   <br>
| [provides](index.md#danbroid.util.menu/MenuItemBuilder/provides/#/PointingToDeclaration/)|  [androidJvm] override var [provides](index.md#danbroid.util.menu/MenuItemBuilder/provides/#/PointingToDeclaration/): ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -> [MenuBuilder](../-menu-builder/index.md)?   <br>
| [roundedCorners](index.md#danbroid.util.menu/MenuItemBuilder/roundedCorners/#/PointingToDeclaration/)|  [androidJvm] var [roundedCorners](index.md#danbroid.util.menu/MenuItemBuilder/roundedCorners/#/PointingToDeclaration/): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>
| [subtitle](index.md#danbroid.util.menu/MenuItemBuilder/subtitle/#/PointingToDeclaration/)|  [androidJvm] open override var [subtitle](index.md#danbroid.util.menu/MenuItemBuilder/subtitle/#/PointingToDeclaration/): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)   <br>
| [subtitleID](index.md#danbroid.util.menu/MenuItemBuilder/subtitleID/#/PointingToDeclaration/)|  [androidJvm] @[StringRes](https://developer.android.com/reference/kotlin/androidx/annotation/StringRes.html)()  <br>  <br>open override var [subtitleID](index.md#danbroid.util.menu/MenuItemBuilder/subtitleID/#/PointingToDeclaration/): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)   <br>
| [tintRes](index.md#danbroid.util.menu/MenuItemBuilder/tintRes/#/PointingToDeclaration/)|  [androidJvm] @[ColorRes](https://developer.android.com/reference/kotlin/androidx/annotation/ColorRes.html)()  <br>  <br>var [tintRes](index.md#danbroid.util.menu/MenuItemBuilder/tintRes/#/PointingToDeclaration/): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)   <br>
| [title](index.md#danbroid.util.menu/MenuItemBuilder/title/#/PointingToDeclaration/)|  [androidJvm] open override var [title](index.md#danbroid.util.menu/MenuItemBuilder/title/#/PointingToDeclaration/): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?   <br>
| [titleID](index.md#danbroid.util.menu/MenuItemBuilder/titleID/#/PointingToDeclaration/)|  [androidJvm] @[StringRes](https://developer.android.com/reference/kotlin/androidx/annotation/StringRes.html)()  <br>  <br>open override var [titleID](index.md#danbroid.util.menu/MenuItemBuilder/titleID/#/PointingToDeclaration/): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)   <br>

