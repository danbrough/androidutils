//[logging](../../../index.md)/[danbroid.util.event](../index.md)/[Event](index.md)



# Event  
 [androidJvm] open class [Event](index.md)<out [T](index.md)>(**content**: [T](index.md))

Used as a wrapper for data that is exposed via a LiveData that represents an event.

   


## Constructors  
  
| | |
|---|---|
| <a name="danbroid.util.event/Event/Event/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[Event](-event.md)| <a name="danbroid.util.event/Event/Event/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a> [androidJvm] fun <out [T](index.md)> [Event](-event.md)(content: [T](index.md))   <br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="danbroid.util.event/Event/getContentIfNotHandled/#/PointingToDeclaration/"></a>[getContentIfNotHandled](get-content-if-not-handled.md)| <a name="danbroid.util.event/Event/getContentIfNotHandled/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [getContentIfNotHandled](get-content-if-not-handled.md)(): [T](index.md)?  <br>More info  <br>Returns the content and prevents its use again.  <br><br><br>|
| <a name="danbroid.util.event/Event/peekContent/#/PointingToDeclaration/"></a>[peekContent](peek-content.md)| <a name="danbroid.util.event/Event/peekContent/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [peekContent](peek-content.md)(): [T](index.md)  <br>More info  <br>Returns the content, even if it's already been handled.  <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="danbroid.util.event/Event/hasBeenHandled/#/PointingToDeclaration/"></a>[hasBeenHandled](has-been-handled.md)| <a name="danbroid.util.event/Event/hasBeenHandled/#/PointingToDeclaration/"></a> [androidJvm] var [hasBeenHandled](has-been-handled.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false   <br>|

