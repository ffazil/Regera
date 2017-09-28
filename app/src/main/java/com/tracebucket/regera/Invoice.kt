package com.tracebucket.regera

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.Relation

/**
 * Created by nithinpb on 9/28/17.
 */
@Entity(tableName = "invoice")
data class Invoice(
        @ColumnInfo(name = "amount")
        var amount: String,
        @ColumnInfo(name = "merchant_name")
        var merchant: String,
        @ColumnInfo(name = "reference_id")
        var referenceId: String,
        @ColumnInfo(name = "invoice_date")
        var invoiceDate: String,
        @ColumnInfo(name = "status")
        var status: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

//    @ColumnInfo(name = "customer")
//    lateinit var customer: Customer
//
//    @Relation(parentColumn = "id", entityColumn = "lineItemId")
//    lateinit var lineItemItems: List<LineItem>