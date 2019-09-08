package ru.mail.mailhackathonapplication.data.network

import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import ru.mail.mailhackathonapplication.data.network.request.LoginRequest
import ru.mail.mailhackathonapplication.data.network.response.GreenhouseListResponse
import ru.mail.mailhackathonapplication.data.network.response.LoginResponse

interface ApiHelper {

    fun doUserLogin(login: String, password: String): Observable<LoginResponse>
    fun getGreenhouseList(): Observable<GreenhouseListResponse>
}