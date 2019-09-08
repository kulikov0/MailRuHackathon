package ru.mail.mailhackathonapplication.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

sealed class LoginResponse {

    data class Success (@Expose @SerializedName("statusCode") val statusCode: String? = null,
                        @Expose @SerializedName("token") val token: String? = null): LoginResponse()

    data class Error (@Expose @SerializedName("statusCode") val statusCode: String? = null,
                      @Expose @SerializedName("error") val error: String? = null): LoginResponse()
}