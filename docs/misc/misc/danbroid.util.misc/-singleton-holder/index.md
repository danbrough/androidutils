//[misc](../../index.md)/[danbroid.util.misc](../index.md)/[SingletonHolder](index.md)



# SingletonHolder  
 [androidJvm] open class [SingletonHolder](index.md)<out [T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [A](index.md)>(**creator**: ([A](index.md)) -> [T](index.md))

Usage:

class Manager(context:Context) {  
companion object : SingletonHolder<Manager,Context>(::Manager)  
}   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="danbroid.util.misc/SingletonHolder/SingletonHolder/#kotlin.Function1[TypeParam(bounds=[kotlin.Any?]),TypeParam(bounds=[kotlin.Any])]/PointingToDeclaration/"></a>[SingletonHolder](-singleton-holder.md)| <a name="danbroid.util.misc/SingletonHolder/SingletonHolder/#kotlin.Function1[TypeParam(bounds=[kotlin.Any?]),TypeParam(bounds=[kotlin.Any])]/PointingToDeclaration/"></a> [androidJvm] fun <out [T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [A](index.md)> [SingletonHolder](-singleton-holder.md)(creator: ([A](index.md)) -> [T](index.md))   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../danbroid.util.resource/-resource-utils/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F245152761)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open operator fun [equals](../../danbroid.util.resource/-resource-utils/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F245152761)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="danbroid.util.misc/SingletonHolder/getInstance/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[getInstance](get-instance.md)| <a name="danbroid.util.misc/SingletonHolder/getInstance/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [getInstance](get-instance.md)(arg: [A](index.md)): [T](index.md)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../danbroid.util.resource/-resource-utils/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F245152761)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [hashCode](../../danbroid.util.resource/-resource-utils/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F245152761)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../danbroid.util.resource/-resource-utils/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F245152761)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [toString](../../danbroid.util.resource/-resource-utils/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F245152761)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="danbroid.util.misc/SingletonHolder/creator/#/PointingToDeclaration/"></a>[creator](creator.md)| <a name="danbroid.util.misc/SingletonHolder/creator/#/PointingToDeclaration/"></a> [androidJvm] var [creator](creator.md): ([A](index.md)) -> [T](index.md)?   <br>
| <a name="danbroid.util.misc/SingletonHolder/instance/#/PointingToDeclaration/"></a>[instance](instance.md)| <a name="danbroid.util.misc/SingletonHolder/instance/#/PointingToDeclaration/"></a> [androidJvm] @[Volatile](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-volatile/index.html)()  <br>  <br>var [instance](instance.md): [T](index.md)? = null   <br>

