package br.com.rm553793.cp_04_room.features.movie.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.rm553793.cp_04_room.features.movie.data.local.entity.Movie
import br.com.rm553793.cp_04_room.features.movie.data.local.repository.MovieRepository
import kotlinx.coroutines.launch

class MovieViewModel (
    private val repository: MovieRepository
) : ViewModel() {
    val movies = repository.movies
    fun addMovie(title: String, desc: String, watched: Boolean) {
        viewModelScope.launch {
            repository.insert(Movie(title = title, desc = desc, watched = watched))
        }
    }
    fun removeMovie(movie: Movie) {
        viewModelScope.launch {
            repository.delete(movie)
        }
    }
    fun clearAllMovies() {
        viewModelScope.launch {
            repository.clearAll()
        }
    }

}