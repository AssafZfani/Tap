package zfani.assaf.tap.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import zfani.assaf.tap.data.remote.dto.Video
import zfani.assaf.tap.domain.repository.VideoRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val videoRepository: Lazy<VideoRepository>
) : ViewModel() {

    val videos = mutableStateListOf<Video>()

    init {
        searchVideos()
    }

    fun searchVideos(query: String = "") {
        viewModelScope.launch {
            videos.clear()
            videos.addAll(videoRepository.get().searchVideos(query).items)
        }
    }
}