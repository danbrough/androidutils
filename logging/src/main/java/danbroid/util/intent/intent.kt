package danbroid.util.intent

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri


fun Uri.toPendingIntent(context: Context, action: String = Intent.ACTION_VIEW, requestCode: Int = 0,
                        flags: Int = PendingIntent.FLAG_CANCEL_CURRENT
): PendingIntent =
    Intent(action).setData(this).let {
      PendingIntent.getActivity(context, requestCode, it, flags)
    }
