//[misc](../../index.md)/[danbroid.util.prefs](../index.md)/[BasePref](index.md)



# BasePref  
 [androidJvm] abstract class [BasePref](index.md)<[T](index.md), [K](index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<*>>(**keyID**: [K](index.md), **defValue**: [T](index.md))   


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../danbroid.util.resource/-resource-utils/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F1537741750)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open operator fun [equals](../../danbroid.util.resource/-resource-utils/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F1537741750)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="danbroid.util.prefs/BasePref/getPrefValue/#danbroid.util.prefs.HasPrefs/PointingToDeclaration/"></a>[getPrefValue](get-pref-value.md)| <a name="danbroid.util.prefs/BasePref/getPrefValue/#danbroid.util.prefs.HasPrefs/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>abstract fun [getPrefValue](get-pref-value.md)(hasPrefs: [HasPrefs](../-has-prefs/index.md)): [T](index.md)  <br><br><br>
| <a name="danbroid.util.prefs/BasePref/getValue/#danbroid.util.prefs.HasPrefs#kotlin.reflect.KProperty[*]/PointingToDeclaration/"></a>[getValue](get-value.md)| <a name="danbroid.util.prefs/BasePref/getValue/#danbroid.util.prefs.HasPrefs#kotlin.reflect.KProperty[*]/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>operator fun [getValue](get-value.md)(thisRef: [HasPrefs](../-has-prefs/index.md), property: [KProperty](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-property/index.html)<*>): [T](index.md)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../danbroid.util.resource/-resource-utils/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F1537741750)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [hashCode](../../danbroid.util.resource/-resource-utils/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F1537741750)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="danbroid.util.prefs/BasePref/setPrefValue/#danbroid.util.prefs.HasPrefs#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[setPrefValue](set-pref-value.md)| <a name="danbroid.util.prefs/BasePref/setPrefValue/#danbroid.util.prefs.HasPrefs#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>abstract fun [setPrefValue](set-pref-value.md)(hasPrefs: [HasPrefs](../-has-prefs/index.md), value: [T](index.md))  <br><br><br>
| <a name="danbroid.util.prefs/BasePref/setValue/#danbroid.util.prefs.HasPrefs#kotlin.reflect.KProperty[*]#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[setValue](set-value.md)| <a name="danbroid.util.prefs/BasePref/setValue/#danbroid.util.prefs.HasPrefs#kotlin.reflect.KProperty[*]#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>operator fun [setValue](set-value.md)(thisRef: [HasPrefs](../-has-prefs/index.md), property: [KProperty](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-property/index.html)<*>, value: [T](index.md))  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../danbroid.util.resource/-resource-utils/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F1537741750)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [toString](../../danbroid.util.resource/-resource-utils/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F1537741750)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="danbroid.util.prefs/BasePref/defValue/#/PointingToDeclaration/"></a>[defValue](def-value.md)| <a name="danbroid.util.prefs/BasePref/defValue/#/PointingToDeclaration/"></a> [androidJvm] val [defValue](def-value.md): [T](index.md)   <br>
| <a name="danbroid.util.prefs/BasePref/keyID/#/PointingToDeclaration/"></a>[keyID](key-i-d.md)| <a name="danbroid.util.prefs/BasePref/keyID/#/PointingToDeclaration/"></a> [androidJvm] val [keyID](key-i-d.md): [K](index.md)   <br>


## Inheritors  
  
|  Name| 
|---|
| <a name="danbroid.util.prefs/NullableStringPref///PointingToDeclaration/"></a>[NullableStringPref](../-nullable-string-pref/index.md)
| <a name="danbroid.util.prefs/StringPref///PointingToDeclaration/"></a>[StringPref](../-string-pref/index.md)
| <a name="danbroid.util.prefs/IntPref///PointingToDeclaration/"></a>[IntPref](../-int-pref/index.md)
| <a name="danbroid.util.prefs/LongPref///PointingToDeclaration/"></a>[LongPref](../-long-pref/index.md)
| <a name="danbroid.util.prefs/BooleanPref///PointingToDeclaration/"></a>[BooleanPref](../-boolean-pref/index.md)
| <a name="danbroid.util.prefs/FloatPref///PointingToDeclaration/"></a>[FloatPref](../-float-pref/index.md)
| <a name="danbroid.util.prefs/DoublePref///PointingToDeclaration/"></a>[DoublePref](../-double-pref/index.md)

