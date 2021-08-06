//[misc](../../../index.md)/[danbroid.util.misc](../index.md)/[SingletonHolder2](index.md)

# SingletonHolder2

[androidJvm]\
open class [SingletonHolder2](index.md)<out [T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [A](index.md), in [B](index.md)>(**creator**: ([A](index.md), [B](index.md)) -> [T](index.md))

## Functions

| Name | Summary |
|---|---|
| [getInstance](get-instance.md) | [androidJvm]<br>fun [getInstance](get-instance.md)(arg1: [A](index.md), arg2: [B](index.md)): [T](index.md) |

## Properties

| Name | Summary |
|---|---|
| [creator](creator.md) | [androidJvm]<br>var [creator](creator.md): ([A](index.md), [B](index.md)) -> [T](index.md)? |
| [instance](instance.md) | [androidJvm]<br>@[Volatile](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-volatile/index.html)()<br>var [instance](instance.md): [T](index.md)? = null |
