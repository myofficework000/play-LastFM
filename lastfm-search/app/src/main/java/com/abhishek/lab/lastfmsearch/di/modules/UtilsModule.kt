package com.abhishek.lab.lastfmsearch.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import com.abhishek.lab.lastfmsearch.LastFMSearchApp
import com.abhishek.lab.lastfmsearch.R
import com.abhishek.lab.lastfmsearch.managers.SearchManager
import com.abhishek.lab.lastfmsearch.managers.SearchManagerImpl
import com.abhishek.lab.lastfmsearch.services.SearchApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 *
 * This class have utility methods.
 * <p>
 * Created by  Abhishek Pathak on 16-06-2020.
 * Copyright (C) 2020 myofficework000@gmail.com. All rights reserved
 */

const val PREF_FILE = "lastfmsearch.prefs"

@Module
class UtilsModule(
    private val context: Context,
    private val application: Application
) {

    @Provides
    fun providesApplication(): Application {
        return application
    }

    @Provides
    fun providesLastFMSearchApplication(): LastFMSearchApp {
        return application as LastFMSearchApp
    }

    @Provides
    fun providesContext(): Context {
        return context
    }

    @Provides
    fun providesResources(): Resources {
        return context.resources
    }

    @Singleton
    @Provides
    fun providesSharedPref(): SharedPreferences {
        return context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideSearchApiService(okHttpClient: OkHttpClient): SearchApiService {
        val retrofit = Retrofit
            .Builder()
            .baseUrl(context.getString(R.string.search_api_base_url))
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(SearchApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideSearchManager(searchApiService: SearchApiService): SearchManager {
        return SearchManagerImpl(searchApiService, context)
    }
}