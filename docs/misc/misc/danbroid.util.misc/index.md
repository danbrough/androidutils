//[misc](../index.md)/[danbroid.util.misc](index.md)



# Package danbroid.util.misc  


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="danbroid.util.misc/SingletonHolder///PointingToDeclaration/"></a>[SingletonHolder](-singleton-holder/index.md)| <a name="danbroid.util.misc/SingletonHolder///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open class [SingletonHolder](-singleton-holder/index.md)<out [T](-singleton-holder/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [A](-singleton-holder/index.md)>(**creator**: ([A](-singleton-holder/index.md)) -> [T](-singleton-holder/index.md))  <br>More info  <br>Usage:class Manager(context:Context) {  <br>companion object : SingletonHolder<Manager,Context>(::Manager)  <br>}  <br><br><br>
| <a name="danbroid.util.misc/SingletonHolder2///PointingToDeclaration/"></a>[SingletonHolder2](-singleton-holder2/index.md)| <a name="danbroid.util.misc/SingletonHolder2///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open class [SingletonHolder2](-singleton-holder2/index.md)<out [T](-singleton-holder2/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [A](-singleton-holder2/index.md), in [B](-singleton-holder2/index.md)>(**creator**: ([A](-singleton-holder2/index.md), [B](-singleton-holder2/index.md)) -> [T](-singleton-holder2/index.md))  <br><br><br>
| <a name="danbroid.util.misc/SingletonHolder3///PointingToDeclaration/"></a>[SingletonHolder3](-singleton-holder3/index.md)| <a name="danbroid.util.misc/SingletonHolder3///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open class [SingletonHolder3](-singleton-holder3/index.md)<out [T](-singleton-holder3/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [A](-singleton-holder3/index.md), in [B](-singleton-holder3/index.md), in [C](-singleton-holder3/index.md)>(**creator**: ([A](-singleton-holder3/index.md), [B](-singleton-holder3/index.md), [C](-singleton-holder3/index.md)) -> [T](-singleton-holder3/index.md))  <br><br><br>
| <a name="danbroid.util.misc/UniqueIDS///PointingToDeclaration/"></a>[UniqueIDS](-unique-i-d-s/index.md)| <a name="danbroid.util.misc/UniqueIDS///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>interface [UniqueIDS](-unique-i-d-s/index.md)  <br>More info  <br>Provides a #nextID method to return an incremental unique id  <br><br><br>
| <a name="danbroid.util.misc/WeakSingletonHolder///PointingToDeclaration/"></a>[WeakSingletonHolder](-weak-singleton-holder/index.md)| <a name="danbroid.util.misc/WeakSingletonHolder///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open class [WeakSingletonHolder](-weak-singleton-holder/index.md)<out [T](-weak-singleton-holder/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [A](-weak-singleton-holder/index.md)>(**creator**: ([A](-weak-singleton-holder/index.md)) -> [T](-weak-singleton-holder/index.md))  <br>More info  <br>A singleton holder that uses a [WeakReference](https://docs.oracle.com/javase/8/docs/api/java/lang/ref/WeakReference.html)  <br><br><br>

