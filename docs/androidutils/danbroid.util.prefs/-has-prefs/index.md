[androidutils](../../index.md) / [danbroid.util.prefs](../index.md) / [HasPrefs](./index.md)

# HasPrefs

`interface HasPrefs`

Classes that allow you to implement properties that delegate to a [android.content.SharedPreferences](#) instance

### Properties

| Name | Summary |
|---|---|
| [prefs](prefs.md) | `abstract val prefs: SharedPreferences` |
| [prefsContext](prefs-context.md) | `abstract val prefsContext: Context` |

### Extension Functions

| Name | Summary |
|---|---|
| [key](../key.md) | `fun `[`HasPrefs`](./index.md)`.key(keyID: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!` |

### Inheritors

| Name | Summary |
|---|---|
| [MainActivity](../../danbroid.util.demo/-main-activity/index.md) | Displays a list of activities to launch`class MainActivity : AppCompatActivity, `[`HasPrefs`](./index.md) |
