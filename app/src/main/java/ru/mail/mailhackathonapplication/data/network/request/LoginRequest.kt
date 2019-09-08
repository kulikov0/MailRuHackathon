package ru.mail.mailhackathonapplication.data.network.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginRequest(@Expose @SerializedName("login") val login: String? = null,
                        @Expose @SerializedName("password") val password: String? = null)