package com.google.mlkit.md

import android.app.Application
import com.google.mlkit.md.timber.ReleaseTree
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // Timber
        setUpTimber()
    }


    /**
     * Plan the corresponding tree
     */
    private fun setUpTimber(){
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Timber.i("Timber set up in DEBUG level")
        } else {
            Timber.plant(ReleaseTree())
            Timber.i("Timber set up in RELEASE level")
        }

    }

}