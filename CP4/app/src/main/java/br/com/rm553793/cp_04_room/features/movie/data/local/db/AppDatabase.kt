package br.com.rm553793.cp_04_room.features.movie.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.rm553793.cp_04_room.features.movie.data.local.dao.MovieDao
import br.com.rm553793.cp_04_room.features.movie.data.local.entity.Movie

@Database(entities = [Movie::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}