package com.awesome.Student_Attendence.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Admin_model_class::class, Mentor_model_class::class], version = 1)
abstract class Room_Database : RoomDatabase() {

    abstract fun adminDao(): Admindao?
    abstract fun mentorDAO(): Mentordao?

    companion object {
        private var INSTANCE: Room_Database? = null
        fun getDatabase(context: Context): Room_Database? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    Room_Database::class.java, "Room_Database"
                )
                    .build()
            }
            return INSTANCE
        }
    }
}
