package com.example.ted.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.ted.DetalleNegocio
import com.example.ted.MenuLocalesFragment
import com.example.ted.R
import com.example.ted.interfaces.onNegocioListener
import com.example.ted.modelo.EmpresaServicio
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class NegociosAdapter: RecyclerView.Adapter<NegociosAdapter.ViewHolder>() {
    var negocios:MutableList<EmpresaServicio> = ArrayList()
    lateinit var context: Context
     lateinit var listener: onNegocioListener

    fun RecyclerAdapter (negocios: MutableList<EmpresaServicio>, context: Context, lis:onNegocioListener){
        this.negocios = negocios
        this.context = context
        this.listener = lis

    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = negocios.get(position)
        holder.bind(item, context)
        holder.ivMasOpciones.setOnClickListener {
            listener.masOpciones(negocios[position])
        }
        holder.image_negocios.setOnClickListener {
            listener.masOpciones(negocios[position])
        }
        holder.lyMasOpciones.setOnClickListener {
            listener.masOpciones(negocios[position])
        }


//        if(position==0){
//            textFavorito.visibility=View.VISIBLE
//
//        }else{
//            textFavorito.visibility=View.GONE
//        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            layoutInflater.inflate(
                R.layout.cardview_negocios,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return negocios.size
    }



    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txt_negocios = view.findViewById(R.id.txt_negocio) as TextView
        val image_negocios = view.findViewById(R.id.img_negocios) as CircleImageView
        val ivMasOpciones = view.findViewById(R.id.ivMasOpciones) as ImageView
        val txtPuntos = view.findViewById(R.id.puntos)as TextView
//        val tvFavoritos = view.findViewById(R.id.tvFavorito)as TextView
        val rvServicio = view.findViewById(R.id.rvServicio) as RecyclerView
        val lyMasOpciones = view.findViewById(R.id.lyMasOpciones) as LinearLayout
//        val rvFavoritos = view.findViewById(R.id.recycler_favoritos) as RecyclerView

        val mAdapter : EmpresaAdapter = EmpresaAdapter()
//        val fAdapter : FavoritosAdapter = FavoritosAdapter()

        fun bind(empresaServicios: EmpresaServicio, context: Context){
            txt_negocios.text = empresaServicios.negocios
            txtPuntos.text = empresaServicios.puntos
            image_negocios.loadUrl(empresaServicios.img_negocios)
            Picasso.with(context).load(empresaServicios.img_negocios).into(image_negocios)

            rvServicio.setHasFixedSize(true)
            rvServicio.layoutManager = LinearLayoutManager(context, OrientationHelper.HORIZONTAL,false)
            mAdapter.RecyclerAdapter(empresaServicios.empresa,context)
            rvServicio.adapter = mAdapter

//            ivMasOpciones.setOnClickListener {
//                val intent = Intent(context, MenuLocalesFragment::class.java)
//            intent.putExtra("nombreNegocio", empresaServicios.negocios)
//            ContextCompat.startActivity(context, intent, null)
//            }

        }

        fun CircleImageView.loadUrl(url: String) {
            Picasso.with(context).load(url).into(this)
        }


    }

}