package com.example.coincap_app.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coincap_app.models.Asset
import com.example.coincap_app.services.CoinCapApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AssetsListViewModel @Inject constructor(
    private val apiService: CoinCapApiService
): ViewModel() {

    //TODO: Add Loading
    private val _assets= MutableStateFlow<List<Asset>>(emptyList())
    val assets: StateFlow<List<Asset>> = _assets
    //TODO: add error

    init{
        fetchAssets()
    }

    private fun fetchAssets()
    {
        //Print A
        viewModelScope.launch{
            try{
                val result =apiService.getAssets().data
                val mappedAssets = result.map { assetResponse ->
                    //val price =assetResponse.priceUsd.format("%.2f").toDouble()
                    val price = String.format("%.2f",assetResponse.priceUsd.toDouble())
                    val percentage = String.format("%.2f", assetResponse.changePercent24Hr.toDouble()).toDouble()
                    Asset(
                        assetResponse.id,
                        assetResponse.name,
                        assetResponse.symbol,
                        price,
                        percentage
                    )
                }
                _assets.value=mappedAssets
                //Print C
            } catch (e:Exception){
                //TODO:Handle error
                print(e.message)

            }
        }
        //Print B
    }
}