package com.abhishek.lab.lastfmsearch.di.modules

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

/**
 *
 * Created by  Abhishek Pathak on 16-06-2020.
 * Copyright (C) 2020 myofficework000@gmail.com. All rights reserved
 */
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()
                val builder = original.newBuilder().method(original.method(), original.body())
                builder.header("Content-Type", "application/x-www-form-urlencoded")
                chain.proceed(builder.build())
            }.build()
    }

}