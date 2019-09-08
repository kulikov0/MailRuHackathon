package ru.mail.mailhackathonapplication.ui.main.interactor

import ru.mail.mailhackathonapplication.data.network.ApiHelper
import ru.mail.mailhackathonapplication.data.network.response.GreenhouseListResponse
import ru.mail.mailhackathonapplication.data.preferences.PreferencesHelper
import ru.mail.mailhackathonapplication.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class MainInteractor @Inject constructor(apiHelper: ApiHelper, preferencesHelper: PreferencesHelper):
        BaseInteractor(apiHelper = apiHelper, preferencesHelper = preferencesHelper), MainMvpInteractor {

    override fun getGreenhouseList(): MutableList<GreenhouseListResponse.Data> {
        return mutableListOf(GreenhouseListResponse.Data(id = 13,
            groupType = "Гидропоника",
            sensorCo2Value = 0.5,
            groupName = "Огурцы",
            humidValue = 0.6,
            airTempValue = 25.3,
            waterTempValue = 25.5,
            waterDensityValue = 1000,
            groundHumidValue = 35.1,
            dayLightValue = 12),
            GreenhouseListResponse.Data(id = 16,
                groupType = "Мультичойс",
                sensorCo2Value = 0.58,
                humidValue = 0.68,
                groupName = "Помидоры",
                airTempValue = 21.9,
                waterTempValue = 22.8,
                waterDensityValue = 1000,
                groundHumidValue = 35.1,
                dayLightValue = 10),
            GreenhouseListResponse.Data(id = 10,
                groupType = "Гидропоника",
                sensorCo2Value = 0.9,
                humidValue = 0.2,
                airTempValue = 29.5,
                groupName = "Редис",
                waterTempValue = 25.4,
                waterDensityValue = 1000,
                groundHumidValue = 36.1,
                dayLightValue = 12),
            GreenhouseListResponse.Data(id = 21,
                groupType = "Почвенная",
                sensorCo2Value = 0.58,
                humidValue = 0.63,
                groupName = "Помидоры",
                airTempValue = 20.3,
                waterTempValue = 23.5,
                waterDensityValue = 1000,
                groundHumidValue = 35.9,
                dayLightValue = 12),
            GreenhouseListResponse.Data(id = 19,
                groupType = "Мультичойс",
                sensorCo2Value = 0.56,
                humidValue = 0.3,
                airTempValue = 25.4,
                groupName = "Огурцы",
                waterTempValue = 25.2,
                waterDensityValue = 1000,
                groundHumidValue = 36.8,
                dayLightValue = 12),
            GreenhouseListResponse.Data(id = 9,
                groupType = "Гидропоника",
                sensorCo2Value = 0.7,
                humidValue = 0.54,
                airTempValue = 25.2,
                waterTempValue = 25.8,
                groupName = "Редис",
                waterDensityValue = 1000,
                groundHumidValue = 29.1,
                dayLightValue = 8))
    }


}