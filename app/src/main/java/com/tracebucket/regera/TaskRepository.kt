package com.tracebucket.regera

import android.arch.persistence.room.*
import io.reactivex.Flowable

/**
 * Interface for retrieving Task info.
 */
@Dao
interface TaskRepository {
    @Query("SELECT * FROM task")
    fun findAll(): Flowable<List<Task>>

    @Query("SELECT * FROM task WHERE id = :arg0")
    fun findById(id: Int) : Flowable<Task>

    @Query("SELECT * FROM task WHERE completed = :arg0")
    fun getTasksByCompletion(complete: Boolean): Flowable<List<Task>>

    @Insert
    fun save(vararg tasks: Task)

    @Update
    fun update(task: Task)

    @Delete
    fun delete(task: Task)
}