package com.rockar.android.netflixsample.ui.netflix

import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rockar.android.netflixsample.R
import com.rockar.android.netflixsample.ui.theme.NetflixSampleTheme

@Composable
fun CardProfile(onClick: () -> Unit) {
    var pressedItem by remember { mutableStateOf(false) }
    val transition: Transition<Boolean> = updateTransition(targetState = pressedItem, label = "")
    val animatedScale: Float by transition.animateFloat(
        transitionSpec = { spring() }, label = "Animate Scale for Image profile"
    ) { pressed ->
        if (pressed) 0.90f else 1f
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .wrapContentWidth()
            .size(height = 128.dp, width = 100.dp)
            .pointerInput(onClick) {
                awaitEachGesture {
                    awaitFirstDown().also {
                        it.consume()
                        pressedItem = true
                    }
                    val up = waitForUpOrCancellation()
                    if (up != null) {
                        up.consume()
                        onClick()
                    }
                    pressedItem = false
                }
            }
    ) {
        Box(
            modifier = Modifier
                .size(100.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.netflix_profile_picture),
                contentDescription = "Profile icon",
                modifier = Modifier
                    .graphicsLayer {
                        scaleX = animatedScale
                        scaleY = animatedScale
                    }
                    .clip(RoundedCornerShape(4.dp))
            )
        }
        Spacer(
            modifier = Modifier
                .height(8.dp),
        )
        Text(
            text = "David",
            fontSize = 12.sp,
            color = Color.White
        )
        Spacer(
            modifier = Modifier
                .height(8.dp),
        )
    }
}

@Preview
@Composable
fun CardProfilePreview() {
    NetflixSampleTheme {
        CardProfile {

        }
    }
}
