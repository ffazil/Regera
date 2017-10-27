//package com.tracebucket.regera
//
//import android.arch.persistence.room.*
//import io.reactivex.Flowable
//
///**
// * Created by nithinpb on 9/28/17.
// */
//@Dao
//interface InvoiceRepository {
//    @Query("SELECT * FROM invoice")
//    fun findAll(): Flowable<List<Invoice>>
//
//    @Query("SELECT * FROM invoice WHERE id = :arg0")
//    fun findById(id: Int) : Flowable<Invoice>
//
//    @Query("SELECT * FROM invoice WHERE reference_id = :arg0")
//    fun getInvoiceByReferenceId(referenceId: String): Flowable<List<Invoice>>
//
//    @Insert
//    fun save(invoice: Invoice)
//
//    @Update
//    fun update(invoice: Invoice)
//
//    @Delete
//    fun delete(invoice: Invoice)
//}