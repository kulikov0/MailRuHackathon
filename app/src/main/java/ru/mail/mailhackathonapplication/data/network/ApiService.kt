package ru.mail.mailhackathonapplication.data.network

import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*
import ru.mail.mailhackathonapplication.data.network.request.LoginRequest
import ru.mail.mailhackathonapplication.data.network.response.GreenhouseListResponse
import ru.mail.mailhackathonapplication.data.network.response.LoginResponse

interface ApiService {

    @POST("login")
    fun doUserLogin(@Body body: LoginRequest): Observable<Response<LoginResponse>>

    @GET("getgreenhouselist")
    fun getGreenhousesList(): Observable<Response<GreenhouseListResponse>>

}