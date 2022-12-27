package com.example.tugas9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.tugas9.koneksi.apiservis
import kotlinx.android.synthetic.main.activity_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val i = intent
        val id = i.getStringExtra("movie_id")
        getDetail(id)
    }

    private fun getDetail(id: String?) {
        apiservis.endpoint.getDetail(id!!).enqueue(object: Callback<ResponseDetail>{
            override fun onResponse(
                call: Call<ResponseDetail>,
                response: Response<ResponseDetail>
            ) {
                if (response.isSuccessful){
                    val detail: ResponseDetail? = response.body()
                    onResultDetail(detail)
                }else{
                    Toast.makeText(this@Detail, "gagal", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseDetail>, t: Throwable) {
                Toast.makeText(this@Detail, "$t", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun onResultDetail(detail: ResponseDetail?) {
        Glide.with(this).load("https://image.tmdb.org/t/p/w500/${detail!!.backdrop_path}")
            .into(iv_detail)
        tv_judul.text = detail.title
        tv_deskripsi.text = detail.overview
        tv_waktu.text = detail.release_date
    }
}