package chargily.epay.android

import retrofit2.*
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory

object ChargilyApiClient {
    private const val BASE_URL: String = "https://epay.chargily.com.dz"

    private val gson : Gson by lazy {
        GsonBuilder().setLenient().create()
    }

    private val httpClient : OkHttpClient by lazy {
        OkHttpClient.Builder().build()
    }

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }

    val chargilyApi : ChargilyApi by lazy {
        retrofit.create(ChargilyApi::class.java)
    }
}

