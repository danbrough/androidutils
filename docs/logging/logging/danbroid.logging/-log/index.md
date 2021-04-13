//[logging](../../../index.md)/[danbroid.logging](../index.md)/[Log](index.md)



# Log  
 [jvm] abstract class [Log](index.md)   


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="danbroid.logging/Log.Level///PointingToDeclaration/"></a>[Level](-level/index.md)| <a name="danbroid.logging/Log.Level///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>enum [Level](-level/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<[Log.Level](-level/index.md)>   <br><br><br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="danbroid.logging/Log/debug/#kotlin.CharSequence?#kotlin.Throwable?/PointingToDeclaration/"></a>[debug](debug.md)| <a name="danbroid.logging/Log/debug/#kotlin.CharSequence?#kotlin.Throwable?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [debug](debug.md)(msg: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)?, error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)? = null)  <br><br><br>|
| <a name="danbroid.logging/Log/error/#kotlin.CharSequence?#kotlin.Throwable?/PointingToDeclaration/"></a>[error](error.md)| <a name="danbroid.logging/Log/error/#kotlin.CharSequence?#kotlin.Throwable?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [error](error.md)(msg: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)?, error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)? = null)  <br><br><br>|
| <a name="danbroid.logging/Log/info/#kotlin.CharSequence?#kotlin.Throwable?/PointingToDeclaration/"></a>[info](info.md)| <a name="danbroid.logging/Log/info/#kotlin.CharSequence?#kotlin.Throwable?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [info](info.md)(msg: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)?, error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)? = null)  <br><br><br>|
| <a name="danbroid.logging/Log/trace/#kotlin.CharSequence?#kotlin.Throwable?/PointingToDeclaration/"></a>[trace](trace.md)| <a name="danbroid.logging/Log/trace/#kotlin.CharSequence?#kotlin.Throwable?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [trace](trace.md)(msg: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)?, error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)? = null)  <br><br><br>|
| <a name="danbroid.logging/Log/warn/#kotlin.CharSequence?#kotlin.Throwable?/PointingToDeclaration/"></a>[warn](warn.md)| <a name="danbroid.logging/Log/warn/#kotlin.CharSequence?#kotlin.Throwable?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [warn](warn.md)(msg: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)?, error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)? = null)  <br><br><br>|
| <a name="danbroid.logging/Log/write_log/#danbroid.logging.Log.Level#kotlin.CharSequence?#kotlin.Throwable?/PointingToDeclaration/"></a>[write_log](write_log.md)| <a name="danbroid.logging/Log/write_log/#danbroid.logging.Log.Level#kotlin.CharSequence?#kotlin.Throwable?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [write_log](write_log.md)(level: [Log.Level](-level/index.md), msg: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)?, error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)?)  <br><br><br>|
| <a name="danbroid.logging/Log/write_log_native/#kotlin.String#danbroid.logging.Log.Level#kotlin.CharSequence?#kotlin.Throwable?/PointingToDeclaration/"></a>[write_log_native](write_log_native.md)| <a name="danbroid.logging/Log/write_log_native/#kotlin.String#danbroid.logging.Log.Level#kotlin.CharSequence?#kotlin.Throwable?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [write_log_native](write_log_native.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), level: [Log.Level](-level/index.md), msg: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)?, error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)?)  <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="danbroid.logging/Log/name/#/PointingToDeclaration/"></a>[name](name.md)| <a name="danbroid.logging/Log/name/#/PointingToDeclaration/"></a> [jvm] abstract val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)   <br>|


## Inheritors  
  
|  Name | 
|---|
| <a name="danbroid.logging/AndroidLog///PointingToDeclaration/"></a>[AndroidLog](../-android-log/index.md)|
| <a name="danbroid.logging/NullLog///PointingToDeclaration/"></a>[NullLog](../-null-log/index.md)|
| <a name="danbroid.logging/StdOutLog///PointingToDeclaration/"></a>[StdOutLog](../-std-out-log/index.md)|
| <a name="danbroid.logging/Slf4jLogImpl///PointingToDeclaration/"></a>[Slf4jLogImpl](../-slf4j-log-impl/index.md)|

