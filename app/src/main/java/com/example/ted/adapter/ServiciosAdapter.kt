package com.example.ted.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ted.R
import com.example.ted.modelo.Servicios
import com.squareup.picasso.Picasso

class ServiciosAdapter: RecyclerView.Adapter<ServiciosAdapter.ViewHolder>() {
    var servicio1:MutableList<Servicios> = ArrayList()
    lateinit var context: Context

    fun RecyclerAdapter (notificacion: MutableList<Servicios>, context: Context){
        this.servicio1 = notificacion
        this.context = context
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = servicio1.get(position)
        holder.bind(item, context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            layoutInflater.inflate(
                R.layout.servicios,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return servicio1.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tipo_servicio = view.findViewById(R.id.servicio1) as TextView
        val imagen_servicio = view.findViewById(R.id.image_tipo_servicios) as ImageView

        fun bind(servicios: Servicios, context: Context){
            tipo_servicio.text = servicios.tipo_servicio
            imagen_servicio.loadUrl(servicios.image_tipo_servicio)
            Picasso.with(context).load(servicios.image_tipo_servicio).into(imagen_servicio)
//            itemView.setOnClickListener(View.OnClickListener {
//                val intent = Intent(context, DetalleNoticiaActivity::class.java)
//                intent.putExtra("titulo", expositor.titulo)
//                intent.putExtra("foto", expositor.foto)
//                intent.putExtra("hora", expositor.hora)
//                intent.putExtra("detalle", expositor.detalle)
//                ContextCompat.startActivity(context, intent, null)
//            })
        }

        fun ImageView.loadUrl(url: String) {
            Picasso.with(context).load(url).into(this)
        }
    }
}