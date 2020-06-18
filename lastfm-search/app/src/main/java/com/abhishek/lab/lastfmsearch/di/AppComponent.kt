package com.abhishek.lab.lastfmsearch.di

import com.abhishek.lab.lastfmsearch.LastFMSearchApp
import com.abhishek.lab.lastfmsearch.di.modules.AppModule
import com.abhishek.lab.lastfmsearch.di.modules.NetworkModule
import com.abhishek.lab.lastfmsearch.di.modules.UtilsModule
import com.abhishek.lab.lastfmsearch.di.modules.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class,
        NetworkModule::class,
        AppModule::class,
        UtilsModule::class,
        ViewModelModule::class
    ]
)

interface AppComponent : AndroidInjector<LastFMSearchApp> {

}