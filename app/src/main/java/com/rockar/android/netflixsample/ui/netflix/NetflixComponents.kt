package com.rockar.android.netflixsample.ui.netflix

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rockar.android.netflixsample.ui.theme.NetflixSampleTheme

@Composable
fun AnimatedCircleProgress(enabled: Boolean) {
    AnimatedVisibility(
        visible = enabled,
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .width(48.dp),
            color = MaterialTheme.colorScheme.secondary,
        )
    }
}

@Preview
@Composable
fun AnimatedCircleProgressPreview() {
    NetflixSampleTheme {
        AnimatedCircleProgress(enabled = true)
    }
}
