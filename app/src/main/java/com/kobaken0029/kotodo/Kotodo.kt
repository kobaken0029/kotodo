package com.kobaken0029.kotodo

import android.support.multidex.MultiDexApplication
import com.google.firebase.database.FirebaseDatabase
import com.jakewharton.threetenabp.AndroidThreeTen

class Kotodo : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
    }
}
