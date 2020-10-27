//[misc](../index.md)/[danbroid.util.misc](index.md)



# Package danbroid.util.misc  


## Types  
  
|  Name|  Summary| 
|---|---|
| [SingletonHolder](-singleton-holder/index.md)| [androidJvm]  <br>Brief description  <br><br><br><br><br>Usage:<br><br>class Manager(context:Context) {  <br>companion object : SingletonHolder<Manager,Context>(::Manager)  <br>}<br><br>  <br>Content  <br>open class [SingletonHolder](-singleton-holder/index.md)<out [T](-singleton-holder/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [A](-singleton-holder/index.md)>(**creator**: ([A](-singleton-holder/index.md)) -> [T](-singleton-holder/index.md))  <br><br><br>
| [UniqueIDS](-unique-i-d-s/index.md)| [androidJvm]  <br>Brief description  <br><br><br>Provides a #nextID method to return an incremental unique id<br><br>  <br>Content  <br>interface [UniqueIDS](-unique-i-d-s/index.md)  <br><br><br>
| [WeakSingletonHolder](-weak-singleton-holder/index.md)| [androidJvm]  <br>Brief description  <br><br><br>A singleton holder that uses a [WeakReference](https://docs.oracle.com/javase/8/docs/api/java/lang/ref/WeakReference.html)<br><br>  <br>Content  <br>open class [WeakSingletonHolder](-weak-singleton-holder/index.md)<out [T](-weak-singleton-holder/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [A](-weak-singleton-holder/index.md)>(**creator**: ([A](-weak-singleton-holder/index.md)) -> [T](-weak-singleton-holder/index.md))  <br><br><br>

