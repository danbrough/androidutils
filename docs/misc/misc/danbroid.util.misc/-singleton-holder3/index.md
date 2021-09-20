//[misc](../../../index.md)/[danbroid.util.misc](../index.md)/[SingletonHolder3](index.md)

# SingletonHolder3

[androidJvm]\
open class [SingletonHolder3](index.md)&lt;out [T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [A](index.md), in [B](index.md), in [C](index.md)&gt;(creator: ([A](index.md), [B](index.md), [C](index.md)) -&gt; [T](index.md))

## Functions

| Name | Summary |
|---|---|
| [getInstance](get-instance.md) | [androidJvm]<br>fun [getInstance](get-instance.md)(arg1: [A](index.md), arg2: [B](index.md), arg3: [C](index.md)): [T](index.md) |

## Properties

| Name | Summary |
|---|---|
| [creator](creator.md) | [androidJvm]<br>var [creator](creator.md): ([A](index.md), [B](index.md), [C](index.md)) -&gt; [T](index.md)? |
| [instance](instance.md) | [androidJvm]<br>@[Volatile](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-volatile/index.html)<br>var [instance](instance.md): [T](index.md)? = null |
