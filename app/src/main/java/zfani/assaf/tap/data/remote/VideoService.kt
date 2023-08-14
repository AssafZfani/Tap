package zfani.assaf.tap.data.remote

import zfani.assaf.tap.data.remote.dto.VideosResponse

interface VideoService {

    suspend fun searchVideos(query: String = ""): VideosResponse
}