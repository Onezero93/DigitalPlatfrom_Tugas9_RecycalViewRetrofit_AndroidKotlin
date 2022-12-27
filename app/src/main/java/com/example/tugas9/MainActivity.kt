package com.example.tugas9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugas9.koneksi.apiservis
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {
    var vidioadapter = adaptervidio(arrayListOf())
    var vidadapter = adaptervid(arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        recikel.layoutManager = GridLayoutManager(this,2)
        recikel.layoutManager = LinearLayoutManager(this)
        recikel.adapter = vidioadapter
        recikel1.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recikel1.adapter = vidadapter
        getVidio()
    }
    private fun getVidio() {
        apiservis.endpoint.getvidio().enqueue(object : Callback<Response> {
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                if(response.isSuccessful){
                    val responseVidio: Response? = response.body()
                    onResulVidio(responseVidio!!)
                }
            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
            }

        })
    }

    private fun onResulVidio(responseVidio: Response) {
        val horizontal = responseVidio.results
        val vertikal = responseVidio.results
        vidioadapter.setData(vertikal as List<ResultsItem>)
        vidadapter.setData(horizontal as List<ResultsItem>)
    }
}