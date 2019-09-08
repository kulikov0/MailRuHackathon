package ru.mail.mailhackathonapplication.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.mail.mailhackathonapplication.data.preferences.AppPreferencesHelper
import javax.inject.Inject

class ApiHeader @Inject constructor(internal val publicApiHeader: PublicApiHeader, preferencesHelper: AppPreferencesHelper) {

    class PublicApiHeader @Inject constructor(
        @Expose
        @SerializedName ("api_key") val apiKey: String)

}