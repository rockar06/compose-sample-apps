package com.rockar.android.netflixsample.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PlainTooltipBox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rockar.android.netflixsample.R
import com.rockar.android.netflixsample.ui.theme.NetflixSampleTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LandingPage() {
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
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .width(48.dp)
                    .align(Alignment.Center),
                color = MaterialTheme.colorScheme.secondary,
            )
            Column(
                modifier = Modifier

            ) {
                
            }
        }
    }
}

@Preview()
@Composable
fun LandingPagePreview() {
    NetflixSampleTheme {
        LandingPage()
    }
}
