package com.mrs.joybor.retrofit

object ApiClient {
    private const val BASE_URL = "https://joyboryangi.pythonanywhere.com/"

    val api: JoyBorService by lazy {
        retrofit2.Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
            .build()
            .create(JoyBorService::class.java)
    }
}