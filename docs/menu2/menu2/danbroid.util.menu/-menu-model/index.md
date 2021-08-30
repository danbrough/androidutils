//[menu2](../../../index.md)/[danbroid.util.menu](../index.md)/[MenuModel](index.md)

# MenuModel

[androidJvm]\
open class [MenuModel](index.md)(**menuID**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **context**: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

## Functions

| Name | Summary |
|---|---|
| [clear](index.md#-1936886459%2FFunctions%2F-898530085) | [androidJvm]<br>@[MainThread](https://developer.android.com/reference/kotlin/androidx/annotation/MainThread.html)()<br>fun [clear](index.md#-1936886459%2FFunctions%2F-898530085)() |
| [getTag](index.md#-215894976%2FFunctions%2F-898530085) | [androidJvm]<br>open fun <[T](index.md#-215894976%2FFunctions%2F-898530085) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [getTag](index.md#-215894976%2FFunctions%2F-898530085)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [T](index.md#-215894976%2FFunctions%2F-898530085) |
| [setTagIfAbsent](index.md#-1567230750%2FFunctions%2F-898530085) | [androidJvm]<br>open fun <[T](index.md#-1567230750%2FFunctions%2F-898530085) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [setTagIfAbsent](index.md#-1567230750%2FFunctions%2F-898530085)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), p1: [T](index.md#-1567230750%2FFunctions%2F-898530085)): [T](index.md#-1567230750%2FFunctions%2F-898530085) |

## Properties

| Name | Summary |
|---|---|
| [menuID](menu-i-d.md) | [androidJvm]<br>val [menuID](menu-i-d.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [menus](menus.md) | [androidJvm]<br>val [menus](menus.md): StateFlow<[MenuState](../-menu-state/index.md)> |
