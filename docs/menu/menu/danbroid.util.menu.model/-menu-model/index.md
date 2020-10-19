//[menu](../../index.md)/[danbroid.util.menu.model](../index.md)/[MenuModel](index.md)



# MenuModel  
 [androidJvm] class [MenuModel](index.md)(**fragment**: [Fragment](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html), **menuID**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)   


## Types  
  
|  Name|  Summary| 
|---|---|
| [Companion](-companion/index.md)| [androidJvm]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [clear](index.md#androidx.lifecycle/ViewModel/clear/#/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>@[MainThread](https://developer.android.com/reference/kotlin/androidx/annotation/MainThread.html)()  <br>  <br>override fun [clear](index.md#androidx.lifecycle/ViewModel/clear/#/PointingToDeclaration/)()  <br><br><br>
| [equals](../../danbroid.util.menu.ui/-menu-item-diff-callback/index.md#kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>open operator override fun [equals](../../danbroid.util.menu.ui/-menu-item-diff-callback/index.md#kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [getTag](index.md#androidx.lifecycle/ViewModel/getTag/#kotlin.String/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>open override fun <T : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [getTag](index.md#androidx.lifecycle/ViewModel/getTag/#kotlin.String/PointingToDeclaration/)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): T  <br><br><br>
| [hashCode](../../danbroid.util.menu.ui/-menu-item-diff-callback/index.md#kotlin/Any/hashCode/#/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>open override fun [hashCode](../../danbroid.util.menu.ui/-menu-item-diff-callback/index.md#kotlin/Any/hashCode/#/PointingToDeclaration/)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [setTagIfAbsent](index.md#androidx.lifecycle/ViewModel/setTagIfAbsent/#kotlin.String#TypeParam(bounds=[kotlin.Any])/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>open override fun <T : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [setTagIfAbsent](index.md#androidx.lifecycle/ViewModel/setTagIfAbsent/#kotlin.String#TypeParam(bounds=[kotlin.Any])/PointingToDeclaration/)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), p1: T): T  <br><br><br>
| [toString](../../danbroid.util.menu.ui/-menu-item-diff-callback/index.md#kotlin/Any/toString/#/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>open override fun [toString](../../danbroid.util.menu.ui/-menu-item-diff-callback/index.md#kotlin/Any/toString/#/PointingToDeclaration/)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| [updateChildren](update-children.md)| [androidJvm]  <br>Content  <br>fun [updateChildren](update-children.md)(children: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[MenuItem](../../danbroid.util.menu/-menu-item/index.md)>)  <br><br><br>
| [updateItem](update-item.md)| [androidJvm]  <br>Content  <br>fun [updateItem](update-item.md)(item: [MenuItem](../../danbroid.util.menu/-menu-item/index.md))  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [children](index.md#danbroid.util.menu.model/MenuModel/children/#/PointingToDeclaration/)|  [androidJvm] val [children](index.md#danbroid.util.menu.model/MenuModel/children/#/PointingToDeclaration/): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)<[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[MenuItem](../../danbroid.util.menu/-menu-item/index.md)>>   <br>
| [context](index.md#danbroid.util.menu.model/MenuModel/context/#/PointingToDeclaration/)|  [androidJvm] val [context](index.md#danbroid.util.menu.model/MenuModel/context/#/PointingToDeclaration/): [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)   <br>
| [mBagOfTags](index.md#danbroid.util.menu.model/MenuModel/mBagOfTags/#/PointingToDeclaration/)|  [androidJvm] @[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)()  <br>  <br>override val [mBagOfTags](index.md#danbroid.util.menu.model/MenuModel/mBagOfTags/#/PointingToDeclaration/): [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>?   <br>
| [mCleared](index.md#danbroid.util.menu.model/MenuModel/mCleared/#/PointingToDeclaration/)|  [androidJvm] override val [mCleared](index.md#danbroid.util.menu.model/MenuModel/mCleared/#/PointingToDeclaration/): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>
| [menu](index.md#danbroid.util.menu.model/MenuModel/menu/#/PointingToDeclaration/)|  [androidJvm] val [menu](index.md#danbroid.util.menu.model/MenuModel/menu/#/PointingToDeclaration/): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)<[MenuItem](../../danbroid.util.menu/-menu-item/index.md)>   <br>
| [menuID](index.md#danbroid.util.menu.model/MenuModel/menuID/#/PointingToDeclaration/)|  [androidJvm] val [menuID](index.md#danbroid.util.menu.model/MenuModel/menuID/#/PointingToDeclaration/): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)   <br>

