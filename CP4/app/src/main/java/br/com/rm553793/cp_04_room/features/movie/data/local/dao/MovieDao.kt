package br.com.rm553793.cp_04_room.features.movie.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.rm553793.cp_04_room.features.movie.data.local.entity.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert
    suspend fun insert(movie: Movie)
    @Delete
    suspend fun delete(movie: Movie)
    @Query("SELECT * FROM Movies ORDER BY id DESC")
    fun getAll(): Flow<List<Movie>>
    @Query("DELETE FROM Movies")
    suspend fun clearAll()
}