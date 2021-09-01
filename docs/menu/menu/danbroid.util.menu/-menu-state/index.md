//[menu](../../../index.md)/[danbroid.util.menu](../index.md)/[MenuState](index.md)

# MenuState

[androidJvm]\
sealed class [MenuState](index.md)

## Types

| Name | Summary |
|---|---|
| [ERROR](-e-r-r-o-r/index.md) | [androidJvm]<br>data class [ERROR](-e-r-r-o-r/index.md)(**message**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [MenuState](index.md) |
| [LOADED](-l-o-a-d-e-d/index.md) | [androidJvm]<br>data class [LOADED](-l-o-a-d-e-d/index.md)(**title**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **menus**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Menu](../-menu/index.md)>) : [MenuState](index.md) |
| [LOADING](-l-o-a-d-i-n-g/index.md) | [androidJvm]<br>data class [LOADING](-l-o-a-d-i-n-g/index.md)(**title**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [MenuState](index.md) |

## Inheritors

| Name |
|---|
| [MenuState](-l-o-a-d-i-n-g/index.md) |
| [MenuState](-l-o-a-d-e-d/index.md) |
| [MenuState](-e-r-r-o-r/index.md) |
