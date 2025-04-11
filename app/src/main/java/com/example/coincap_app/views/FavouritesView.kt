package com.example.coincap_app.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.coincap_app.navigation.BottomNavigationItem

@Composable
fun Favourites() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Favourites")
    }
}