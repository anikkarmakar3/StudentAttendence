package com.awesome.Student_Attendence.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Mentor_Table")
data class Mentor_model_class(
    @PrimaryKey(autoGenerate = true)
    val mentor_id: Int,
    @ColumnInfo(name = "Mentor_Name")
    val mentor_name: String,
    @ColumnInfo(name = "Mentor_Email")
    val mentor_email: String,
    @ColumnInfo(name="Mentor_Phone")
    val mentor_phone: Long,
    @ColumnInfo(name="Mentor_Password")
    val mentor_password:String
)
