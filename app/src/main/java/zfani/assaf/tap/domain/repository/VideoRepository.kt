package zfani.assaf.tap.domain.repository

import zfani.assaf.tap.data.remote.dto.VideosResponse

interface VideoRepository {

    suspend fun searchVideos(query: String = ""): VideosResponse
}