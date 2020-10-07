//[misc](../../index.md)/[danbroid.util.prefs](../index.md)/[BasePref](index.md)



# BasePref  
 [androidJvm] abstract class [BasePref](index.md)<[T](index.md), [K](index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<*>>(**keyID**: [K](index.md), **defValue**: [T](index.md))   


## Functions  
  
|  Name|  Summary| 
|---|---|
| [equals](../../danbroid.util.resource/-resource-utils/index.md#kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>open operator override fun [equals](../../danbroid.util.resource/-resource-utils/index.md#kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [getPrefValue](get-pref-value.md)| [androidJvm]  <br>Content  <br>abstract fun [getPrefValue](get-pref-value.md)(hasPrefs: [HasPrefs](../-has-prefs/index.md)): [T](index.md)  <br><br><br>
| [getValue](get-value.md)| [androidJvm]  <br>Content  <br>operator fun [getValue](get-value.md)(thisRef: [HasPrefs](../-has-prefs/index.md), property: [KProperty](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-property/index.html)<*>): [T](index.md)  <br><br><br>
| [hashCode](../../danbroid.util.resource/-resource-utils/index.md#kotlin/Any/hashCode/#/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>open override fun [hashCode](../../danbroid.util.resource/-resource-utils/index.md#kotlin/Any/hashCode/#/PointingToDeclaration/)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [setPrefValue](set-pref-value.md)| [androidJvm]  <br>Content  <br>abstract fun [setPrefValue](set-pref-value.md)(hasPrefs: [HasPrefs](../-has-prefs/index.md), value: [T](index.md))  <br><br><br>
| [setValue](set-value.md)| [androidJvm]  <br>Content  <br>operator fun [setValue](set-value.md)(thisRef: [HasPrefs](../-has-prefs/index.md), property: [KProperty](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-property/index.html)<*>, value: [T](index.md))  <br><br><br>
| [toString](../../danbroid.util.resource/-resource-utils/index.md#kotlin/Any/toString/#/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>open override fun [toString](../../danbroid.util.resource/-resource-utils/index.md#kotlin/Any/toString/#/PointingToDeclaration/)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [defValue](index.md#danbroid.util.prefs/BasePref/defValue/#/PointingToDeclaration/)|  [androidJvm] val [defValue](index.md#danbroid.util.prefs/BasePref/defValue/#/PointingToDeclaration/): [T](index.md)   <br>
| [keyID](index.md#danbroid.util.prefs/BasePref/keyID/#/PointingToDeclaration/)|  [androidJvm] val [keyID](index.md#danbroid.util.prefs/BasePref/keyID/#/PointingToDeclaration/): [K](index.md)   <br>


## Inheritors  
  
|  Name| 
|---|
| [NullableStringPref](../-nullable-string-pref/index.md)
| [StringPref](../-string-pref/index.md)
| [IntPref](../-int-pref/index.md)
| [LongPref](../-long-pref/index.md)
| [BooleanPref](../-boolean-pref/index.md)
| [FloatPref](../-float-pref/index.md)
| [DoublePref](../-double-pref/index.md)

