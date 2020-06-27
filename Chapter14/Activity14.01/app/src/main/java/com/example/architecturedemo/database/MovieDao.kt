package com.example.architecturedemo.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.architecturedemo.database.DBMovie

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie")
    suspend fun getAll(): List<DBMovie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovies(movies: List<DBMovie>)
}