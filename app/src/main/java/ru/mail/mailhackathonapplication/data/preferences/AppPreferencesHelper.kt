package ru.mail.mailhackathonapplication.data.preferences

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class AppPreferencesHelper @Inject constructor(context: Context, private val prefName: String): PreferencesHelper {

    private val prefs: SharedPreferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

    override fun clearAll() = prefs.edit().clear().apply()

    companion object {
        private const val PREF_KEY_ACCESS_TOKEN      = "PREF_KEY_ACCESS_TOKEN"
    }

    override fun setAccessTokenFromServer(accessToken: String?) = prefs.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken).apply()

    override fun getAccessToken(): String? = prefs.getString(PREF_KEY_ACCESS_TOKEN, "")

}