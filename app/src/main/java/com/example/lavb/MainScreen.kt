package com.example.lavb

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

enum class BottomTab {
    ForYou,
    Headlines,
    Favorites,
    Newsstand
}

@Composable
fun MainScreen() {

    var selectedTab by remember { mutableStateOf(BottomTab.ForYou) }

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.surface,
                tonalElevation = 0.dp
            ) {

                NavigationBarItem(
                    selected = selectedTab == BottomTab.ForYou,
                    onClick = { selectedTab = BottomTab.ForYou },
                    icon = { Icon(Icons.Default.Home, contentDescription = null) },
                    label = { Text("For You") }
                )

                NavigationBarItem(
                    selected = selectedTab == BottomTab.Headlines,
                    onClick = { selectedTab = BottomTab.Headlines },
                    icon = { Icon(Icons.Default.Public, contentDescription = null) },
                    label = { Text("Headlines") }
                )

                NavigationBarItem(
                    selected = selectedTab == BottomTab.Favorites,
                    onClick = { selectedTab = BottomTab.Favorites },
                    icon = { Icon(Icons.Default.Star, contentDescription = null) },
                    label = { Text("Favorites") }
                )

                NavigationBarItem(
                    selected = selectedTab == BottomTab.Newsstand,
                    onClick = { selectedTab = BottomTab.Newsstand },
                    icon = { Icon(Icons.Default.Storefront, contentDescription = null) },
                    label = { Text("Newsstand") }
                )
            }
        }
    ) { paddingValues ->

        when (selectedTab) {
            BottomTab.ForYou ->
                ForYouScreen(modifier = Modifier.padding(paddingValues))

            BottomTab.Headlines ->
                Text("Headlines Screen", modifier = Modifier.padding(paddingValues))

            BottomTab.Favorites ->
                Text("Favorites Screen", modifier = Modifier.padding(paddingValues))

            BottomTab.Newsstand ->
                Text("Newsstand Screen", modifier = Modifier.padding(paddingValues))
        }
    }
}