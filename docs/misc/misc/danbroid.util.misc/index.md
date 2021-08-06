//[misc](../../index.md)/[danbroid.util.misc](index.md)

# Package danbroid.util.misc

## Types

| Name | Summary |
|---|---|
| [SingletonHolder](-singleton-holder/index.md) | [androidJvm]<br>open class [SingletonHolder](-singleton-holder/index.md)<out [T](-singleton-holder/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [A](-singleton-holder/index.md)>(**creator**: ([A](-singleton-holder/index.md)) -> [T](-singleton-holder/index.md))<br>Usage:class Manager(context:Context) {<br>companion object : SingletonHolder<Manager,Context>(::Manager)<br>} |
| [SingletonHolder2](-singleton-holder2/index.md) | [androidJvm]<br>open class [SingletonHolder2](-singleton-holder2/index.md)<out [T](-singleton-holder2/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [A](-singleton-holder2/index.md), in [B](-singleton-holder2/index.md)>(**creator**: ([A](-singleton-holder2/index.md), [B](-singleton-holder2/index.md)) -> [T](-singleton-holder2/index.md)) |
| [SingletonHolder3](-singleton-holder3/index.md) | [androidJvm]<br>open class [SingletonHolder3](-singleton-holder3/index.md)<out [T](-singleton-holder3/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [A](-singleton-holder3/index.md), in [B](-singleton-holder3/index.md), in [C](-singleton-holder3/index.md)>(**creator**: ([A](-singleton-holder3/index.md), [B](-singleton-holder3/index.md), [C](-singleton-holder3/index.md)) -> [T](-singleton-holder3/index.md)) |
| [UniqueIDS](-unique-i-d-s/index.md) | [androidJvm]<br>interface [UniqueIDS](-unique-i-d-s/index.md)<br>Provides a #nextID method to return an incremental unique id |
| [WeakSingletonHolder](-weak-singleton-holder/index.md) | [androidJvm]<br>open class [WeakSingletonHolder](-weak-singleton-holder/index.md)<out [T](-weak-singleton-holder/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [A](-weak-singleton-holder/index.md)>(**creator**: ([A](-weak-singleton-holder/index.md)) -> [T](-weak-singleton-holder/index.md))<br>A singleton holder that uses a [WeakReference](https://developer.android.com/reference/kotlin/java/lang/ref/WeakReference.html) |
