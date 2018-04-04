package com.freeankit.paginationandlazyloading

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 04/04/2018 (MM/DD/YYYY)
 */
class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

    private val items: MutableList<String> = emptyList<String>() as MutableList<String>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_adapter_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun addData(list: MutableList<String>) {
        items.addAll(list)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bind(content: String) {
            (itemView as TextView).text = content
        }
    }
}