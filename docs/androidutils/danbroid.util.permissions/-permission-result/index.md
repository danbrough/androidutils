[androidutils](../../index.md) / [danbroid.util.permissions](../index.md) / [PermissionResult](./index.md)

# PermissionResult

`data class PermissionResult`

The result from a permissions request

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | The result from a permissions request`PermissionResult(requestCode: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, permissions: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, results: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>)` |

### Properties

| Name | Summary |
|---|---|
| [permissions](permissions.md) | The list of permissions that were requested`val permissions: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [requestCode](request-code.md) | `val requestCode: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [results](results.md) | Whether or not each pf the [permissions](permissions.md) was granted`val results: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>` |

### Functions

| Name | Summary |
|---|---|
| [isGranted](is-granted.md) | `fun isGranted(permission: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
