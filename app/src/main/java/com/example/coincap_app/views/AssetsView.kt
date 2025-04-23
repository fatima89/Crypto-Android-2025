package com.example.coincap_app.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx. compose. ui. Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.example.coincap_app.models.Asset
import com.example.coincap_app.viewModels.AssetsListViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.navigation.NavHostController
import com.example.coincap_app.navigation.BottomNavigationItem

@Composable
fun AssetsList(viewModel: AssetsListViewModel = hiltViewModel(), navController: NavHostController ){

//    val assets = viewModel.assets.collectAsState()
    val assets by viewModel.assets.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.onBackground)
    ){
        items(assets, key = {it.id} ) { asset ->
            AssetRow(asset){ assetId ->
                navController.navigate("${BottomNavigationItem.Home.route}/${assetId}")
            }

        }
    }
}

@Composable
fun AssetRow(asset: Asset, onClick:(String) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick(asset.id) }
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 8.dp)
        ) {
            if (LocalInspectionMode.current) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .size(30.dp)
                )
            } else {
                AsyncImage(
                    model = "https://assets.coincap.io/assets/icons/${asset.symbol.lowercase()}@2x.png",
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                )
            }
        }
        Column {
            Text(
                text = asset.symbol,
                fontSize = 18.sp,
                color = Color.White
            )
            Text(
                text = asset.name,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "${asset.percentage}%",
            modifier = Modifier.padding(horizontal = 16.dp),
            color = if (asset.percentage >= 0) Color.Green else Color.Red,
           // style = Typography.labelLarge
        )
        Text(
            text = "$${asset.price}",
            modifier = Modifier.padding(horizontal = 16.dp),
            color = Color.White,
            //style = Typography.labelLarge
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun AssetsListPreview() {
    //AssetsList()
}