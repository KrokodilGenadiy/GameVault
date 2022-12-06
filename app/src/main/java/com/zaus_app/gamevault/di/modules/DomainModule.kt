package com.zaus_app.gamevault.di.modules

import com.zaus_app.gamevault.data.RawgApi
import com.zaus_app.gamevault.domain.Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {
    @Singleton
    @Provides
    fun provideInteractor(rawgApi: RawgApi) = Interactor(rawgApi)
}