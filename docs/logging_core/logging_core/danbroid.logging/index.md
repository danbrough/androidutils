//[logging_core](../../index.md)/[danbroid.logging](index.md)

# Package danbroid.logging

## Types

| Name | Summary |
|---|---|
| [DBLog](-d-b-log/index.md) | [jvm]<br>interface [DBLog](-d-b-log/index.md) |
| [LogConfig](-log-config/index.md) | [jvm]<br>object [LogConfig](-log-config/index.md) |
| [NoOpLog](-no-op-log/index.md) | [jvm]<br>object [NoOpLog](-no-op-log/index.md) : [DBLog](-d-b-log/index.md) |
| [StdOutLog](-std-out-log/index.md) | [jvm]<br>object [StdOutLog](-std-out-log/index.md) : [DBLog](-d-b-log/index.md) |

## Functions

| Name | Summary |
|---|---|
| [colorInt](color-int.md) | [jvm]<br>fun [DBLog.Level](-d-b-log/-level/index.md).[colorInt](color-int.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [colouredDecorator](coloured-decorator.md) | [jvm]<br>fun [colouredDecorator](coloured-decorator.md)(level: [DBLog.Level](-d-b-log/-level/index.md), msg: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [detailedDecorator](detailed-decorator.md) | [jvm]<br>inline fun [detailedDecorator](detailed-decorator.md)(level: [DBLog.Level](-d-b-log/-level/index.md), msg: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [getLog](get-log.md) | [jvm]<br>inline fun [getLog](get-log.md)(tag: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [DBLog](-d-b-log/index.md)<br>inline fun [getLog](get-log.md)(kclass: [KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)&lt;*&gt;): [DBLog](-d-b-log/index.md) |
