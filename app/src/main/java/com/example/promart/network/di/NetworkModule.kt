package com.example.promart.network.di

import com.example.promart.network.ApiService
import com.example.promart.network.useCases.GetProductUseCase
import com.example.promart.repository.GetProductRepository
import com.example.promart.repository.GetProductRepositoryImpl
import com.example.promart.utils.Constants
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
    fun provideApiService(retrofit: Retrofit):ApiService{
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