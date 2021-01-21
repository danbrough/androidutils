//[slf4j](../../index.md)/[org.slf4j.impl](../index.md)/[AndroidLoggerFactory](index.md)/[loggerNameToTag](logger-name-to-tag.md)



# loggerNameToTag  
[androidJvm]  
Content  
open fun [loggerNameToTag](logger-name-to-tag.md)(loggerName: [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)): [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)  
More info  


Tag names cannot be longer than {@value #TAG_MAX_LENGTH} characters onAndroid platform.



Returns the short logger tag (up to {@value #TAG_MAX_LENGTH} characters)for the given logger name. Traditionally loggers are named byfully-qualified Java classes; this method attempts to return a conciseidentifying part of such names.



See also: android/system/core/include/cutils/property.handroid/frameworks/base/core/jni/android_util_Log.cppdalvik.system.DalvikLogging

  



