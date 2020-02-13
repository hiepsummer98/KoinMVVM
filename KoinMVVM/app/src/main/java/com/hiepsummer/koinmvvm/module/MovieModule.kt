package com.hiepsummer.koinmvvm.module

import com.hiepsummer.koinmvvm.viewmodel.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieModule = module {

    viewModel {
        MovieViewModel(get())
    }
}