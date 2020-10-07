//[misc](../../index.md)/[danbroid.util.event](../index.md)/[Event](index.md)



# Event  
 [androidJvm] 

Used as a wrapper for data that is exposed via a LiveData that represents an event.

open class [Event](index.md)<out [T](index.md)>(**content**: [T](index.md))   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| [Event](-event.md)|  [androidJvm] fun <out [T](index.md)> [Event](-event.md)(content: [T](index.md))   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [equals](../../danbroid.util.resource/-resource-utils/index.md#kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>open operator override fun [equals](../../danbroid.util.resource/-resource-utils/index.md#kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [getContentIfNotHandled](get-content-if-not-handled.md)| [androidJvm]  <br>Brief description  <br><br><br>Returns the content and prevents its use again.<br><br>  <br>Content  <br>fun [getContentIfNotHandled](get-content-if-not-handled.md)(): [T](index.md)?  <br><br><br>
| [hashCode](../../danbroid.util.resource/-resource-utils/index.md#kotlin/Any/hashCode/#/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>open override fun [hashCode](../../danbroid.util.resource/-resource-utils/index.md#kotlin/Any/hashCode/#/PointingToDeclaration/)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [peekContent](peek-content.md)| [androidJvm]  <br>Brief description  <br><br><br>Returns the content, even if it's already been handled.<br><br>  <br>Content  <br>fun [peekContent](peek-content.md)(): [T](index.md)  <br><br><br>
| [toString](../../danbroid.util.resource/-resource-utils/index.md#kotlin/Any/toString/#/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>open override fun [toString](../../danbroid.util.resource/-resource-utils/index.md#kotlin/Any/toString/#/PointingToDeclaration/)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [hasBeenHandled](index.md#danbroid.util.event/Event/hasBeenHandled/#/PointingToDeclaration/)|  [androidJvm] var [hasBeenHandled](index.md#danbroid.util.event/Event/hasBeenHandled/#/PointingToDeclaration/): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>

