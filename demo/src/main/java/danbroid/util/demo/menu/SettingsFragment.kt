package danbroid.util.demo.menu

import android.os.Bundle
import android.preference.PreferenceFragment
import androidx.preference.PreferenceFragmentCompat
import danbroid.util.demo.R
import java.util.prefs.PreferencesFactory

class SettingsFragment : PreferenceFragmentCompat() {
  override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
    setPreferencesFromResource(R.xml.prefs,rootKey)
  }
}

private val log = org.slf4j.LoggerFactory.getLogger(SettingsFragment::class.java)
