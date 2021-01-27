//[misc](../../index.md)/[danbroid.util.prefs](../index.md)/[Prefs](index.md)



# Prefs  
 [androidJvm] open class [Prefs](index.md)(**context**: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), **prefsCreator**: ([Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) -> [SharedPreferences](https://developer.android.com/reference/kotlin/android/content/SharedPreferences.html))

Classes that allow you to implement properties that delegate to a [android.content.SharedPreferences](https://developer.android.com/reference/kotlin/android/content/SharedPreferences.html) instance

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="danbroid.util.prefs/Prefs/Prefs/#android.content.Context#kotlin.String/PointingToDeclaration/"></a>[Prefs](-prefs.md)| <a name="danbroid.util.prefs/Prefs/Prefs/#android.content.Context#kotlin.String/PointingToDeclaration/"></a> [androidJvm] fun [Prefs](-prefs.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), prefsFile: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))   <br>
| <a name="danbroid.util.prefs/Prefs/Prefs/#android.content.Context#kotlin.Function1[android.content.Context,android.content.SharedPreferences]/PointingToDeclaration/"></a>[Prefs](-prefs.md)| <a name="danbroid.util.prefs/Prefs/Prefs/#android.content.Context#kotlin.Function1[android.content.Context,android.content.SharedPreferences]/PointingToDeclaration/"></a> [androidJvm] fun [Prefs](-prefs.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), prefsCreator: ([Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) -> [SharedPreferences](https://developer.android.com/reference/kotlin/android/content/SharedPreferences.html))   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="danbroid.util.prefs/Prefs.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="danbroid.util.prefs/Prefs.Companion///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>
| <a name="danbroid.util.prefs/Prefs.Pref///PointingToDeclaration/"></a>[Pref](-pref/index.md)| <a name="danbroid.util.prefs/Prefs.Pref///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>@[ExperimentalStdlibApi](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-experimental-stdlib-api/index.html)()  <br>  <br>inner class [Pref](-pref/index.md)(**defValue**: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?)  <br>More info  <br>val message:String by Pref("default value") var count:Int?  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="danbroid.util.prefs/Prefs/clear/#/PointingToDeclaration/"></a>[clear](clear.md)| <a name="danbroid.util.prefs/Prefs/clear/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [clear](clear.md)(): [SharedPreferences.Editor](https://developer.android.com/reference/kotlin/android/content/SharedPreferences.Editor.html)  <br><br><br>
| <a name="danbroid.util.prefs/Prefs/close/#kotlin.Boolean/PointingToDeclaration/"></a>[close](close.md)| <a name="danbroid.util.prefs/Prefs/close/#kotlin.Boolean/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [close](close.md)(commit: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../danbroid.util.resource/-resource-utils/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F245152761)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open operator fun [equals](../../danbroid.util.resource/-resource-utils/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F245152761)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="danbroid.util.prefs/Prefs/finalize/#/PointingToDeclaration/"></a>[finalize](finalize.md)| <a name="danbroid.util.prefs/Prefs/finalize/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [finalize](finalize.md)()  <br><br><br>
| <a name="danbroid.util.prefs/Prefs/get/#kotlin.String#kotlin.Any?#kotlin.reflect.KType/PointingToDeclaration/"></a>[get](get.md)| <a name="danbroid.util.prefs/Prefs/get/#kotlin.String#kotlin.Any?#kotlin.reflect.KType/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>@[ExperimentalStdlibApi](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-experimental-stdlib-api/index.html)()  <br>  <br>fun [get](get.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), defaultValue: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?, type: [KType](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-type/index.html)): [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../danbroid.util.resource/-resource-utils/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F245152761)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [hashCode](../../danbroid.util.resource/-resource-utils/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F245152761)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="danbroid.util.prefs/Prefs/put/#kotlin.String#kotlin.Any?/PointingToDeclaration/"></a>[put](put.md)| <a name="danbroid.util.prefs/Prefs/put/#kotlin.String#kotlin.Any?/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [put](put.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../danbroid.util.resource/-resource-utils/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F245152761)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [toString](../../danbroid.util.resource/-resource-utils/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F245152761)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="danbroid.util.prefs/Prefs/editor/#/PointingToDeclaration/"></a>[editor](editor.md)| <a name="danbroid.util.prefs/Prefs/editor/#/PointingToDeclaration/"></a> [androidJvm] val [editor](editor.md): [SharedPreferences.Editor](https://developer.android.com/reference/kotlin/android/content/SharedPreferences.Editor.html)   <br>
| <a name="danbroid.util.prefs/Prefs/prefs/#/PointingToDeclaration/"></a>[prefs](prefs.md)| <a name="danbroid.util.prefs/Prefs/prefs/#/PointingToDeclaration/"></a> [androidJvm] val [prefs](prefs.md): [SharedPreferences](https://developer.android.com/reference/kotlin/android/content/SharedPreferences.html)   <br>

