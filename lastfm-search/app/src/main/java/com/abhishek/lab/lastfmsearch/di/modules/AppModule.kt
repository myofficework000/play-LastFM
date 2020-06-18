package com.abhishek.lab.lastfmsearch.di.modules

import com.abhishek.lab.lastfmsearch.ui.DetailsFragment
import com.abhishek.lab.lastfmsearch.ui.MainActivity
import com.abhishek.lab.lastfmsearch.ui.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 *
 * Created by  Abhishek Pathak on 16-06-2020.
 * Copyright (C) 2020 myofficework000@gmail.com. All rights reserved
 */

@Module
internal abstract class AppModule {

    @ContributesAndroidInjector
    internal abstract fun contributeMainActivityInjector(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeSearchFragmentInjector(): SearchFragment

    @ContributesAndroidInjector
    abstract fun contributeDetailsFragmentInjector(): DetailsFragment

}
