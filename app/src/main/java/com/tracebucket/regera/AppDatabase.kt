package com.tracebucket.regera

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

/**
 * Created by firoz on 23/08/17.
 */
@Database(entities = arrayOf(Task::class), version = 3)
abstract class AppDatabase : RoomDatabase() {

    /* Repository Methods */
    abstract fun taskRepository(): TaskRepository

    companion object {
        val DB_NAME = "regera_db"
        var dbInstance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase? {
            if (dbInstance == null) {
                dbInstance = Room.databaseBuilder<AppDatabase>(context.applicationContext,
                        AppDatabase::class.java, DB_NAME)
                        .fallbackToDestructiveMigration()
                        .build()
            }
            return dbInstance
        }
    }
}