[androidutils](../../index.md) / [danbroid.util.demo.permissions](../index.md) / [PermissionsActivity](./index.md)

# PermissionsActivity

`class PermissionsActivity : AppCompatActivity, RationaleCallbacks`

This activity demonstrates the functionality in the permissions library

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | This activity demonstrates the functionality in the permissions library`PermissionsActivity()` |

### Functions

| Name | Summary |
|---|---|
| [onCreate](on-create.md) | `fun onCreate(savedInstanceState: Bundle?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onRationaleAccepted](on-rationale-accepted.md) | `fun onRationaleAccepted(requestCode: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onRationaleDenied](on-rationale-denied.md) | `fun onRationaleDenied(requestCode: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onRequestPermissionsResult](on-request-permissions-result.md) | Dispatches the result to [danbroid.util.permissions.PermissionsManager.processPermissionResult](../../danbroid.util.permissions/-permissions-manager/process-permission-result.md)`fun onRequestPermissionsResult(requestCode: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, permissions: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, grantResults: `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [showDir](show-dir.md) | `fun showDir(directory: `[`File`](https://docs.oracle.com/javase/8/docs/api/java/io/File.html)`, addToBackStack: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
