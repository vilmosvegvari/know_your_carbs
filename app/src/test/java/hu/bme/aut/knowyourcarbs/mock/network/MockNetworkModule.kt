package hu.bme.aut.knowyourcarbs.mock.network

import dagger.Module
import dagger.Provides
import hu.bme.aut.knowyourcarbs.network.api.NutritionDetailsApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
class MockNetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    @Singleton
    fun provideMockApi(): NutritionDetailsApi = MockApi()
}