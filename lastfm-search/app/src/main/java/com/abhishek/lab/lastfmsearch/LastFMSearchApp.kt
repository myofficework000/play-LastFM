package com.abhishek.lab.lastfmsearch

import android.app.Activity
import android.app.Application
import com.abhishek.lab.lastfmsearch.di.AppComponent
import com.abhishek.lab.lastfmsearch.di.DaggerAppComponent
import com.abhishek.lab.lastfmsearch.di.modules.UtilsModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class LastFMSearchApp : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    private lateinit var appComponent: AppComponent

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()

        createAppComponent()
    }

    private fun createAppComponent() {
        appComponent = DaggerAppComponent
            .builder()
            .utilsModule(UtilsModule(this, this))
            .build()

        appComponent.inject(this)
    }
}