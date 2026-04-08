package br.com.annypereira.apptask.features.task.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.annypereira.apptask.features.task.data.local.entity.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert
    suspend fun insert(task: Task)

    @Delete
    suspend fun delete(task: Task)

    @Query("SELECT * FROM Tasks ORDER BY id DESC")
    fun getAll(): Flow<List<Task>>

    @Query("DELETE FROM Tasks")
    suspend fun clearAll()
}