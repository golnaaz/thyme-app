package com.golnaz.fridgelist

import androidx.compose.ui.window.ComposeUIViewController
import com.golnaz.fridgelist.data.AppDependencies
import com.golnaz.fridgelist.data.DatabaseDriverFactory

fun MainViewController() = ComposeUIViewController {
    AppDependencies.initialize(DatabaseDriverFactory())
    App()
}