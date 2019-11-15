[androidutils](../../index.md) / [danbroid.util.permissions](../index.md) / [PermissionsManager](./index.md)

# PermissionsManager

`object PermissionsManager`

Manages processing and dispatching of permissions request

### Properties

| Name | Summary |
|---|---|
| [REQUEST_CODE](-r-e-q-u-e-s-t_-c-o-d-e.md) | `const val REQUEST_CODE: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Functions

| Name | Summary |
|---|---|
| [close](close.md) | `fun close(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [processPermissionResult](process-permission-result.md) | `fun processPermissionResult(activity: AppCompatActivity, requestCode: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, permissions: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, grantResults: `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [withPermission](with-permission.md) | `suspend fun withPermission(context: Context, request: PermissionRequest, callback: suspend (`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [withPermissions](with-permissions.md) | `suspend fun withPermissions(activity: Activity, request: PermissionRequest, callback: suspend (`[`PermissionResult`](../-permission-result/index.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
