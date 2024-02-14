package com.project.expirytracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val itemList:List<ItemModel>):RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val item = inflate.inflate(R.layout.card_item,parent,false)
        return ViewHolder(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.name_item.text = item.name
        holder.price.text = item.price.toString()
        val expDate = "${item.date} - ${item.month} - ${item.year}"
        holder.expDate.text = expDate
    }



    class ViewHolder(private val item: View):RecyclerView.ViewHolder(item) {
        val name_item = item.findViewById<TextView>(R.id.item_name)
        val price = item.findViewById<TextView>(R.id.price)
        val expDate = item.findViewById<TextView>(R.id.exp_date)
    }
}