package com.zaus_app.gamevault.di

import com.zaus_app.gamevault.di.modules.DomainModule
import com.zaus_app.gamevault.di.modules.RemoteModule
import com.zaus_app.gamevault.view.details_fragment.DetailsFragmentViewModel
import com.zaus_app.gamevault.view.home_fragment.HomeFragmentViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RemoteModule::class,
        DomainModule::class
    ]
)

interface AppComponent {
    fun inject(homeFragmentViewModel: HomeFragmentViewModel)
    fun inject(detailsFragmentViewModel: DetailsFragmentViewModel)
}