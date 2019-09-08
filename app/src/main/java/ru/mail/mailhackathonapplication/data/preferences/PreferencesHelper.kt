package ru.mail.mailhackathonapplication.data.preferences


interface PreferencesHelper {

    fun clearAll()
    fun setAccessTokenFromServer(accessToken: String?)
    fun getAccessToken(): String?
}