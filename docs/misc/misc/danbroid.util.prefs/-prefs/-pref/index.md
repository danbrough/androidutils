//[misc](../../../../index.md)/[danbroid.util.prefs](../../index.md)/[Prefs](../index.md)/[Pref](index.md)

# Pref

[androidJvm]\
@[ExperimentalStdlibApi](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-experimental-stdlib-api/index.html)

inner class [Pref](index.md)(defValue: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?)

val message:String by Pref("default value") var count:Int? by Pref(null)

## Constructors

| | |
|---|---|
| [Pref](-pref.md) | [androidJvm]<br>fun [Pref](-pref.md)(defValue: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?) |

## Functions

| Name | Summary |
|---|---|
| [getValue](get-value.md) | [androidJvm]<br>operator fun &lt;[T](get-value.md)&gt; [getValue](get-value.md)(thisRef: [Prefs](../index.md), property: [KProperty](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-property/index.html)&lt;*&gt;): [T](get-value.md) |
| [setValue](set-value.md) | [androidJvm]<br>operator fun &lt;[T](set-value.md)&gt; [setValue](set-value.md)(thisRef: [Prefs](../index.md), property: [KProperty](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-property/index.html)&lt;*&gt;, value: [T](set-value.md)) |

## Properties

| Name | Summary |
|---|---|
| [defValue](def-value.md) | [androidJvm]<br>val [defValue](def-value.md): [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? |
