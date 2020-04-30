package com.example.movies2020.api

import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

abstract class BaseRetrofitClient {

    fun <T> getService(service: Class<T>): T {
        if (retrofit == null) {
            val baseUrl = baseUrl()
            val okHttpClient = httpClient()
            val converter = converter()

            val builder = Retrofit.Builder()

            baseUrl?.let { builder.baseUrl(it) }
            okHttpClient?.let { builder.client(it) }
            converter?.let { builder.addConverterFactory(it) }

            if (implementRx()) {
                builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            }

            retrofit = builder.build()
        }
        return retrofit!!.create(service)
    }

    protected abstract fun baseUrl(): String?
    protected abstract fun httpClient(): OkHttpClient?
    protected abstract fun converter(): Converter.Factory?
    protected abstract fun implementRx(): Boolean

    companion object {
        private var retrofit: Retrofit? = null
    }
}