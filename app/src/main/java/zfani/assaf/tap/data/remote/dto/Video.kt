package zfani.assaf.tap.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class Video(val snippet: Snippet, val id: Id)

@Serializable
data class Id(val videoId: String)

@Serializable
data class Snippet(val title: String, val thumbnails: Thumbnails)

@Serializable
data class Thumbnails(val high: High)

@Serializable
data class High(val url: String)


