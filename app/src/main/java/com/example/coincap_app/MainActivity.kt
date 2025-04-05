package com.example.coincap_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coincap_app.models.Asset
import com.example.coincap_app.ui.theme.CoinCapAppTheme
import com.example.coincap_app.views.AssetRow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoinCapAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        AssetRow(
                            Asset(
                                id="1",
                                name ="BTC",
                                symbol="Bitcoin",
                                price="87800",
                                percentage=5.38


                            )
                        )
                        Spacer(modifier = Modifier.size(16.dp))
                        AssetRow(
                            Asset(
                                id="2",
                                name ="ETH",
                                symbol="Ethereum",
                                price="1800",
                                percentage=-8.28

                            )
                        )

                    }
                }
            }
        }
    }
}

