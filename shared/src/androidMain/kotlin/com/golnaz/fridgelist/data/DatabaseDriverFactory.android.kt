package com.golnaz.fridgelist.data

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.golnaz.fridgelist.db.ThymeDatabase

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver =
        AndroidSqliteDriver(ThymeDatabase.Schema, context, "thyme.db")
}