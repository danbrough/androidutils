//[menu2](../../index.md)/[danbroid.util.menu.ui](index.md)/[menu](menu.md)

# menu

[androidJvm]\
inline fun LazyListScope.[menu](menu.md)(menu: [Menu](../danbroid.util.menu/-menu/index.md), sticky: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, highLighted: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, clickable: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true)

inline fun LazyListScope.[menu](menu.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = "_${MenuContext.NEXT_ID++}", menu: [Menu](../danbroid.util.menu/-menu/index.md) = Menu(id, "Untitled"), sticky: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, highLighted: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, clickable: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, crossinline onCreate: @Composable()[Menu](../danbroid.util.menu/-menu/index.md).() -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))
