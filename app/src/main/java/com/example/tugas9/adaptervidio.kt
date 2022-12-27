package com.example.tugas9

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class adaptervidio(private  val listvidio:ArrayList<ResultsItem>):
RecyclerView.Adapter<adaptervidio.ViewHolder>(){
    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        val judul: TextView = itemView.findViewById(R.id.judul)
        val deskripsi: TextView = itemView.findViewById(R.id.deskripsi)
        val imag : ImageView = itemView.findViewById(R.id.poster)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_vidio,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listvidio[position]
        holder.judul.text = data.title
        holder.deskripsi.text = data.overview
        Glide.with(holder.itemView)
            .load("https://www.themoviedb.org/t/p/w220_and_h330_face${data.posterPath}")
            .apply(RequestOptions.overrideOf(150,150)).into(holder.imag)
        Toast.makeText(holder.itemView.context, "${data.id}", Toast.LENGTH_SHORT).show()
        //tombol detail
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context,Detail::class.java)
            intent.putExtra("movie_id", data.id.toString())
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = listvidio.size

    fun setData(data: List<ResultsItem>){
        listvidio.clear()
        listvidio.addAll(data)
        notifyDataSetChanged()
    }

}