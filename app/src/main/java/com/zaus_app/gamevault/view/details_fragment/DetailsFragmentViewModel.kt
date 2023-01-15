package com.zaus_app.gamevault.view.details_fragment

import androidx.lifecycle.ViewModel
import com.zaus_app.gamevault.App
import com.zaus_app.gamevault.domain.Interactor
import javax.inject.Inject

class DetailsFragmentViewModel: ViewModel() {
    @Inject
    lateinit var interactor: Interactor

    init {
        App.instance.dagger.inject(this)
    }
}