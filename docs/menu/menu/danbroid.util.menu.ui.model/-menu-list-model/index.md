//[menu](../../index.md)/[danbroid.util.menu.ui.model](../index.md)/[MenuListModel](index.md)



# MenuListModel  
 [androidJvm] open class [MenuListModel](index.md)(**context**: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), **id**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **builder**: [MenuItemBuilder](../../danbroid.util.menu/-menu-item-builder/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)   


## Types  
  
|  Name|  Summary| 
|---|---|
| [Companion](-companion/index.md)| [androidJvm]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [clear](index.md#androidx.lifecycle/ViewModel/clear/#/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>@[MainThread](https://developer.android.com/reference/kotlin/androidx/annotation/MainThread.html)()  <br>  <br>override fun [clear](index.md#androidx.lifecycle/ViewModel/clear/#/PointingToDeclaration/)()  <br><br><br>
| [equals](-companion/-new-instance-factory/index.md#kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>open operator override fun [equals](-companion/-new-instance-factory/index.md#kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [getTag](index.md#androidx.lifecycle/ViewModel/getTag/#kotlin.String/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>open override fun <T : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [getTag](index.md#androidx.lifecycle/ViewModel/getTag/#kotlin.String/PointingToDeclaration/)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): T  <br><br><br>
| [hashCode](-companion/-new-instance-factory/index.md#kotlin/Any/hashCode/#/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>open override fun [hashCode](-companion/-new-instance-factory/index.md#kotlin/Any/hashCode/#/PointingToDeclaration/)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [setTagIfAbsent](index.md#androidx.lifecycle/ViewModel/setTagIfAbsent/#kotlin.String#TypeParam(bounds=[kotlin.Any])/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>open override fun <T : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [setTagIfAbsent](index.md#androidx.lifecycle/ViewModel/setTagIfAbsent/#kotlin.String#TypeParam(bounds=[kotlin.Any])/PointingToDeclaration/)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), p1: T): T  <br><br><br>
| [toString](-companion/-new-instance-factory/index.md#kotlin/Any/toString/#/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>open override fun [toString](-companion/-new-instance-factory/index.md#kotlin/Any/toString/#/PointingToDeclaration/)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [mBagOfTags](index.md#danbroid.util.menu.ui.model/MenuListModel/mBagOfTags/#/PointingToDeclaration/)|  [androidJvm] @[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)()  <br>  <br>override val [mBagOfTags](index.md#danbroid.util.menu.ui.model/MenuListModel/mBagOfTags/#/PointingToDeclaration/): [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>?   <br>
| [mCleared](index.md#danbroid.util.menu.ui.model/MenuListModel/mCleared/#/PointingToDeclaration/)|  [androidJvm] override val [mCleared](index.md#danbroid.util.menu.ui.model/MenuListModel/mCleared/#/PointingToDeclaration/): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>
| [menu](index.md#danbroid.util.menu.ui.model/MenuListModel/menu/#/PointingToDeclaration/)|  [androidJvm] open val [menu](index.md#danbroid.util.menu.ui.model/MenuListModel/menu/#/PointingToDeclaration/): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)<[MenuItem](../../danbroid.util.menu/-menu-item/index.md)>   <br>

