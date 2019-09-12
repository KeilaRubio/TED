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
import com.example.ted.DetalleFavorito
import com.example.ted.DetalleNegocio
import com.example.ted.R
import com.example.ted.contenido_cupones
import com.example.ted.modelo.Cupones
import com.example.ted.modelo.Favoritos
import com.squareup.picasso.Picasso

class FavoritosAdapter: RecyclerView.Adapter<FavoritosAdapter.ViewHolder>() {

    var favoritos:MutableList<Favoritos> = ArrayList()
    lateinit var context: Context

    fun RecyclerAdapter (favoritos: MutableList<Favoritos>, context: Context){
        this.favoritos = favoritos
        this.context = context

    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = favoritos.get(position)
        holder.bind(item, context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            layoutInflater.inflate(
                R.layout.cardview_favoritos,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return favoritos.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgFavorito = view.findViewById(R.id.img_card_favorito) as ImageView
        val tituloFavorito=view.findViewById(R.id.txt_titulo_favorito)as TextView
        val subTituloFavorito=view.findViewById(R.id.txt_subtitulo_favorito)as TextView

        fun bind(favorito: Favoritos, context: Context){
            tituloFavorito.text = favorito.tituloFavorito
            subTituloFavorito.text = favorito.subtituloFavorito
            imgFavorito.loadUrl(favorito.imageFavorito)
            Picasso.with(context).load(favorito.imageFavorito).into(imgFavorito)

            itemView.setOnClickListener(View.OnClickListener {
                val intent = Intent(context, DetalleFavorito::class.java)
                intent.putExtra("tituloFavorito", favorito.tituloFavorito)
                intent.putExtra("imagenFavorito", favorito.imageFavorito)
                ContextCompat.startActivity(context, intent, null)

            })

        }


        fun ImageView.loadUrl(url: String) {
            Picasso.with(context).load(url).into(this)
        }
    }

}