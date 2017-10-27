package com.tracebucket.regera

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

/**
 * Something that has to be completed by the user.
 */
@Entity
class Task() {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
    var description: String = ""
    var completed: Boolean = false

    @Ignore
    constructor(description: String, completed: Boolean = false): this() {
        this.description = description
        this.completed = completed
    }
}