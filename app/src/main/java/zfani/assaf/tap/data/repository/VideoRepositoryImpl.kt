package zfani.assaf.tap.data.repository

import zfani.assaf.tap.data.remote.VideoService
import zfani.assaf.tap.domain.repository.VideoRepository
import javax.inject.Inject

class VideoRepositoryImpl @Inject constructor(private val videoService: VideoService) : VideoRepository {

    override suspend fun searchVideos(query: String) = videoService.searchVideos(query)
}