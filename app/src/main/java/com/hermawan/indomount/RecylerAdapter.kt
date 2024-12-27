package com.hermawan.indomount

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    internal var mountains = arrayListOf<Mountain>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Inisialisasi view yang digunakan di dalam mountain
        private val txtName: TextView = itemView.findViewById(R.id.tv_name)
        private val imgPhoto: ImageView = itemView.findViewById(R.id.tv_photo)

        // Fungsi untuk mengikat data ke view di dalam mountain
        fun bind(mountain: Mountain) {
            txtName.text = mountain.name
            imgPhoto.setImageResource(mountain.photo)

            // Program navigasi: Navigasi terjadi ketika item di klik
            // Ketika item diklik, kita akan memulai activity baru (DetailActivity)
            // dan mengirimkan data gunung menggunakan Parcelable.
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java).apply {
                    // Mengirim data gunung ke DetailActivity menggunakan Parcelable
                    putExtra("MOUNTAIN", mountain)
                }
                itemView.context.startActivity(intent)  // Menjalankan DetailActivity
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_mountain, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.MyViewHolder, position: Int) {
        holder.bind(mountains[position])
    }

    override fun getItemCount(): Int {
        return mountains.size
    }
}

