package com.hiepsummer.koinmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hiepsummer.koinmvvm.R
import com.hiepsummer.koinmvvm.backend.ServiceUtil
import com.hiepsummer.koinmvvm.data.MovieCollection
import com.hiepsummer.koinmvvm.util.Constants
import com.hiepsummer.koinmvvm.util.Event
import kotlinx.coroutines.launch

class MovieViewModel constructor(private val serviceUtil: ServiceUtil) : ViewModel() {

    private val _uiState = MutableLiveData<MovieDataState>()
    val uiState: LiveData<MovieDataState> get() = _uiState

    init {
        retrieveMovies()
    }

    private fun retrieveMovies() {
        viewModelScope.launch {
            runCatching {
                emitUiState(showProgress = true)
                serviceUtil.popularMovies(apiKey = Constants.API_Key)
            }.onSuccess {
                emitUiState(movies = Event(it.movies))
            }.onFailure {
                it.printStackTrace()
                emitUiState(error = Event(R.string.internet_failure_error))
            }
        }
    }


    private fun emitUiState(
        showProgress: Boolean = false,
        movies: Event<List<MovieCollection.Movie>>? = null,
        error: Event<Int>? = null
    ) {
        val dataState = MovieDataState(showProgress, movies, error)
        _uiState.value = dataState
    }
}


data class MovieDataState(
    val showProgress: Boolean,
    val movies: Event<List<MovieCollection.Movie>>?,
    val error: Event<Int>?
)