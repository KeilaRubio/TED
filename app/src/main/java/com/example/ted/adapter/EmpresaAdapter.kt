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
import com.example.ted.DetalleNegocio
import com.example.ted.R
import com.example.ted.contenido_cupones
import com.example.ted.modelo.Empresa
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class EmpresaAdapter: RecyclerView.Adapter<EmpresaAdapter.ViewHolder>() {
    var empresa:MutableList<Empresa> = ArrayList()
    lateinit var context: Context

    fun RecyclerAdapter (empresa: MutableList<Empresa>, context: Context){
        this.empresa = empresa
        this.context = context

    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = empresa.get(position)
        holder.bind(item, context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            layoutInflater.inflate(
                R.layout.cardview_empresa,
                parent,
                false
            )
        )
    }
    override fun getItemCount(): Int {
        return empresa.size
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titulo_negocios = view.findViewById(R.id.txt_titulo_negocio) as TextView
        val subtitulo_negocios = view.findViewById(R.id.txt_subtitulo_negocio) as TextView
        val image_card_negocios = view.findViewById(R.id.img_card_negocio) as ImageView

        fun bind(empresaServicios: Empresa, context: Context){
            titulo_negocios.text = empresaServicios.titulo_negocios
            subtitulo_negocios.text = empresaServicios.subtitulo_negocios
            image_card_negocios.loadUrl(empresaServicios.image_card_negocios)
            Picasso.with(context).load(empresaServicios.image_card_negocios).into(image_card_negocios)

            itemView.setOnClickListener(View.OnClickListener {
                val intent = Intent(context, DetalleNegocio::class.java)
                intent.putExtra("tituloNegocios", empresaServicios.titulo_negocios)
                intent.putExtra("imagenNegocio", empresaServicios.image_card_negocios)
                ContextCompat.startActivity(context, intent, null)
            })

        }

        fun ImageView.loadUrl(url: String) {
            Picasso.with(context).load(url).into(this)
        }

    }

}