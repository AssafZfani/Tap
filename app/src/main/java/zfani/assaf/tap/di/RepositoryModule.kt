package zfani.assaf.tap.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import zfani.assaf.tap.data.repository.VideoRepositoryImpl
import zfani.assaf.tap.domain.repository.VideoRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindVideoClientRepository(
        videoRepositoryImpl: VideoRepositoryImpl
    ): VideoRepository
}