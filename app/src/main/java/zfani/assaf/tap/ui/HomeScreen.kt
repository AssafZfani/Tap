package zfani.assaf.tap.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import zfani.assaf.tap.ui.theme.TapTheme

@Composable
fun HomeScreen(navController: NavController) {
    val viewModel = hiltViewModel<MainViewModel>()
    TapTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Column {
                SearchBar {
                    viewModel.searchVideos(it)
                }
                LazyColumn(content = {
                    items(viewModel.videos) {
                        Column(
                            Modifier
                                .padding(10.dp)
                                .fillMaxWidth()
                                .clickable {
                                    navController.navigate(BottomNavItem.Thumbnail.screen_route + "/${it.id.videoId}")
                                }, horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(text = it.snippet.title)
                            Spacer(Modifier.height(10.dp))
                            AsyncImage(
                                model = it.snippet.thumbnails.high.url,
                                contentDescription = null, contentScale = ContentScale.FillBounds
                            )
                        }
                    }
                })
            }
        }
    }
}

@Composable
fun SearchBar(queryChange: (String) -> Unit) {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = {
            text = it
            queryChange.invoke(it)
        },
        label = { Text("Search") },
        leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
        modifier = Modifier.fillMaxWidth()
    )
}