//[misc](../index.md)/[danbroid.util.prefs](index.md)



# Package danbroid.util.prefs  


## Types  
  
|  Name|  Summary| 
|---|---|
| [BasePref](-base-pref/index.md)| [androidJvm]  <br>Content  <br>abstract class [BasePref](-base-pref/index.md)<[T](-base-pref/index.md), [K](-base-pref/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<*>>(**keyID**: [K](-base-pref/index.md), **defValue**: [T](-base-pref/index.md))  <br><br><br>
| [BooleanPref](-boolean-pref/index.md)| [androidJvm]  <br>Content  <br>class [BooleanPref](-boolean-pref/index.md)<[K](-boolean-pref/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<*>>(**keyID**: [K](-boolean-pref/index.md), **defValue**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) : [BasePref](-base-pref/index.md)<[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), [K](-boolean-pref/index.md)>   <br><br><br>
| [DoublePref](-double-pref/index.md)| [androidJvm]  <br>Content  <br>class [DoublePref](-double-pref/index.md)<[K](-double-pref/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<*>>(**keyID**: [K](-double-pref/index.md), **defValue**: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)) : [BasePref](-base-pref/index.md)<[Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), [K](-double-pref/index.md)>   <br><br><br>
| [FloatPref](-float-pref/index.md)| [androidJvm]  <br>Content  <br>class [FloatPref](-float-pref/index.md)<[K](-float-pref/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<*>>(**keyID**: [K](-float-pref/index.md), **defValue**: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)) : [BasePref](-base-pref/index.md)<[Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), [K](-float-pref/index.md)>   <br><br><br>
| [HasPrefs](-has-prefs/index.md)| [androidJvm]  <br>Brief description  <br><br><br>Classes that allow you to implement properties that delegate to a [android.content.SharedPreferences](https://developer.android.com/reference/kotlin/android/content/SharedPreferences.html) instance<br><br>  <br>Content  <br>interface [HasPrefs](-has-prefs/index.md)  <br><br><br>
| [IntPref](-int-pref/index.md)| [androidJvm]  <br>Content  <br>class [IntPref](-int-pref/index.md)<[K](-int-pref/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<*>>(**keyID**: [K](-int-pref/index.md), **defValue**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) : [BasePref](-base-pref/index.md)<[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [K](-int-pref/index.md)>   <br><br><br>
| [LongPref](-long-pref/index.md)| [androidJvm]  <br>Content  <br>class [LongPref](-long-pref/index.md)<[K](-long-pref/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<*>>(**keyID**: [K](-long-pref/index.md), **defValue**: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) : [BasePref](-base-pref/index.md)<[Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), [K](-long-pref/index.md)>   <br><br><br>
| [NullableStringPref](-nullable-string-pref/index.md)| [androidJvm]  <br>Content  <br>class [NullableStringPref](-nullable-string-pref/index.md)<[K](-nullable-string-pref/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<*>>(**keyID**: [K](-nullable-string-pref/index.md), **defValue**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) : [BasePref](-base-pref/index.md)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, [K](-nullable-string-pref/index.md)>   <br><br><br>
| [StringPref](-string-pref/index.md)| [androidJvm]  <br>Content  <br>class [StringPref](-string-pref/index.md)<[K](-string-pref/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<*>>(**keyID**: [K](-string-pref/index.md), **defValue**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [BasePref](-base-pref/index.md)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [K](-string-pref/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [get](get.md)| [androidJvm]  <br>Content  <br>inline fun <[T](get.md)> [SharedPreferences](https://developer.android.com/reference/kotlin/android/content/SharedPreferences.html).[get](get.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), defaultValue: [T](get.md)): [T](get.md)  <br><br><br>
| [put](put.md)| [androidJvm]  <br>Content  <br>inline fun <[T](put.md)> [SharedPreferences](https://developer.android.com/reference/kotlin/android/content/SharedPreferences.html).[put](put.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [T](put.md))  <br><br><br>

