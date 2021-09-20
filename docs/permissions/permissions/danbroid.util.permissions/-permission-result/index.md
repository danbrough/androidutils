//[permissions](../../../index.md)/[danbroid.util.permissions](../index.md)/[PermissionResult](index.md)

# PermissionResult

[androidJvm]\
data class [PermissionResult](index.md)(requestCode: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), permissions: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;out [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;, results: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt;)

The result from a permissions request

## Constructors

| | |
|---|---|
| [PermissionResult](-permission-result.md) | [androidJvm]<br>fun [PermissionResult](-permission-result.md)(requestCode: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), permissions: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;out [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;, results: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt;) |

## Functions

| Name | Summary |
|---|---|
| [isGranted](is-granted.md) | [androidJvm]<br>fun [isGranted](is-granted.md)(permission: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

## Properties

| Name | Summary |
|---|---|
| [permissions](permissions.md) | [androidJvm]<br>val [permissions](permissions.md): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;out [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;<br>The list of permissions that were requested |
| [requestCode](request-code.md) | [androidJvm]<br>val [requestCode](request-code.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [results](results.md) | [androidJvm]<br>val [results](results.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt;<br>Whether or not each pf the [permissions](permissions.md) was granted |
