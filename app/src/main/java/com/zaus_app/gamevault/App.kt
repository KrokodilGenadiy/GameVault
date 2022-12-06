package com.zaus_app.gamevault

import android.app.Application
import com.zaus_app.gamevault.di.AppComponent
import com.zaus_app.gamevault.di.DaggerAppComponent

class App: Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        dagger = DaggerAppComponent.create()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}