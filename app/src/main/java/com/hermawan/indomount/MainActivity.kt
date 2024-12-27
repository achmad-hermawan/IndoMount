package com.hermawan.indomount

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ini menujukan API
        // Menambah ikon hamburger dengan gambar dari Google Drive
        val toolbar = supportActionBar
        val hamburgerIconUrl = "https://drive.google.com/uc?id=1ITZZwea1OC7P8OHxlrdboe1xZCtHdQMR"

        Glide.with(this)
            .load(hamburgerIconUrl)
            .into(object : CustomTarget<Drawable>() {
                override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                    toolbar?.setHomeAsUpIndicator(resource)
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                    // Tidak diperlukan
                }

                override fun onLoadFailed(errorDrawable: Drawable?) {
                    super.onLoadFailed(errorDrawable)
                    // Menangani jika gambar gagal dimuat
                }
            })

        toolbar?.setDisplayHomeAsUpEnabled(true) // Menampilkan tombol hamburger

        // Scrollable List
        val recyclerView: RecyclerView = findViewById(R.id.rv_mountains)  // RecyclerView untuk daftar gunung
        val recyclerAdapter = RecyclerAdapter()  // Adapter untuk RecyclerView
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)  // Mengatur layout vertikal

        // Menyiapkan data dari resource
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDesc = resources.getStringArray(R.array.data_desc)
        val dataPhotoIds = resources.obtainTypedArray(R.array.data_photo)
        val dataGeography = resources.getStringArray(R.array.data_letak)
        val dataPeakHeight = resources.getStringArray(R.array.data_ketinggian)
        val dataMountainType = resources.getStringArray(R.array.data_jenis)
        val dataLowestTemperature = resources.getStringArray(R.array.data_suhu)
        val dataClimbingDuration = resources.getStringArray(R.array.data_durasi)
        val dataMyth = resources.getStringArray(R.array.data_myth)
        val dataDescription = resources.getStringArray(R.array.data_desc)

        // Memasukkan data ke dalam data kelas Mountain
        val mountains = arrayListOf<Mountain>()
        for (position in dataName.indices) {
            val photoId = dataPhotoIds.getResourceId(position, -1)
            val mountain = Mountain(
                photoId,
                dataName[position],
                dataDesc[position],
                dataGeography[position],
                dataPeakHeight[position],
                dataMountainType[position],
                dataLowestTemperature[position],
                dataClimbingDuration[position],
                dataMyth[position],
                dataDescription[position]
            )
            mountains.add(mountain)
        }
        dataPhotoIds.recycle()

        recyclerAdapter.mountains = mountains

        // Set toolbar title
        toolbar?.title = "Indo Mount App"
    }

    // Menampilkan menu di toolbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_about, menu)
        return true
    }
}
