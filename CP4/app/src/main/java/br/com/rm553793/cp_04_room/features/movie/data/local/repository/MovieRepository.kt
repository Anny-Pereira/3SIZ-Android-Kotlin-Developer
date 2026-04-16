package br.com.rm553793.cp_04_room.features.movie.data.local.repository

import br.com.rm553793.cp_04_room.features.movie.data.local.dao.MovieDao
import br.com.rm553793.cp_04_room.features.movie.data.local.entity.Movie

class MovieRepository(
    private val dao: MovieDao
) {
    val movies = dao.getAll()
    suspend fun insert(movie: Movie) {
        dao.insert(movie)
    }
    suspend fun delete(movie: Movie) {
        dao.delete(movie)
    }
    suspend fun clearAll() {
        dao.clearAll()
    }

}