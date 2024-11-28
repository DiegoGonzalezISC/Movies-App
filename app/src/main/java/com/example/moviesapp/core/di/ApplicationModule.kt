package com.example.moviesapp.core.di

import com.example.moviesapp.core.network.RetrofitClient.getRetrofit
import com.example.moviesapp.movies.data.repository.MoviesService
import com.example.moviesapp.movies.data.repository.MoviesRepositoryImpl
import com.example.moviesapp.movies.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return getRetrofit()
    }

    @Provides
    @Singleton
    fun provideMoviesService(retrofit: Retrofit): MoviesService {
        return retrofit.create(MoviesService::class.java)
    }

    @Provides
    @Singleton
    fun provideMoviesRepository(api: MoviesService): MoviesRepository {
        return MoviesRepositoryImpl(api)
    }
}