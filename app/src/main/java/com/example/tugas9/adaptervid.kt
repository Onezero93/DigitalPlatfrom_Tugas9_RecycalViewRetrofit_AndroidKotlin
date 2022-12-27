package com.example.tugas9

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class adaptervid(private  val listvid:ArrayList<ResultsItem>): RecyclerView.Adapter<adaptervid.ViewHolder>() {
    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        val imag1 : ImageView = itemView.findViewById(R.id.poster1)
        val judul: TextView = itemView.findViewById(R.id.tv_judul1)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item1_vidio,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listvid[position]
        holder.judul.text = data.title
        Glide.with(holder.itemView)
            .load("https://www.themoviedb.org/t/p/w220_and_h330_face${data.posterPath}")
            .apply(RequestOptions.overrideOf(150,150)).into(holder.imag1)
    }

    override fun getItemCount () =listvid.size
    fun setData(data: List<ResultsItem>){
        listvid.clear()
        listvid.addAll(data)
        notifyDataSetChanged()
    }
}