package zfani.assaf.tap.data.remote

import android.app.Application
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import zfani.assaf.tap.R
import zfani.assaf.tap.data.remote.dto.VideosResponse
import javax.inject.Inject

class VideoServiceImpl @Inject constructor(private val videoClient: HttpClient, appContext: Application) :
    VideoService {

    val apiKey = appContext.getString(R.string.youtube_api_key)

    override suspend fun searchVideos(query: String): VideosResponse {
        return videoClient.get {
            url("https://www.googleapis.com/youtube/v3/search")
            parameter("key", apiKey)
            parameter("type", "video")
            parameter("maxResults", "50")
            parameter("q", query)
            parameter("part", "snippet")
        }.body()
    }
}