package ru.mail.mailhackathonapplication.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

sealed class GreenhouseListResponse {

    data class Success(@Expose @SerializedName("statusCode") val statusCode: String?,
                       @Expose @SerializedName("data") val data: MutableList<Data>? = null):GreenhouseListResponse()

    data class Data(@Expose @SerializedName("id") val id: Int? = null,
                    @Expose @SerializedName("groupType") val groupType: String? = null,
                    @Expose @SerializedName("sensorCO2Value") val sensorCo2Value: Double? = null,
                    @Expose @SerializedName("waterTempValue") val waterTempValue: Double? = null,
                    @Expose @SerializedName("airTempValue") val airTempValue: Double? = null,
                    @Expose @SerializedName("humidValue") val humidValue: Double? = null,
                    @Expose @SerializedName("waterDensityValue") val waterDensityValue: Int? = null,
                    @Expose @SerializedName("groupName") val groupName: String? = null,
                    @Expose @SerializedName("groundHumidValue") val groundHumidValue: Double? = null,
                    @Expose @SerializedName("dayLightValue") val dayLightValue: Int? = null)

    data class Error(@Expose @SerializedName("statusCode") val statusCode: String? = null,
                     @Expose @SerializedName("error") val error: String? = null): GreenhouseListResponse()
}