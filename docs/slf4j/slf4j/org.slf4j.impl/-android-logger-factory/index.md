//[slf4j](../../index.md)/[org.slf4j.impl](../index.md)/[AndroidLoggerFactory](index.md)



# AndroidLoggerFactory  
 [androidJvm] open class [AndroidLoggerFactory](index.md) : ILoggerFactory   


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="org.slf4j.impl/AndroidLoggerFactory.LogInfo///PointingToDeclaration/"></a>[LogInfo](-log-info/index.md)| <a name="org.slf4j.impl/AndroidLoggerFactory.LogInfo///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open class [LogInfo](-log-info/index.md)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="org.slf4j.impl/AndroidLoggerFactory/getLogger/#java.lang.String/PointingToDeclaration/"></a>[getLogger](get-logger.md)| <a name="org.slf4j.impl/AndroidLoggerFactory/getLogger/#java.lang.String/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [getLogger](get-logger.md)(name: [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)): Logger  <br>More info  <br>Return a [AndroidLoggerAdapter](../-android-logger-adapter/index.md) instance by name.  <br><br><br>[androidJvm]  <br>Content  <br>abstract fun [getLogger](index.md#%5Borg.slf4j%2FILoggerFactory%2FgetLogger%2F%23java.lang.String%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1633267292)(p: [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)): Logger  <br><br><br>
| <a name="org.slf4j.impl/AndroidLoggerFactory/loggerNameToTag/#java.lang.String/PointingToDeclaration/"></a>[loggerNameToTag](logger-name-to-tag.md)| <a name="org.slf4j.impl/AndroidLoggerFactory/loggerNameToTag/#java.lang.String/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open fun [loggerNameToTag](logger-name-to-tag.md)(loggerName: [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)): [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)  <br>More info  <br>Tag names cannot be longer than {@value #TAG_MAX_LENGTH} characters onAndroid platform.  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="org.slf4j.impl/AndroidLoggerFactory/ANONYMOUS_TAG/#/PointingToDeclaration/"></a>[ANONYMOUS_TAG](-a-n-o-n-y-m-o-u-s_-t-a-g.md)| <a name="org.slf4j.impl/AndroidLoggerFactory/ANONYMOUS_TAG/#/PointingToDeclaration/"></a> [androidJvm] val [ANONYMOUS_TAG](-a-n-o-n-y-m-o-u-s_-t-a-g.md): [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)   <br>
| <a name="org.slf4j.impl/AndroidLoggerFactory/DEFAULT_LOG_INFO/#/PointingToDeclaration/"></a>[DEFAULT_LOG_INFO](-d-e-f-a-u-l-t_-l-o-g_-i-n-f-o.md)| <a name="org.slf4j.impl/AndroidLoggerFactory/DEFAULT_LOG_INFO/#/PointingToDeclaration/"></a> [androidJvm] open val [DEFAULT_LOG_INFO](-d-e-f-a-u-l-t_-l-o-g_-i-n-f-o.md): [AndroidLoggerFactory.LogInfo](-log-info/index.md)   <br>
| <a name="org.slf4j.impl/AndroidLoggerFactory/LOGGERS/#/PointingToDeclaration/"></a>[LOGGERS](-l-o-g-g-e-r-s.md)| <a name="org.slf4j.impl/AndroidLoggerFactory/LOGGERS/#/PointingToDeclaration/"></a> [androidJvm] open val [LOGGERS](-l-o-g-g-e-r-s.md): [ConcurrentHashMap](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ConcurrentHashMap.html)<[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [AndroidLoggerFactory.LogInfo](-log-info/index.md)>   <br>
| <a name="org.slf4j.impl/AndroidLoggerFactory/TAG/#/PointingToDeclaration/"></a>[TAG](-t-a-g.md)| <a name="org.slf4j.impl/AndroidLoggerFactory/TAG/#/PointingToDeclaration/"></a> [androidJvm] open val [TAG](-t-a-g.md): [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)   <br>
| <a name="org.slf4j.impl/AndroidLoggerFactory/TAG_MAX_LENGTH/#/PointingToDeclaration/"></a>[TAG_MAX_LENGTH](-t-a-g_-m-a-x_-l-e-n-g-t-h.md)| <a name="org.slf4j.impl/AndroidLoggerFactory/TAG_MAX_LENGTH/#/PointingToDeclaration/"></a> [androidJvm] val [TAG_MAX_LENGTH](-t-a-g_-m-a-x_-l-e-n-g-t-h.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)   <br>

