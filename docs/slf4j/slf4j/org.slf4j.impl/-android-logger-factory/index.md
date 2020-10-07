//[slf4j](../../index.md)/[org.slf4j.impl](../index.md)/[AndroidLoggerFactory](index.md)



# AndroidLoggerFactory  
 [androidJvm] open class [AndroidLoggerFactory](index.md) : ILoggerFactory   


## Types  
  
|  Name|  Summary| 
|---|---|
| [LogInfo](-log-info/index.md)| [androidJvm]  <br>Content  <br>open class [LogInfo](-log-info/index.md)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [getLogger](get-logger.md)| [androidJvm]  <br>Brief description  <br><br><br>Return a [AndroidLoggerAdapter](../-android-logger-adapter/index.md) instance by name.<br><br>  <br>Content  <br>open fun [getLogger](get-logger.md)(name: [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)): Logger  <br><br><br>[androidJvm]  <br>Content  <br>abstract fun [getLogger](index.md#org.slf4j/ILoggerFactory/getLogger/#java.lang.String/PointingToDeclaration/)(p: [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)): Logger  <br><br><br>
| [loggerNameToTag](logger-name-to-tag.md)| [androidJvm]  <br>Brief description  <br><br><br><br><br>Tag names cannot be longer than {@value #TAG_MAX_LENGTH} characters on Android platform. <br><br><br><br> Returns the short logger tag (up to {@value #TAG_MAX_LENGTH} characters) for the given logger name. Traditionally loggers are named by fully-qualified Java classes; this method attempts to return a concise identifying part of such names. <br><br><br><br> See also: android/system/core/include/cutils/property.h android/frameworks/base/core/jni/android_util_Log.cpp dalvik.system.DalvikLogging<br><br><br><br>  <br>Content  <br>open fun [loggerNameToTag](logger-name-to-tag.md)(loggerName: [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)): [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [ANONYMOUS_TAG](index.md#org.slf4j.impl/AndroidLoggerFactory/ANONYMOUS_TAG/#/PointingToDeclaration/)|  [androidJvm] val [ANONYMOUS_TAG](index.md#org.slf4j.impl/AndroidLoggerFactory/ANONYMOUS_TAG/#/PointingToDeclaration/): [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)   <br>
| [DEFAULT_LOG_INFO](index.md#org.slf4j.impl/AndroidLoggerFactory/DEFAULT_LOG_INFO/#/PointingToDeclaration/)|  [androidJvm] open val [DEFAULT_LOG_INFO](index.md#org.slf4j.impl/AndroidLoggerFactory/DEFAULT_LOG_INFO/#/PointingToDeclaration/): [AndroidLoggerFactory.LogInfo](-log-info/index.md)   <br>
| [LOGGERS](index.md#org.slf4j.impl/AndroidLoggerFactory/LOGGERS/#/PointingToDeclaration/)|  [androidJvm] open val [LOGGERS](index.md#org.slf4j.impl/AndroidLoggerFactory/LOGGERS/#/PointingToDeclaration/): [ConcurrentHashMap](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ConcurrentHashMap.html)<[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [AndroidLoggerFactory.LogInfo](-log-info/index.md)>   <br>
| [TAG](index.md#org.slf4j.impl/AndroidLoggerFactory/TAG/#/PointingToDeclaration/)|  [androidJvm] open val [TAG](index.md#org.slf4j.impl/AndroidLoggerFactory/TAG/#/PointingToDeclaration/): [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)   <br>
| [TAG_MAX_LENGTH](index.md#org.slf4j.impl/AndroidLoggerFactory/TAG_MAX_LENGTH/#/PointingToDeclaration/)|  [androidJvm] val [TAG_MAX_LENGTH](index.md#org.slf4j.impl/AndroidLoggerFactory/TAG_MAX_LENGTH/#/PointingToDeclaration/): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)   <br>

