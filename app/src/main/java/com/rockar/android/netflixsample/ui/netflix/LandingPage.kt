package com.rockar.android.netflixsample.ui.netflix

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PlainTooltipBox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rockar.android.netflixsample.R
import com.rockar.android.netflixsample.ui.theme.NetflixSampleTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LandingPage() {
    val haptics = LocalHapticFeedback.current
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                title = {
                    Icon(
                        modifier = Modifier
                            .height(120.dp),
                        painter = painterResource(id = R.drawable.ic_netflix_logo),
                        tint = Color.Unspecified,
                        contentDescription = "App logo"
                    )
                },
                actions = {
                    PlainTooltipBox(
                        contentColor = Color.Black,
                        containerColor = Color.White,
                        tooltip = {
                            haptics.performHapticFeedback(HapticFeedbackType.LongPress)
                            Text("Edit profiles")
                        },
                    ) {
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .tooltipAnchor()
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_edit_24dp),
                                contentDescription = "Edit profiles"
                            )
                        }
                    }
                },
            )
        }
    ) {
        val scope = rememberCoroutineScope()
        var displayLoading by remember { mutableStateOf(true) }
        SideEffect {
            scope.launch {
                delay(2000L)
                displayLoading = false
            }
        }
        MainView(paddingValues = it, displayLoading)
    }
}

@Composable
fun MainView(paddingValues: PaddingValues, displayLoading: Boolean) {
    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        AnimatedCircleProgress(displayLoading)
        AnimatedProfileList(displayLoading)
    }
}


@Preview()
@Composable
fun LandingPagePreview() {
    NetflixSampleTheme {
        LandingPage()
    }
}
