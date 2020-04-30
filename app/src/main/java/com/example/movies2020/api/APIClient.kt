package com.example.movies2020.api

import com.example.movies2020.utils.APIConstant.API_KEY
import com.example.movies2020.utils.APIConstant.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Duy M. Nguyen on 4/29/2020.
 */
class APIClient : BaseRetrofitClient() {

    override fun baseUrl(): String? {
        return BASE_URL
    }

    override fun httpClient(): OkHttpClient? {
        return OkHttpClient.Builder()
            .addInterceptor {
                val url = it.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("apikey", API_KEY)
                    .build()

                val request = it.request()
                    .newBuilder()
                    .url(url)
                    .build()

                it.proceed(request)
            }
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    override fun implementRx(): Boolean {
        return true
    }

    override fun converter(): Converter.Factory? {
        return GsonConverterFactory.create()
    }
}