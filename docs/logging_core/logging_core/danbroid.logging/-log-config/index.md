//[logging_core](../../../index.md)/[danbroid.logging](../index.md)/[LogConfig](index.md)

# LogConfig

[jvm]\
object [LogConfig](index.md)

## Properties

| Name | Summary |
|---|---|
| [COLOURED](-c-o-l-o-u-r-e-d.md) | [jvm]<br>var [COLOURED](-c-o-l-o-u-r-e-d.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false<br>Coloured console output |
| [DEBUG](-d-e-b-u-g.md) | [jvm]<br>var [DEBUG](-d-e-b-u-g.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true |
| [defaultLog](default-log.md) | [jvm]<br>lateinit var [defaultLog](default-log.md): [DBLog](../-d-b-log/index.md) |
| [DETAILED](-d-e-t-a-i-l-e-d.md) | [jvm]<br>var [DETAILED](-d-e-t-a-i-l-e-d.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true<br>Apply the [DetailedDecorator](../-detailed-decorator.md). default: true |
| [GET_LOG](-g-e-t_-l-o-g.md) | [jvm]<br>var [GET_LOG](-g-e-t_-l-o-g.md): ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [DBLog](../-d-b-log/index.md)? |
| [MESSAGE_DECORATOR](-m-e-s-s-a-g-e_-d-e-c-o-r-a-t-o-r.md) | [jvm]<br>var [MESSAGE_DECORATOR](-m-e-s-s-a-g-e_-d-e-c-o-r-a-t-o-r.md): ([DBLog.Level](../-d-b-log/-level/index.md), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [MIN_LOG_LEVEL](-m-i-n_-l-o-g_-l-e-v-e-l.md) | [jvm]<br>var [MIN_LOG_LEVEL](-m-i-n_-l-o-g_-l-e-v-e-l.md): [DBLog.Level](../-d-b-log/-level/index.md)? = null |
| [STACK_DEPTH](-s-t-a-c-k_-d-e-p-t-h.md) | [jvm]<br>var [STACK_DEPTH](-s-t-a-c-k_-d-e-p-t-h.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 4<br>How far to go back up the stack to get the line number and method name |
