//[permissions](../../../index.md)/[danbroid.util.permissions](../index.md)/[PermissionsManager](index.md)

# PermissionsManager

[androidJvm]\
@ExperimentalCoroutinesApi()

object [PermissionsManager](index.md)

Manages processing and dispatching of permissions request

## Functions

| Name | Summary |
|---|---|
| [close](close.md) | [androidJvm]<br>fun [close](close.md)() |
| [processPermissionResult](process-permission-result.md) | [androidJvm]<br>fun [processPermissionResult](process-permission-result.md)(activity: [AppCompatActivity](https://developer.android.com/reference/kotlin/androidx/appcompat/app/AppCompatActivity.html), requestCode: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), permissions: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<out [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)>, grantResults: [IntArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)) |
| [withPermission](with-permission.md) | [androidJvm]<br>suspend fun [withPermission](with-permission.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), request: PermissionRequest): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>suspend fun [withPermission](with-permission.md)(activity: [Activity](https://developer.android.com/reference/kotlin/android/app/Activity.html), permission: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), rationale: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [withPermissions](with-permissions.md) | [androidJvm]<br>suspend fun [withPermissions](with-permissions.md)(activity: [Activity](https://developer.android.com/reference/kotlin/android/app/Activity.html), request: PermissionRequest): [PermissionResult](../-permission-result/index.md) |
