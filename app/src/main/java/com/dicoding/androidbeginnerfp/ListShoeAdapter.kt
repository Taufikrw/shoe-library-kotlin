package com.dicoding.androidbeginnerfp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListShoeAdapter(private val listShoe: ArrayList<Shoe>) : RecyclerView.Adapter<ListShoeAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDesc: TextView = itemView.findViewById(R.id.tv_item_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_shoe, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listShoe.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, desc, cat, price, photo, detail1, detail2) = listShoe[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDesc.text = desc
        holder.itemView.setOnClickListener {
            val intentToDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentToDetail.putExtra(DetailActivity.SHOE_DATA, listShoe[position])
            holder.itemView.context.startActivities(arrayOf(intentToDetail))
        }
    }
}