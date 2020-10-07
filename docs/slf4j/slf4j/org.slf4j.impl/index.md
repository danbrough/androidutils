//[slf4j](../index.md)/[org.slf4j.impl](index.md)



# Package org.slf4j.impl  


## Types  
  
|  Name|  Summary| 
|---|---|
| [AndroidLoggerAdapter](-android-logger-adapter/index.md)| [androidJvm]  <br>Brief description  <br><br><br><br><br> A simple implementation that delegates all log requests to the Google Android logging facilities. Note that this logger does not support org.slf4j.Marker . Methods taking marker data as parameter simply invoke the eponymous method without the Marker argument, discarding any marker data in the process. <br><br><br><br> The logging levels specified for SLF4J can be almost directly mapped to the levels that exist in the Google Android platform. The following table shows the mapping implemented by this logger. <br><br><br><br> Use loggers as usual: <br><br><ul><li>Declare a loggerprivate static final Logger logger = LoggerFactory.getLogger(MyClass.class);</li><li>Invoke logging methods, e.g.,logger.debug("Some log message. Details: { } ", someObject);logger.debug("Some log message with varargs. Details: { } , { } , { } ", someObject1, someObject2, someObject3);</li></ul><br><br> Logger instances created using the LoggerFactory are named either according to the name or the fully qualified class name of the class given as a parameter. Each logger name will be used as the log message tag on the Android platform. However, tag names cannot be longer than 23 characters so if logger name exceeds this limit then it will be truncated by the LoggerFactory. The following examples illustrate this. <br><br><br><br>  <br>Content  <br>open class [AndroidLoggerAdapter](-android-logger-adapter/index.md) : MarkerIgnoringBase  <br><br><br>
| [AndroidLoggerFactory](-android-logger-factory/index.md)| [androidJvm]  <br>Content  <br>open class [AndroidLoggerFactory](-android-logger-factory/index.md) : ILoggerFactory  <br><br><br>
| [StaticLoggerBinder](-static-logger-binder/index.md)| [androidJvm]  <br>Content  <br>open class [StaticLoggerBinder](-static-logger-binder/index.md) : LoggerFactoryBinder  <br><br><br>

