//[misc](../../../index.md)/[danbroid.util.misc](../index.md)/[WeakSingletonHolder](index.md)



# WeakSingletonHolder  
 [androidJvm] open class [WeakSingletonHolder](index.md)<out [T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [A](index.md)>(**creator**: ([A](index.md)) -> [T](index.md))

A singleton holder that uses a [WeakReference](https://developer.android.com/reference/kotlin/java/lang/ref/WeakReference.html)

   


## Constructors  
  
| | |
|---|---|
| <a name="danbroid.util.misc/WeakSingletonHolder/WeakSingletonHolder/#kotlin.Function1[TypeParam(bounds=[kotlin.Any?]),TypeParam(bounds=[kotlin.Any])]/PointingToDeclaration/"></a>[WeakSingletonHolder](-weak-singleton-holder.md)| <a name="danbroid.util.misc/WeakSingletonHolder/WeakSingletonHolder/#kotlin.Function1[TypeParam(bounds=[kotlin.Any?]),TypeParam(bounds=[kotlin.Any])]/PointingToDeclaration/"></a> [androidJvm] fun <out [T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [A](index.md)> [WeakSingletonHolder](-weak-singleton-holder.md)(creator: ([A](index.md)) -> [T](index.md))   <br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="danbroid.util.misc/WeakSingletonHolder/getInstance/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[getInstance](get-instance.md)| <a name="danbroid.util.misc/WeakSingletonHolder/getInstance/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [getInstance](get-instance.md)(arg: [A](index.md)): [T](index.md)  <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="danbroid.util.misc/WeakSingletonHolder/creator/#/PointingToDeclaration/"></a>[creator](creator.md)| <a name="danbroid.util.misc/WeakSingletonHolder/creator/#/PointingToDeclaration/"></a> [androidJvm] val [creator](creator.md): ([A](index.md)) -> [T](index.md)   <br>|
| <a name="danbroid.util.misc/WeakSingletonHolder/instance/#/PointingToDeclaration/"></a>[instance](instance.md)| <a name="danbroid.util.misc/WeakSingletonHolder/instance/#/PointingToDeclaration/"></a> [androidJvm] @[Volatile](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-volatile/index.html)()  <br>  <br>var [instance](instance.md): [WeakReference](https://developer.android.com/reference/kotlin/java/lang/ref/WeakReference.html)<[T](index.md)>? = null   <br>|

