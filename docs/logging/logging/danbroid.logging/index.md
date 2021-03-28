//[logging](../../index.md)/[danbroid.logging](index.md)



# Package danbroid.logging  


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="danbroid.logging/Log///PointingToDeclaration/"></a>[Log](-log/index.md)| <a name="danbroid.logging/Log///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>interface [Log](-log/index.md)  <br><br><br>|
| <a name="danbroid.logging/LogConfig///PointingToDeclaration/"></a>[LogConfig](-log-config/index.md)| <a name="danbroid.logging/LogConfig///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>object [LogConfig](-log-config/index.md)  <br><br><br>|
| <a name="danbroid.logging/LogImpl///PointingToDeclaration/"></a>[LogImpl](-log-impl/index.md)| <a name="danbroid.logging/LogImpl///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract class [LogImpl](-log-impl/index.md)(**name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [Log](-log/index.md)  <br><br><br>|
| <a name="danbroid.logging/NullLog///PointingToDeclaration/"></a>[NullLog](-null-log/index.md)| <a name="danbroid.logging/NullLog///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [NullLog](-null-log/index.md) : [Log](-log/index.md)  <br><br><br>|
| <a name="danbroid.logging/PrintlnImpl///PointingToDeclaration/"></a>[PrintlnImpl](-println-impl/index.md)| <a name="danbroid.logging/PrintlnImpl///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [PrintlnImpl](-println-impl/index.md)(**name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [LogImpl](-log-impl/index.md)  <br><br><br>|
| <a name="danbroid.logging/Slf4jLogImpl///PointingToDeclaration/"></a>[Slf4jLogImpl](-slf4j-log-impl/index.md)| <a name="danbroid.logging/Slf4jLogImpl///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Slf4jLogImpl](-slf4j-log-impl/index.md)(**kclass**: [KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)<*>) : [LogImpl](-log-impl/index.md)  <br><br><br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="danbroid.logging//createLog/#kotlin.String/PointingToDeclaration/"></a>[createLog](create-log.md)| <a name="danbroid.logging//createLog/#kotlin.String/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [createLog](create-log.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Log](-log/index.md)  <br>fun [createLog](create-log.md)(kclass: [KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)<*>): [Log](-log/index.md)  <br><br><br>|

