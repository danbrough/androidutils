//[misc](../../index.md)/[danbroid.util.misc](../index.md)/[WeakSingletonHolder](index.md)



# WeakSingletonHolder  
 [androidJvm] open class [WeakSingletonHolder](index.md)<out [T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [A](index.md)>(**creator**: ([A](index.md)) -> [T](index.md))

A singleton holder that uses a [WeakReference](https://docs.oracle.com/javase/8/docs/api/java/lang/ref/WeakReference.html)

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="danbroid.util.misc/WeakSingletonHolder/WeakSingletonHolder/#kotlin.Function1[TypeParam(bounds=[kotlin.Any?]),TypeParam(bounds=[kotlin.Any])]/PointingToDeclaration/"></a>[WeakSingletonHolder](-weak-singleton-holder.md)| <a name="danbroid.util.misc/WeakSingletonHolder/WeakSingletonHolder/#kotlin.Function1[TypeParam(bounds=[kotlin.Any?]),TypeParam(bounds=[kotlin.Any])]/PointingToDeclaration/"></a> [androidJvm] fun <out [T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [A](index.md)> [WeakSingletonHolder](-weak-singleton-holder.md)(creator: ([A](index.md)) -> [T](index.md))   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../danbroid.util.resource/-resource-utils/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F1392605665)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open operator fun [equals](../../danbroid.util.resource/-resource-utils/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F1392605665)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="danbroid.util.misc/WeakSingletonHolder/getInstance/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[getInstance](get-instance.md)| <a name="danbroid.util.misc/WeakSingletonHolder/getInstance/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [getInstance](get-instance.md)(arg: [A](index.md)): [T](index.md)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../danbroid.util.resource/-resource-utils/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F1392605665)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [hashCode](../../danbroid.util.resource/-resource-utils/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F1392605665)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../danbroid.util.resource/-resource-utils/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F1392605665)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [toString](../../danbroid.util.resource/-resource-utils/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F1392605665)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="danbroid.util.misc/WeakSingletonHolder/creator/#/PointingToDeclaration/"></a>[creator](creator.md)| <a name="danbroid.util.misc/WeakSingletonHolder/creator/#/PointingToDeclaration/"></a> [androidJvm] val [creator](creator.md): ([A](index.md)) -> [T](index.md)   <br>
| <a name="danbroid.util.misc/WeakSingletonHolder/instance/#/PointingToDeclaration/"></a>[instance](instance.md)| <a name="danbroid.util.misc/WeakSingletonHolder/instance/#/PointingToDeclaration/"></a> [androidJvm] @[Volatile](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-volatile/index.html)()  <br>  <br>var [instance](instance.md): [WeakReference](https://docs.oracle.com/javase/8/docs/api/java/lang/ref/WeakReference.html)<[T](index.md)>? = null   <br>

