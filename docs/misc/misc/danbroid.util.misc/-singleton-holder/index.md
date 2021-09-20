//[misc](../../../index.md)/[danbroid.util.misc](../index.md)/[SingletonHolder](index.md)

# SingletonHolder

[androidJvm]\
open class [SingletonHolder](index.md)&lt;out [T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [A](index.md)&gt;(creator: ([A](index.md)) -&gt; [T](index.md))

Usage:

class Manager(context:Context) {\
companion object : SingletonHolder&lt;Manager,Context&gt;(::Manager)\
}

## Constructors

| | |
|---|---|
| [SingletonHolder](-singleton-holder.md) | [androidJvm]<br>fun &lt;out [T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [A](index.md)&gt; [SingletonHolder](-singleton-holder.md)(creator: ([A](index.md)) -&gt; [T](index.md)) |

## Functions

| Name | Summary |
|---|---|
| [getInstance](get-instance.md) | [androidJvm]<br>fun [getInstance](get-instance.md)(arg: [A](index.md)): [T](index.md) |

## Properties

| Name | Summary |
|---|---|
| [creator](creator.md) | [androidJvm]<br>var [creator](creator.md): ([A](index.md)) -&gt; [T](index.md)? |
| [instance](instance.md) | [androidJvm]<br>@[Volatile](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-volatile/index.html)<br>var [instance](instance.md): [T](index.md)? = null |
