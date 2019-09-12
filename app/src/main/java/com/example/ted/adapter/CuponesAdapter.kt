package com.example.ted.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.ted.R
import com.example.ted.activity.noticias.DetalleNoticiaActivity
import com.example.ted.contenido_cupones
import com.example.ted.modelo.Cupones
import com.squareup.picasso.Picasso

class CuponesAdapter: RecyclerView.Adapter<CuponesAdapter.ViewHolder>() {

    var cupones:MutableList<Cupones> = ArrayList()
    lateinit var context: Context

    fun RecyclerAdapter (cupones: MutableList<Cupones>, context: Context){
        this.cupones = cupones
        this.context = context

    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = cupones.get(position)
        holder.bind(item, context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            layoutInflater.inflate(
                R.layout.cardview_cupones,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return cupones.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgCupon = view.findViewById(R.id.imagen_cupon) as ImageView
        val imgLogo = view.findViewById(R.id.imagen_logo) as ImageView
        val tituloCupones = view.findViewById(R.id.tituloCupones)as TextView

        fun bind(cupones: Cupones, context: Context){
            tituloCupones.text=cupones.tituloCupones
            imgCupon.loadUrl(cupones.imagenCupon)
            Picasso.with(context).load(cupones.imagenCupon).into(imgCupon)
            imgLogo.loadUrl(cupones.imagenLogo)
            Picasso.with(context).load(cupones.imagenLogo).into(imgLogo)
            itemView.setOnClickListener(View.OnClickListener {
                val intent = Intent(context, contenido_cupones::class.java)
                intent.putExtra("tituloCupones", cupones.tituloCupones)
                intent.putExtra("imagenCupones", cupones.imagenCupon)
                ContextCompat.startActivity(context, intent, null)

            })

            }


        fun ImageView.loadUrl(url: String) {
            Picasso.with(context).load(url).into(this)
        }
    }

}