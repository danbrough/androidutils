//[permissions](../../index.md)/[danbroid.util.permissions](../index.md)/[PermissionsManager](index.md)



# PermissionsManager  
 [androidJvm] 

Manages processing and dispatching of permissions request

@ExperimentalCoroutinesApi()  
  
object [PermissionsManager](index.md)   


## Functions  
  
|  Name|  Summary| 
|---|---|
| [close](close.md)| [androidJvm]  <br>Content  <br>fun [close](close.md)()  <br><br><br>
| [equals](index.md#kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>open operator override fun [equals](index.md#kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](index.md#kotlin/Any/hashCode/#/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>open override fun [hashCode](index.md#kotlin/Any/hashCode/#/PointingToDeclaration/)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [processPermissionResult](process-permission-result.md)| [androidJvm]  <br>Content  <br>fun [processPermissionResult](process-permission-result.md)(activity: [AppCompatActivity](https://developer.android.com/reference/kotlin/androidx/appcompat/app/AppCompatActivity.html), requestCode: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), permissions: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<out [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)>, grantResults: [IntArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html))  <br><br><br>
| [toString](index.md#kotlin/Any/toString/#/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>open override fun [toString](index.md#kotlin/Any/toString/#/PointingToDeclaration/)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| [withPermission](with-permission.md)| [androidJvm]  <br>Content  <br>suspend fun [withPermission](with-permission.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), request: PermissionRequest): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br>suspend fun [withPermission](with-permission.md)(activity: [Activity](https://developer.android.com/reference/kotlin/android/app/Activity.html), permission: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), rationale: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [withPermissions](with-permissions.md)| [androidJvm]  <br>Content  <br>suspend fun [withPermissions](with-permissions.md)(activity: [Activity](https://developer.android.com/reference/kotlin/android/app/Activity.html), request: PermissionRequest): [PermissionResult](../-permission-result/index.md)  <br><br><br>

