package com.golnaz.fridgelist

import android.app.Application
import com.golnaz.fridgelist.data.AppDependencies
import com.golnaz.fridgelist.data.DatabaseDriverFactory

class ThymeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppDependencies.initialize(DatabaseDriverFactory(this))
    }
}
