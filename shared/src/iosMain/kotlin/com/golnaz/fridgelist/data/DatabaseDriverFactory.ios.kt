package com.golnaz.fridgelist.data

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.golnaz.fridgelist.db.ThymeDatabase

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver =
        NativeSqliteDriver(ThymeDatabase.Schema, "thyme.db")
}