//[menu](../../../index.md)/[danbroid.util.menu.model](../index.md)/[MenuModel](index.md)

# MenuModel

[androidJvm]\
class [MenuModel](index.md)(**fragment**: [Fragment](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html), **menuID**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [clear](index.md#-1936886459%2FFunctions%2F1173194265) | [androidJvm]<br>@[MainThread](https://developer.android.com/reference/kotlin/androidx/annotation/MainThread.html)()<br>fun [clear](index.md#-1936886459%2FFunctions%2F1173194265)() |
| [getTag](index.md#-215894976%2FFunctions%2F1173194265) | [androidJvm]<br>open fun <[T](index.md#-215894976%2FFunctions%2F1173194265) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [getTag](index.md#-215894976%2FFunctions%2F1173194265)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [T](index.md#-215894976%2FFunctions%2F1173194265) |
| [invalidate](invalidate.md) | [androidJvm]<br>fun [invalidate](invalidate.md)(fragment: [Fragment](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html)) |
| [setTagIfAbsent](index.md#-1567230750%2FFunctions%2F1173194265) | [androidJvm]<br>open fun <[T](index.md#-1567230750%2FFunctions%2F1173194265) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [setTagIfAbsent](index.md#-1567230750%2FFunctions%2F1173194265)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), p1: [T](index.md#-1567230750%2FFunctions%2F1173194265)): [T](index.md#-1567230750%2FFunctions%2F1173194265) |

## Properties

| Name | Summary |
|---|---|
| [children](children.md) | [androidJvm]<br>val [children](children.md): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)<[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[MenuItem](../../danbroid.util.menu/-menu-item/index.md)>> |
| [context](context.md) | [androidJvm]<br>val [context](context.md): [Context](https://developer.android.com/reference/kotlin/android/content/Context.html) |
| [menu](menu.md) | [androidJvm]<br>val [menu](menu.md): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)<[MenuItem](../../danbroid.util.menu/-menu-item/index.md)> |
| [menuID](menu-i-d.md) | [androidJvm]<br>val [menuID](menu-i-d.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
