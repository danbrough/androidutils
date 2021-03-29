//[logging_core](../../../index.md)/[danbroid.logging](../index.md)/[DBLog](index.md)



# DBLog  
 [jvm] interface [DBLog](index.md)   


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="danbroid.logging/DBLog.Level///PointingToDeclaration/"></a>[Level](-level/index.md)| <a name="danbroid.logging/DBLog.Level///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>enum [Level](-level/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<[DBLog.Level](-level/index.md)>   <br><br><br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="danbroid.logging/DBLog/debug/#kotlin.CharSequence?#kotlin.Throwable?/PointingToDeclaration/"></a>[debug](debug.md)| <a name="danbroid.logging/DBLog/debug/#kotlin.CharSequence?#kotlin.Throwable?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [debug](debug.md)(msg: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)?, error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)? = null)  <br><br><br>|
| <a name="danbroid.logging/DBLog/error/#kotlin.CharSequence?#kotlin.Throwable?/PointingToDeclaration/"></a>[error](error.md)| <a name="danbroid.logging/DBLog/error/#kotlin.CharSequence?#kotlin.Throwable?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [error](error.md)(msg: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)?, error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)? = null)  <br><br><br>|
| <a name="danbroid.logging/DBLog/info/#kotlin.CharSequence?#kotlin.Throwable?/PointingToDeclaration/"></a>[info](info.md)| <a name="danbroid.logging/DBLog/info/#kotlin.CharSequence?#kotlin.Throwable?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [info](info.md)(msg: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)?, error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)? = null)  <br><br><br>|
| <a name="danbroid.logging/DBLog/trace/#kotlin.CharSequence?#kotlin.Throwable?/PointingToDeclaration/"></a>[trace](trace.md)| <a name="danbroid.logging/DBLog/trace/#kotlin.CharSequence?#kotlin.Throwable?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [trace](trace.md)(msg: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)?, error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)? = null)  <br><br><br>|
| <a name="danbroid.logging/DBLog/warn/#kotlin.CharSequence?#kotlin.Throwable?/PointingToDeclaration/"></a>[warn](warn.md)| <a name="danbroid.logging/DBLog/warn/#kotlin.CharSequence?#kotlin.Throwable?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [warn](warn.md)(msg: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)?, error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)? = null)  <br><br><br>|
| <a name="danbroid.logging/DBLog/write_log/#danbroid.logging.DBLog.Level#kotlin.CharSequence?#kotlin.Throwable?/PointingToDeclaration/"></a>[write_log](write_log.md)| <a name="danbroid.logging/DBLog/write_log/#danbroid.logging.DBLog.Level#kotlin.CharSequence?#kotlin.Throwable?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [write_log](write_log.md)(level: [DBLog.Level](-level/index.md), msg: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)?, error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)?)  <br><br><br>|
| <a name="danbroid.logging/DBLog/write_log_native/#kotlin.String#danbroid.logging.DBLog.Level#kotlin.CharSequence?#kotlin.Throwable?/PointingToDeclaration/"></a>[write_log_native](write_log_native.md)| <a name="danbroid.logging/DBLog/write_log_native/#kotlin.String#danbroid.logging.DBLog.Level#kotlin.CharSequence?#kotlin.Throwable?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [write_log_native](write_log_native.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), level: [DBLog.Level](-level/index.md), msg: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)?, error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)?)  <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="danbroid.logging/DBLog/logName/#/PointingToDeclaration/"></a>[logName](log-name.md)| <a name="danbroid.logging/DBLog/logName/#/PointingToDeclaration/"></a> [jvm] abstract val [logName](log-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)   <br>|


## Inheritors  
  
|  Name | 
|---|
| <a name="danbroid.logging/NullLog///PointingToDeclaration/"></a>[NullLog](../-null-log/index.md)|
| <a name="danbroid.logging/StdOutLog///PointingToDeclaration/"></a>[StdOutLog](../-std-out-log/index.md)|
| <a name="danbroid.logging/Slf4jLogImpl///PointingToDeclaration/"></a>[Slf4jLogImpl](../-slf4j-log-impl/index.md)|

