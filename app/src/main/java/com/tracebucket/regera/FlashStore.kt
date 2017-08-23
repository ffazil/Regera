package com.tracebucket.regera

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

/**
 * Created by firoz on 23/08/17.
 */
@Database(entities = arrayOf(Task::class), version = 2)
abstract class FlashStore : RoomDatabase(){
    abstract fun taskRepository(): TaskRepository

    companion object {
        private var INSTANCE: FlashStore? = null
            private set

        fun getInMemoryDatabase(context: Context): FlashStore {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context,
                        FlashStore::class.java, "flash-store")
                        .build()
            }

            return INSTANCE!!
        }
    }
}