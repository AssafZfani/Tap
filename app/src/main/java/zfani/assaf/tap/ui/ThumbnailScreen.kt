package zfani.assaf.tap.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@Composable
fun ThumbnailScreen(videoId: String?) {
    AsyncImage(
        model = "https://i.ytimg.com/vi/${videoId}/hqdefault.jpg",
        contentDescription = null, contentScale = ContentScale.Fit, modifier = Modifier.fillMaxSize()
    )
}