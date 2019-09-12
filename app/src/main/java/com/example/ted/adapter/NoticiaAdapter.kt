package com.example.ted.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ted.R
import com.example.ted.modelo.Noticia
import com.example.ted.activity.noticias.DetalleNoticiaActivity
import com.squareup.picasso.Picasso

class NoticiaAdapter: RecyclerView.Adapter<NoticiaAdapter.ViewHolder>() {
    var expositor:MutableList<Noticia> = ArrayList()
    lateinit var context: Context

    fun RecyclerAdapter (expositor: MutableList<Noticia>, context: Context){
        this.expositor = expositor
        this.context = context
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = expositor.get(position)
        holder.bind(item, context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            layoutInflater.inflate(
                R.layout.cardview_noticias,
                parent,
                false
            )
        )
    }
    override fun getItemCount(): Int {
        return expositor.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titulo = view.findViewById(R.id.tvexpositores) as TextView
        val hora = view.findViewById(R.id.tvhora) as TextView
//        val detalle = view.findViewById(R.id.tvDetalle) as TextView
        val foto = view.findViewById(R.id.ivExpositor) as ImageView

        fun bind(expositor: Noticia, context: Context){
            titulo.text = expositor.titulo
//            Glide
//                .with(context)
//                .load(expositor.foto)
//                .centerCrop()
//                .placeholder(R.drawable.ic_launcher_background)
//                .into(foto);

            foto.loadUrl(expositor.foto)
            hora.text = expositor.hora
//            detalle.text = expositor.detalle
            //foto.setImageURI(Uri.parse(expositor.foto))
            Picasso.with(context).load(expositor.foto).into(foto)
            //itemView.setOnClickListener(View.OnClickListener { Toast.makeText(context, expositor.titulo, Toast.LENGTH_SHORT).show() })
            itemView.setOnClickListener(View.OnClickListener {
                val intent = Intent(context, DetalleNoticiaActivity::class.java)
                intent.putExtra("titulo", expositor.titulo)
                intent.putExtra("foto", expositor.foto)
                intent.putExtra("hora", expositor.hora)
                intent.putExtra("detalle", expositor.detalle)
                startActivity(context,intent,null)
            })

        }


        fun ImageView.loadUrl(url: String) {
            Picasso.with(context).load(url).into(this)
        }

    }

}