package com.kobaken0029.kotodo

import android.support.multidex.MultiDexApplication
import com.jakewharton.threetenabp.AndroidThreeTen

class Kotodo : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }
}
