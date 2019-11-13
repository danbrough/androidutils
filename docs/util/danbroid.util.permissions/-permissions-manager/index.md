[util](../../index.md) / [danbroid.util.permissions](../index.md) / [PermissionsManager](./index.md)

# PermissionsManager

`object PermissionsManager`

### Functions

| Name | Summary |
|---|---|
| [processPermissionResult](process-permission-result.md) | `fun processPermissionResult(activity: AppCompatActivity, requestCode: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, permissions: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, grantResults: `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [withPermission](with-permission.md) | `suspend fun withPermission(context: Context, request: PermissionRequest, callback: suspend (`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [withPermissions](with-permissions.md) | `suspend fun withPermissions(activity: Activity, request: PermissionRequest, callback: suspend (`[`PermissionResult`](../-permission-result/index.md)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
