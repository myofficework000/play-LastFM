package com.abhishek.lab.lastfmsearch.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.abhishek.lab.lastfmsearch.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit


/**
 * Created by abhishek.pathak on 08/04/2020.
 */

class SplashActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Observable.interval(3, TimeUnit.SECONDS)
            .take(1)
            .observeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { aLong -> navigateToHome() }
    }

    private fun navigateToHome() {
        val homeIntent = Intent(this, MainActivity::class.java)
        startActivity(homeIntent)
        finish()
    }
}

