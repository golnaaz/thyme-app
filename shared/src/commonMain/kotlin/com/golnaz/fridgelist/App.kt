package com.golnaz.fridgelist

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.golnaz.fridgelist.ui.FridgeScreen
import com.golnaz.fridgelist.ui.RecipesScreen
import com.golnaz.fridgelist.ui.SettingsScreen
import com.golnaz.fridgelist.ui.ShoppingListScreen

@Composable
fun App() {
    MaterialTheme {
        var selectedTab by remember { mutableIntStateOf(0) }

        Scaffold(
            bottomBar = {
                NavigationBar {
                    NavigationBarItem(
                        icon = { Icon(Icons.Filled.Home, contentDescription = null) },
                        label = { Text("Kühlschrank") },
                        selected = selectedTab == 0,
                        onClick = { selectedTab = 0 }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Filled.Star, contentDescription = null) },
                        label = { Text("Rezepte") },
                        selected = selectedTab == 1,
                        onClick = { selectedTab = 1 }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Filled.Done, contentDescription = null) },
                        label = { Text("Einkaufsliste") },
                        selected = selectedTab == 2,
                        onClick = { selectedTab = 2 }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Filled.Settings, contentDescription = null) },
                        label = { Text("Einstellungen") },
                        selected = selectedTab == 3,
                        onClick = { selectedTab = 3 }
                    )
                }
            }
        ) { _ ->
            when (selectedTab) {
                0 -> FridgeScreen()
                1 -> RecipesScreen()
                2 -> ShoppingListScreen()
                3 -> SettingsScreen()
            }
        }
    }
}