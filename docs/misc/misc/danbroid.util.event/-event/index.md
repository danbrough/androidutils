//[misc](../../index.md)/[danbroid.util.event](../index.md)/[Event](index.md)



# Event  
 [androidJvm] open class [Event](index.md)<out [T](index.md)>(**content**: [T](index.md))

Used as a wrapper for data that is exposed via a LiveData that represents an event.

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="danbroid.util.event/Event/Event/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[Event](-event.md)| <a name="danbroid.util.event/Event/Event/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a> [androidJvm] fun <out [T](index.md)> [Event](-event.md)(content: [T](index.md))   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../danbroid.util.resource/-resource-utils/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F1310881628)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open operator fun [equals](../../danbroid.util.resource/-resource-utils/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F1310881628)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="danbroid.util.event/Event/getContentIfNotHandled/#/PointingToDeclaration/"></a>[getContentIfNotHandled](get-content-if-not-handled.md)| <a name="danbroid.util.event/Event/getContentIfNotHandled/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [getContentIfNotHandled](get-content-if-not-handled.md)(): [T](index.md)?  <br>More info  <br>Returns the content and prevents its use again.  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../danbroid.util.resource/-resource-utils/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F1310881628)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [hashCode](../../danbroid.util.resource/-resource-utils/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F1310881628)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="danbroid.util.event/Event/peekContent/#/PointingToDeclaration/"></a>[peekContent](peek-content.md)| <a name="danbroid.util.event/Event/peekContent/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [peekContent](peek-content.md)(): [T](index.md)  <br>More info  <br>Returns the content, even if it's already been handled.  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../danbroid.util.resource/-resource-utils/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F1310881628)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [toString](../../danbroid.util.resource/-resource-utils/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F1310881628)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="danbroid.util.event/Event/hasBeenHandled/#/PointingToDeclaration/"></a>[hasBeenHandled](has-been-handled.md)| <a name="danbroid.util.event/Event/hasBeenHandled/#/PointingToDeclaration/"></a> [androidJvm] var [hasBeenHandled](has-been-handled.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false   <br>

