package com.vokrob.foodapp_2.Activity.Dashboard

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.vokrob.foodapp_2.Activity.BaseActivity
import com.vokrob.foodapp_2.Domain.BannerModel
import com.vokrob.foodapp_2.ViewModel.MainViewModel

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { MainScreen() }
    }
}

@Composable
fun MainScreen() {
    val scaffoldState = rememberScaffoldState()
    val viewModel = MainViewModel()
    val banners = remember { mutableStateListOf<BannerModel>() }
    var showBannerLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        viewModel.loadBanner().observeForever {
            banners.clear()
            banners.addAll(it)
            showBannerLoading = false
        }
    }

    Scaffold(
        bottomBar = { MyBottomBar() },
        scaffoldState = scaffoldState
    )
    { paddingValues ->
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item { TopBar() }
            item { Banner(banners, showBannerLoading) }
            item { Search() }
        }
    }
}


























