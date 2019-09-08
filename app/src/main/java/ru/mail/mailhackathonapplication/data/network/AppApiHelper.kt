package ru.mail.mailhackathonapplication.data.network

import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializer
import com.google.gson.JsonObject
import io.reactivex.Observable
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.mail.mailhackathonapplication.BuildConfig
import ru.mail.mailhackathonapplication.data.network.request.LoginRequest
import ru.mail.mailhackathonapplication.data.network.response.GreenhouseListResponse
import ru.mail.mailhackathonapplication.data.network.response.LoginResponse
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class AppApiHelper @Inject constructor(private val apiHeader: ApiHeader): ApiHelper {


    private val service: ApiService

    init {

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val headersInterceptor = Interceptor { chain ->
            chain.proceed(chain.request().newBuilder()
                .addHeader("token", apiHeader.publicApiHeader.apiKey)
                .build())
        }

        val buildClient = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(headersInterceptor)
            .addInterceptor(logging)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_SERVER_URL_RU)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(
                GsonConverterFactory
                .create(GsonBuilder()
                    .registerTypeAdapter(LoginResponse::class.java, JsonDeserializer<LoginResponse> { json, _, context ->
                        json as JsonObject
                            when {
                                json.has("token") -> context.deserialize(json, LoginResponse.Success::class.java)
                                json.has("error") -> context.deserialize(json, LoginResponse.Error::class.java)
                                else                           -> throw IllegalArgumentException("Unsupported json object; could not parse into a LoginResponse instance: $json")
                        }
                    })
                    .registerTypeAdapter(GreenhouseListResponse::class.java, JsonDeserializer<GreenhouseListResponse> { json, _, context ->
                        json as JsonObject
                        when {
                            json.has("token") -> context.deserialize(json, GreenhouseListResponse.Success::class.java)
                            json.has("error") -> context.deserialize(json, GreenhouseListResponse.Error::class.java)
                            else                           -> throw IllegalArgumentException("Unsupported json object; could not parse into a LoginResponse instance: $json")
                        }
                    })
                    .create()))
            .client(buildClient)
            .build()

        service = retrofit.create(ApiService::class.java)
    }


    override fun doUserLogin(login: String, password: String): Observable<LoginResponse> {
        return service.doUserLogin(LoginRequest(login = login, password = password))
            .flatMap { response ->
                when (response.isSuccessful) {
                    false -> Observable.error(HttpException(response))
                    true  -> Observable.just(response.body()!!)
                }
            }
    }

    override fun getGreenhouseList(): Observable<GreenhouseListResponse> {
        return service.getGreenhousesList()
            .flatMap {response ->
                when (response.isSuccessful) {
                    false -> Observable.error(HttpException(response))
                    true  -> Observable.just(response.body()!!)
                }
            }
    }

}