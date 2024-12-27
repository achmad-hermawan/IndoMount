package com.hermawan.indomount

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hermawan.indomount.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding // Deklarasi binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater) // Inflate layout menggunakan ViewBinding
        setContentView(binding.root)

        // Menerima data dari Intent
        val mountain: Mountain? = intent.getParcelableExtra("MOUNTAIN")


        // ini adalah bagian dari view
        // Menampilkan data pada halaman detail
        mountain?.let {
            binding.imageViewDetail.setImageResource(it.photo)
            binding.textViewTitleDetail.text = it.name

            // Menampilkan informasi gunung
            binding.textViewGeography.text = "Letak Geografi: ${it.geography}"
            binding.textViewPeakHeight.text = "Ketinggian Puncak: ${it.peakHeight}"
            binding.textViewMountainType.text = "Jenis Gunung: ${it.mountainType}"
            binding.textViewLowestTemperature.text = "Suhu Terdingin: ${it.lowestTemperature}"
            binding.textViewClimbingDuration.text = "Durasi Pendakian: ${it.climbingDuration}"
            binding.textViewMitos.text = "Mitos: ${it.myth}"
            binding.textViewDescription.text = "Deskripsi: ${it.description}"
        }
        // Hide Action Bar
        supportActionBar?.hide()
    }
}
