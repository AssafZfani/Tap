package zfani.assaf.tap.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class VideosResponse(val items: List<Video>)
