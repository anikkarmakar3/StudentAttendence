package com.awesome.Student_Attendence.Database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface Mentordao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMentor(mentor_obj: Mentor_model_class)

    @Update
    suspend fun updateMentor(mentor_obj: Mentor_model_class)

    @Delete
    suspend fun deleteMentor(mentor_obj: Mentor_model_class)

    @Query("SELECT * FROM Admin_Table ORDER BY admin_id ASC")
    fun getNotes(): Flow<List<Mentor_model_class>>
}