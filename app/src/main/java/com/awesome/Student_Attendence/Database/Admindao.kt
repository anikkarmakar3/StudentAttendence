package com.awesome.Student_Attendence.Database

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface Admindao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addAdmin(admin_obj: Admin_model_class)

    @Update
    suspend fun updateAdmin(admin_obj: Admin_model_class)

    @Delete
    suspend fun deleteAdmin(admin_obj: Admin_model_class)

    @Query("SELECT * FROM Admin_Table ORDER BY admin_id ASC")
    fun getAdmin(): Flow<List<Admin_model_class>>
}