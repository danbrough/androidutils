//[logging](../../../index.md)/[danbroid.util.misc](../index.md)/[SingletonHolder](index.md)



# SingletonHolder  
 [androidJvm] open class [SingletonHolder](index.md)<out [T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [A](index.md)>(**creator**: ([A](index.md)) -> [T](index.md))

Usage:

class Manager(context:Context) {  
companion object : SingletonHolder<Manager,Context>(::Manager)  
}   


## Constructors  
  
| | |
|---|---|
| <a name="danbroid.util.misc/SingletonHolder/SingletonHolder/#kotlin.Function1[TypeParam(bounds=[kotlin.Any?]),TypeParam(bounds=[kotlin.Any])]/PointingToDeclaration/"></a>[SingletonHolder](-singleton-holder.md)| <a name="danbroid.util.misc/SingletonHolder/SingletonHolder/#kotlin.Function1[TypeParam(bounds=[kotlin.Any?]),TypeParam(bounds=[kotlin.Any])]/PointingToDeclaration/"></a> [androidJvm] fun <out [T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [A](index.md)> [SingletonHolder](-singleton-holder.md)(creator: ([A](index.md)) -> [T](index.md))   <br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="danbroid.util.misc/SingletonHolder/getInstance/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[getInstance](get-instance.md)| <a name="danbroid.util.misc/SingletonHolder/getInstance/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [getInstance](get-instance.md)(arg: [A](index.md)): [T](index.md)  <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="danbroid.util.misc/SingletonHolder/creator/#/PointingToDeclaration/"></a>[creator](creator.md)| <a name="danbroid.util.misc/SingletonHolder/creator/#/PointingToDeclaration/"></a> [androidJvm] var [creator](creator.md): ([A](index.md)) -> [T](index.md)?   <br>|
| <a name="danbroid.util.misc/SingletonHolder/instance/#/PointingToDeclaration/"></a>[instance](instance.md)| <a name="danbroid.util.misc/SingletonHolder/instance/#/PointingToDeclaration/"></a> [androidJvm] @[Volatile](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-volatile/index.html)()  <br>  <br>var [instance](instance.md): [T](index.md)? = null   <br>|

