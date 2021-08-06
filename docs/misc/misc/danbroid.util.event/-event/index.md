//[misc](../../../index.md)/[danbroid.util.event](../index.md)/[Event](index.md)

# Event

[androidJvm]\
open class [Event](index.md)<out [T](index.md)>(**content**: [T](index.md))

Used as a wrapper for data that is exposed via a LiveData that represents an event.

## Constructors

| | |
|---|---|
| [Event](-event.md) | [androidJvm]<br>fun <out [T](index.md)> [Event](-event.md)(content: [T](index.md)) |

## Functions

| Name | Summary |
|---|---|
| [getContentIfNotHandled](get-content-if-not-handled.md) | [androidJvm]<br>fun [getContentIfNotHandled](get-content-if-not-handled.md)(): [T](index.md)?<br>Returns the content and prevents its use again. |
| [peekContent](peek-content.md) | [androidJvm]<br>fun [peekContent](peek-content.md)(): [T](index.md)<br>Returns the content, even if it's already been handled. |

## Properties

| Name | Summary |
|---|---|
| [hasBeenHandled](has-been-handled.md) | [androidJvm]<br>var [hasBeenHandled](has-been-handled.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false |
