[androidutils](../../index.md) / [danbroid.util.prefs](../index.md) / [BasePref](./index.md)

# BasePref

`abstract class BasePref<T, K : `[`Enum`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)`<*>>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `BasePref(keyID: K, defValue: T)` |

### Properties

| Name | Summary |
|---|---|
| [defValue](def-value.md) | `val defValue: T` |
| [keyID](key-i-d.md) | `val keyID: K` |

### Functions

| Name | Summary |
|---|---|
| [getPrefValue](get-pref-value.md) | `abstract fun getPrefValue(hasPrefs: `[`HasPrefs`](../-has-prefs/index.md)`): T` |
| [getValue](get-value.md) | `operator fun getValue(thisRef: `[`HasPrefs`](../-has-prefs/index.md)`, property: `[`KProperty`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-property/index.html)`<*>): T` |
| [setPrefValue](set-pref-value.md) | `abstract fun setPrefValue(hasPrefs: `[`HasPrefs`](../-has-prefs/index.md)`, value: T): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setValue](set-value.md) | `operator fun setValue(thisRef: `[`HasPrefs`](../-has-prefs/index.md)`, property: `[`KProperty`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-property/index.html)`<*>, value: T): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [BooleanPref](../-boolean-pref/index.md) | `class BooleanPref<K : `[`Enum`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)`<*>> : `[`BasePref`](./index.md)`<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, K>` |
| [DoublePref](../-double-pref/index.md) | `class DoublePref<K : `[`Enum`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)`<*>> : `[`BasePref`](./index.md)`<`[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, K>` |
| [FloatPref](../-float-pref/index.md) | `class FloatPref<K : `[`Enum`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)`<*>> : `[`BasePref`](./index.md)`<`[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, K>` |
| [IntPref](../-int-pref/index.md) | `class IntPref<K : `[`Enum`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)`<*>> : `[`BasePref`](./index.md)`<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, K>` |
| [LongPref](../-long-pref/index.md) | `class LongPref<K : `[`Enum`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)`<*>> : `[`BasePref`](./index.md)`<`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, K>` |
| [NullableStringPref](../-nullable-string-pref/index.md) | `class NullableStringPref<K : `[`Enum`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)`<*>> : `[`BasePref`](./index.md)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, K>` |
| [StringPref](../-string-pref/index.md) | `class StringPref<K : `[`Enum`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)`<*>> : `[`BasePref`](./index.md)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, K>` |
