//[misc](../../index.md)/[danbroid.util.misc](../index.md)/[SingletonHolder](index.md)



# SingletonHolder  
 [androidJvm] 



Usage:

class Manager(context:Context) {  
companion object : SingletonHolder<Manager,Context>(::Manager)  
}

open class [SingletonHolder](index.md)<out [T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [A](index.md)>(**creator**: ([A](index.md)) -> [T](index.md))   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| [SingletonHolder](-singleton-holder.md)|  [androidJvm] fun <out [T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [A](index.md)> [SingletonHolder](-singleton-holder.md)(creator: ([A](index.md)) -> [T](index.md))   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [equals](../../danbroid.util.resource/-resource-utils/index.md#kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>open operator override fun [equals](../../danbroid.util.resource/-resource-utils/index.md#kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [getInstance](get-instance.md)| [androidJvm]  <br>Content  <br>fun [getInstance](get-instance.md)(arg: [A](index.md)): [T](index.md)  <br><br><br>
| [hashCode](../../danbroid.util.resource/-resource-utils/index.md#kotlin/Any/hashCode/#/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>open override fun [hashCode](../../danbroid.util.resource/-resource-utils/index.md#kotlin/Any/hashCode/#/PointingToDeclaration/)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toString](../../danbroid.util.resource/-resource-utils/index.md#kotlin/Any/toString/#/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>open override fun [toString](../../danbroid.util.resource/-resource-utils/index.md#kotlin/Any/toString/#/PointingToDeclaration/)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [creator](index.md#danbroid.util.misc/SingletonHolder/creator/#/PointingToDeclaration/)|  [androidJvm] var [creator](index.md#danbroid.util.misc/SingletonHolder/creator/#/PointingToDeclaration/): ([A](index.md)) -> [T](index.md)?   <br>
| [instance](index.md#danbroid.util.misc/SingletonHolder/instance/#/PointingToDeclaration/)|  [androidJvm] @[Volatile](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-volatile/index.html)()  <br>  <br>var [instance](index.md#danbroid.util.misc/SingletonHolder/instance/#/PointingToDeclaration/): [T](index.md)?   <br>

