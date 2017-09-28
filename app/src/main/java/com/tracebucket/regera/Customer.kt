package com.tracebucket.regera

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by nithinpb on 9/28/17.
 */
@Entity(tableName = "customer")
class Customer() {
    @PrimaryKey(autoGenerate = true) var id: Int = 0

    @ColumnInfo(name = "name")
    lateinit var name: String
    @ColumnInfo(name = "phone_number")
    lateinit var phoneNumber: String

    constructor(name: String, phoneNumber: String): this() {
        this.name = name
        this.phoneNumber = phoneNumber
    }
}