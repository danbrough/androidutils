[androidutils](../../index.md) / [danbroid.util.event](../index.md) / [Event](./index.md)

# Event

`open class Event<out T>`

Used as a wrapper for data that is exposed via a LiveData that represents an event.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Used as a wrapper for data that is exposed via a LiveData that represents an event.`Event(content: T)` |

### Properties

| Name | Summary |
|---|---|
| [hasBeenHandled](has-been-handled.md) | `var hasBeenHandled: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Functions

| Name | Summary |
|---|---|
| [getContentIfNotHandled](get-content-if-not-handled.md) | Returns the content and prevents its use again.`fun getContentIfNotHandled(): T?` |
| [peekContent](peek-content.md) | Returns the content, even if it's already been handled.`fun peekContent(): T` |
