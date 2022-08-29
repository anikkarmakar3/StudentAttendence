package com.awesome.Student_Attendence.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Admin_Table")
data class Admin_model_class(
    @PrimaryKey(autoGenerate = true)
    val admin_id: Int,
    @ColumnInfo(name = "Admin_Name")
    val admin_name: String,
    @ColumnInfo(name = "Admin_Email")
    val admin_email: String,
    @ColumnInfo(name="Amin_Phone")
    val admin_phone: Long,
    @ColumnInfo(name="Admin_Password")
    val admin_password:String
)
