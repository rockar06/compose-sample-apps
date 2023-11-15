package com.rockar.android.netflixsample.ui.netflix

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rockar.android.netflixsample.ui.theme.NetflixSampleTheme

@Composable
fun AnimatedProfileList(isCircularProgressDisplayed: Boolean) {
    AnimatedVisibility(
        visible = !isCircularProgressDisplayed,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Who's Watching?",
                fontSize = 18.sp,
            )
            Spacer(
                modifier = Modifier
                    .height(16.dp),
            )
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Adaptive(minSize = 128.dp),
                contentPadding = PaddingValues(horizontal = 64.dp),
                verticalItemSpacing = 16.dp,
                modifier = Modifier
                    .wrapContentWidth()
            ) {
                items(4) {
                    CardProfile {
                        println("$it item pressed!")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun AnimatedProfileListPreview() {
    NetflixSampleTheme {
        AnimatedProfileList(isCircularProgressDisplayed = false)
    }
}
