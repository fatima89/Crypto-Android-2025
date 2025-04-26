package com.example.coincap_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.coincap_app.ui.theme.CoinCapAppTheme
import com.example.coincap_app.views.MainScreen
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoinCapAppTheme {
                //Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen()

               // }
            }
        }
    }
}

