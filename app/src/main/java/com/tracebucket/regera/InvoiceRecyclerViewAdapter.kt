package com.tracebucket.regera

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.invoice_item.view.*

/**
 * Created by nithinpb on 9/28/17.
 */
class InvoiceRecyclerViewAdapter(private var items: List<Invoice>, private var listener: onItemClickListener?)
    : RecyclerView.Adapter<InvoiceRecyclerViewAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.invoice_item, parent, false)
        return ViewHolder(v)
    }

    public interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(invoice: Invoice, listener: onItemClickListener?) {
            with(itemView) {
                amount.text = invoice.amount
                merchant.text = invoice.merchant
                invoice_reference.text = invoice.referenceId
                status.text = invoice.status
            }

            if(listener != null) {
                itemView.setOnClickListener({_ -> listener.onItemClick(layoutPosition)})
            }
        }
    }
}