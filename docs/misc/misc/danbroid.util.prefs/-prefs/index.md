//[misc](../../../index.md)/[danbroid.util.prefs](../index.md)/[Prefs](index.md)

# Prefs

[androidJvm]\
open class [Prefs](index.md)(**context**: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), **prefsCreator**: ([Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) -> [SharedPreferences](https://developer.android.com/reference/kotlin/android/content/SharedPreferences.html))

Classes that allow you to implement properties that delegate to a [android.content.SharedPreferences](https://developer.android.com/reference/kotlin/android/content/SharedPreferences.html) instance

## Constructors

| | |
|---|---|
| [Prefs](-prefs.md) | [androidJvm]<br>fun [Prefs](-prefs.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), prefsFile: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [Prefs](-prefs.md) | [androidJvm]<br>fun [Prefs](-prefs.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), prefsCreator: ([Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) -> [SharedPreferences](https://developer.android.com/reference/kotlin/android/content/SharedPreferences.html)) |

## Types

| Name | Summary |
|---|---|
| [Pref](-pref/index.md) | [androidJvm]<br>@[ExperimentalStdlibApi](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-experimental-stdlib-api/index.html)()<br>inner class [Pref](-pref/index.md)(**defValue**: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?)<br>val message:String by Pref("default value") var count:Int? |

## Functions

| Name | Summary |
|---|---|
| [clear](clear.md) | [androidJvm]<br>fun [clear](clear.md)(): [SharedPreferences.Editor](https://developer.android.com/reference/kotlin/android/content/SharedPreferences.Editor.html) |
| [close](close.md) | [androidJvm]<br>fun [close](close.md)(commit: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false) |
| [finalize](finalize.md) | [androidJvm]<br>fun [finalize](finalize.md)() |
| [get](get.md) | [androidJvm]<br>@[ExperimentalStdlibApi](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-experimental-stdlib-api/index.html)()<br>fun [get](get.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), defaultValue: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?, type: [KType](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-type/index.html)): [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? |
| [put](put.md) | [androidJvm]<br>fun [put](put.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?) |

## Properties

| Name | Summary |
|---|---|
| [editor](editor.md) | [androidJvm]<br>val [editor](editor.md): [SharedPreferences.Editor](https://developer.android.com/reference/kotlin/android/content/SharedPreferences.Editor.html) |
| [prefs](prefs.md) | [androidJvm]<br>val [prefs](prefs.md): [SharedPreferences](https://developer.android.com/reference/kotlin/android/content/SharedPreferences.html) |
