package com.zaus_app.gamevault.view.home_fargment

import android.util.Log
import androidx.lifecycle.ViewModel
import com.zaus_app.gamevault.App
import com.zaus_app.gamevault.domain.Interactor
import com.zaus_app.gamevault.utils.Converter
import javax.inject.Inject

class HomeFragmentViewModel: ViewModel() {
    @Inject
    lateinit var interactor: Interactor

    init {
        App.instance.dagger.inject(this)
    }
    suspend fun test() {
        val list = interactor.getGamesFromApi(1).body()?.results
        Log.i("555",
            Converter.convertApiListToDtoList(list).toString()
        )
    }
}