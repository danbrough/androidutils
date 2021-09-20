//[logging_jvm](../../../index.md)/[danbroid.logging](../index.md)/[DBLog](index.md)

# DBLog

[jvm]\
interface [DBLog](index.md)

## Types

| Name | Summary |
|---|---|
| [Level](-level/index.md) | [jvm]<br>enum [Level](-level/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[DBLog.Level](-level/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [ddebug](ddebug.md) | [jvm]<br>open fun [ddebug](ddebug.md)(msg: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)?, error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)? = null) |
| [debug](debug.md) | [jvm]<br>open fun [debug](debug.md)(msg: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)?, error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)? = null) |
| [derror](derror.md) | [jvm]<br>open fun [derror](derror.md)(msg: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)?, error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)? = null) |
| [dinfo](dinfo.md) | [jvm]<br>open fun [dinfo](dinfo.md)(msg: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)?, error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)? = null) |
| [dtrace](dtrace.md) | [jvm]<br>open fun [dtrace](dtrace.md)(msg: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)?, error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)? = null) |
| [dwarn](dwarn.md) | [jvm]<br>open fun [dwarn](dwarn.md)(msg: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)?, error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)? = null) |
| [error](error.md) | [jvm]<br>open fun [error](error.md)(msg: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)?, error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)? = null) |
| [info](info.md) | [jvm]<br>open fun [info](info.md)(msg: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)?, error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)? = null) |
| [trace](trace.md) | [jvm]<br>open fun [trace](trace.md)(msg: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)?, error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)? = null) |
| [warn](warn.md) | [jvm]<br>open fun [warn](warn.md)(msg: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)?, error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)? = null) |
| [write_log_native](write_log_native.md) | [jvm]<br>abstract fun [write_log_native](write_log_native.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), level: [DBLog.Level](-level/index.md), msg: [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)?, error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)?) |

## Properties

| Name | Summary |
|---|---|
| [logName](log-name.md) | [jvm]<br>abstract var [logName](log-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Inheritors

| Name |
|---|
| [NoOpLog](../-no-op-log/index.md) |
| [StdOutLog](../-std-out-log/index.md) |
