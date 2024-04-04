package com.example.promart.di

import com.example.promart.domain.useCases.GetProductUseCase
import com.example.promart.core.utils.Constants
import com.example.promart.data.remote.network.ApiService
import com.example.promart.data.repoository.GetProductRepositoryImpl
import com.example.promart.domain.repository.GetProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun providesGetProductRepository(apiService: ApiService) : GetProductRepository {
        return GetProductRepositoryImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideGetProductUseCase(getProductRepository: GetProductRepository): GetProductUseCase {
        return GetProductUseCase(getProductRepository)
    }
}