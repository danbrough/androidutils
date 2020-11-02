package danbroid.util.menu

import android.view.ContextMenu
import androidx.fragment.app.Fragment

typealias ContextMenuProvider = ContextMenu.(fragment: Fragment) -> Unit