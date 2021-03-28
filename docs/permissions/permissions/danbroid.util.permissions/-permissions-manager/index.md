//[permissions](../../../index.md)/[danbroid.util.permissions](../index.md)/[PermissionsManager](index.md)



# PermissionsManager  
 [androidJvm] @ExperimentalCoroutinesApi()  
  
object [PermissionsManager](index.md)

Manages processing and dispatching of permissions request

   


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="danbroid.util.permissions/PermissionsManager/close/#/PointingToDeclaration/"></a>[close](close.md)| <a name="danbroid.util.permissions/PermissionsManager/close/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [close](close.md)()  <br><br><br>|
| <a name="danbroid.util.permissions/PermissionsManager/processPermissionResult/#androidx.appcompat.app.AppCompatActivity#kotlin.Int#kotlin.Array[kotlin.String]#kotlin.IntArray/PointingToDeclaration/"></a>[processPermissionResult](process-permission-result.md)| <a name="danbroid.util.permissions/PermissionsManager/processPermissionResult/#androidx.appcompat.app.AppCompatActivity#kotlin.Int#kotlin.Array[kotlin.String]#kotlin.IntArray/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [processPermissionResult](process-permission-result.md)(activity: [AppCompatActivity](https://developer.android.com/reference/kotlin/androidx/appcompat/app/AppCompatActivity.html), requestCode: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), permissions: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<out [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)>, grantResults: [IntArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html))  <br><br><br>|
| <a name="danbroid.util.permissions/PermissionsManager/withPermission/#android.content.Context#pub.devrel.easypermissions.PermissionRequest/PointingToDeclaration/"></a>[withPermission](with-permission.md)| <a name="danbroid.util.permissions/PermissionsManager/withPermission/#android.content.Context#pub.devrel.easypermissions.PermissionRequest/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>suspend fun [withPermission](with-permission.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), request: PermissionRequest): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br>suspend fun [withPermission](with-permission.md)(activity: [Activity](https://developer.android.com/reference/kotlin/android/app/Activity.html), permission: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), rationale: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>|
| <a name="danbroid.util.permissions/PermissionsManager/withPermissions/#android.app.Activity#pub.devrel.easypermissions.PermissionRequest/PointingToDeclaration/"></a>[withPermissions](with-permissions.md)| <a name="danbroid.util.permissions/PermissionsManager/withPermissions/#android.app.Activity#pub.devrel.easypermissions.PermissionRequest/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>suspend fun [withPermissions](with-permissions.md)(activity: [Activity](https://developer.android.com/reference/kotlin/android/app/Activity.html), request: PermissionRequest): [PermissionResult](../-permission-result/index.md)  <br><br><br>|

