//[misc](../../../index.md)/[danbroid.util.misc](../index.md)/[WeakSingletonHolder](index.md)

# WeakSingletonHolder

[androidJvm]\
open class [WeakSingletonHolder](index.md)<out [T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [A](index.md)>(**creator**: ([A](index.md)) -> [T](index.md))

A singleton holder that uses a [WeakReference](https://developer.android.com/reference/kotlin/java/lang/ref/WeakReference.html)

## Constructors

| | |
|---|---|
| [WeakSingletonHolder](-weak-singleton-holder.md) | [androidJvm]<br>fun <out [T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [A](index.md)> [WeakSingletonHolder](-weak-singleton-holder.md)(creator: ([A](index.md)) -> [T](index.md)) |

## Functions

| Name | Summary |
|---|---|
| [getInstance](get-instance.md) | [androidJvm]<br>fun [getInstance](get-instance.md)(arg: [A](index.md)): [T](index.md) |

## Properties

| Name | Summary |
|---|---|
| [creator](creator.md) | [androidJvm]<br>val [creator](creator.md): ([A](index.md)) -> [T](index.md) |
| [instance](instance.md) | [androidJvm]<br>@[Volatile](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-volatile/index.html)()<br>var [instance](instance.md): [WeakReference](https://developer.android.com/reference/kotlin/java/lang/ref/WeakReference.html)<[T](index.md)>? = null |
