package com.tracebucket.regera

import android.icu.util.CurrencyAmount

/**
 * Created by nithinpb on 9/28/17.
 */
class LineItem() {
    lateinit var product: String
    var quantity: Int = 0
    lateinit var amount: CurrencyAmount

    constructor(product: String, quantity: Int, amount: CurrencyAmount): this() {
        this.product = product
        this.quantity = quantity
        this.amount = amount
    }
}