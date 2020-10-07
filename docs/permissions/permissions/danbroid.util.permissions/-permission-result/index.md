//[permissions](../../index.md)/[danbroid.util.permissions](../index.md)/[PermissionResult](index.md)



# PermissionResult  
 [androidJvm] 

The result from a permissions request

data class [PermissionResult](index.md)(**requestCode**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), **permissions**: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<out [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)>, **results**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)>)   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| [PermissionResult](-permission-result.md)|  [androidJvm] fun [PermissionResult](-permission-result.md)(requestCode: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), permissions: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<out [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)>, results: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)>)   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [component1](component1.md)| [androidJvm]  <br>Content  <br>operator fun [component1](component1.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [component2](component2.md)| [androidJvm]  <br>Content  <br>operator fun [component2](component2.md)(): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<out [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)>  <br><br><br>
| [component3](component3.md)| [androidJvm]  <br>Content  <br>operator fun [component3](component3.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)>  <br><br><br>
| [copy](copy.md)| [androidJvm]  <br>Content  <br>fun [copy](copy.md)(requestCode: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), permissions: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<out [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)>, results: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)>): [PermissionResult](index.md)  <br><br><br>
| [equals](../-permissions-manager/index.md#kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>open operator override fun [equals](../-permissions-manager/index.md#kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](../-permissions-manager/index.md#kotlin/Any/hashCode/#/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>open override fun [hashCode](../-permissions-manager/index.md#kotlin/Any/hashCode/#/PointingToDeclaration/)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [isGranted](is-granted.md)| [androidJvm]  <br>Content  <br>fun [isGranted](is-granted.md)(permission: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [toString](../-permissions-manager/index.md#kotlin/Any/toString/#/PointingToDeclaration/)| [androidJvm]  <br>Content  <br>open override fun [toString](../-permissions-manager/index.md#kotlin/Any/toString/#/PointingToDeclaration/)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [permissions](index.md#danbroid.util.permissions/PermissionResult/permissions/#/PointingToDeclaration/)|  [androidJvm] <br><br>The list of permissions that were requested<br><br>val [permissions](index.md#danbroid.util.permissions/PermissionResult/permissions/#/PointingToDeclaration/): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<out [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)>   <br>
| [requestCode](index.md#danbroid.util.permissions/PermissionResult/requestCode/#/PointingToDeclaration/)|  [androidJvm] val [requestCode](index.md#danbroid.util.permissions/PermissionResult/requestCode/#/PointingToDeclaration/): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)   <br>
| [results](index.md#danbroid.util.permissions/PermissionResult/results/#/PointingToDeclaration/)|  [androidJvm] <br><br>Whether or not each pf the [permissions](index.md#danbroid.util.permissions/PermissionResult/permissions/#/PointingToDeclaration/) was granted<br><br>val [results](index.md#danbroid.util.permissions/PermissionResult/results/#/PointingToDeclaration/): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)>   <br>

