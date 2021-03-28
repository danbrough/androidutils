//[permissions](../../../index.md)/[danbroid.util.permissions](../index.md)/[PermissionResult](index.md)



# PermissionResult  
 [androidJvm] data class [PermissionResult](index.md)(**requestCode**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), **permissions**: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<out [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)>, **results**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)>)

The result from a permissions request

   


## Constructors  
  
| | |
|---|---|
| <a name="danbroid.util.permissions/PermissionResult/PermissionResult/#kotlin.Int#kotlin.Array[kotlin.String]#kotlin.collections.List[kotlin.Boolean]/PointingToDeclaration/"></a>[PermissionResult](-permission-result.md)| <a name="danbroid.util.permissions/PermissionResult/PermissionResult/#kotlin.Int#kotlin.Array[kotlin.String]#kotlin.collections.List[kotlin.Boolean]/PointingToDeclaration/"></a> [androidJvm] fun [PermissionResult](-permission-result.md)(requestCode: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), permissions: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<out [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)>, results: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)>)   <br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="danbroid.util.permissions/PermissionResult/isGranted/#kotlin.String/PointingToDeclaration/"></a>[isGranted](is-granted.md)| <a name="danbroid.util.permissions/PermissionResult/isGranted/#kotlin.String/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [isGranted](is-granted.md)(permission: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="danbroid.util.permissions/PermissionResult/permissions/#/PointingToDeclaration/"></a>[permissions](permissions.md)| <a name="danbroid.util.permissions/PermissionResult/permissions/#/PointingToDeclaration/"></a> [androidJvm] val [permissions](permissions.md): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<out [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)>The list of permissions that were requested   <br>|
| <a name="danbroid.util.permissions/PermissionResult/requestCode/#/PointingToDeclaration/"></a>[requestCode](request-code.md)| <a name="danbroid.util.permissions/PermissionResult/requestCode/#/PointingToDeclaration/"></a> [androidJvm] val [requestCode](request-code.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)   <br>|
| <a name="danbroid.util.permissions/PermissionResult/results/#/PointingToDeclaration/"></a>[results](results.md)| <a name="danbroid.util.permissions/PermissionResult/results/#/PointingToDeclaration/"></a> [androidJvm] val [results](results.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)>Whether or not each pf the [permissions](permissions.md) was granted   <br>|

