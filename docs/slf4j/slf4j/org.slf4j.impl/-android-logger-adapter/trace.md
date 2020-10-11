//[slf4j](../../index.md)/[org.slf4j.impl](../index.md)/[AndroidLoggerAdapter](index.md)/[trace](trace.md)



# trace  
[androidJvm]  
Brief description  


Log a message object at level VERBOSE.



## Parameters  
  
androidJvm  
  
|  Name|  Summary| 
|---|---|
| msg| <br><br>- the message object to be logged<br><br>
  
  
Content  
open fun [trace](trace.md)(msg: [String](https://developer.android.com/reference/kotlin/java/lang/String.html))  


[androidJvm]  
Brief description  




Log a message at level VERBOSE according to the specified format and argument. 



 This form avoids superfluous object creation when the logger is disabled for level VERBOSE. 





## Parameters  
  
androidJvm  
  
|  Name|  Summary| 
|---|---|
| arg| <br><br>the argument<br><br>
| format| <br><br>the format string<br><br>
  
  
Content  
open fun [trace](trace.md)(format: [String](https://developer.android.com/reference/kotlin/java/lang/String.html), arg: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html))  


[androidJvm]  
Brief description  




Log a message at level VERBOSE according to the specified format and arguments. 



 This form avoids superfluous object creation when the logger is disabled for the VERBOSE level. 





## Parameters  
  
androidJvm  
  
|  Name|  Summary| 
|---|---|
| arg1| <br><br>the first argument<br><br>
| arg2| <br><br>the second argument<br><br>
| format| <br><br>the format string<br><br>
  
  
Content  
open fun [trace](trace.md)(format: [String](https://developer.android.com/reference/kotlin/java/lang/String.html), arg1: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), arg2: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html))  


[androidJvm]  
Brief description  




Log a message at level VERBOSE according to the specified format and arguments. 



 This form avoids superfluous object creation when the logger is disabled for the VERBOSE level. 





## Parameters  
  
androidJvm  
  
|  Name|  Summary| 
|---|---|
| argArray| <br><br>an array of arguments<br><br>
| format| <br><br>the format string<br><br>
  
  
Content  
open fun [trace](trace.md)(format: [String](https://developer.android.com/reference/kotlin/java/lang/String.html), argArray: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>)  


[androidJvm]  
Brief description  


Log an exception (throwable) at level VERBOSE with an accompanying message.



## Parameters  
  
androidJvm  
  
|  Name|  Summary| 
|---|---|
| msg| <br><br>the message accompanying the exception<br><br>
| t| <br><br>the exception (throwable) to log<br><br>
  
  
Content  
open fun [trace](trace.md)(msg: [String](https://developer.android.com/reference/kotlin/java/lang/String.html), t: [Throwable](https://developer.android.com/reference/kotlin/java/lang/Throwable.html))  



