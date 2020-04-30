package com.example.movies2020.api

/**
 * Created by Duy M. Nguyen on 4/29/2020.
 */
object API {
    val apiService: APIService = APIClient().getService(APIService::class.java)
}