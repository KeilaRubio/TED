package com.example.ted.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.ted.R
import com.example.ted.activity.noticias.DetalleAvisosActivity
import com.example.ted.modelo.Notificaciones
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class NotificacionesAdapter: RecyclerView.Adapter<NotificacionesAdapter.ViewHolder>() {
    var notificacion:MutableList<Notificaciones> = ArrayList()
    lateinit var context: Context

    fun RecyclerAdapter (notificacion: MutableList<Notificaciones>, context: Context){
        this.notificacion = notificacion
        this.context = context
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = notificacion.get(position)
        holder.bind(item, context)

        holder.opciones.setOnClickListener {
        val popupMenu = PopupMenu(context, it)
            popupMenu.menuInflater.inflate(R.menu.menu_recycler,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener{ item ->
                when (item!!.itemId) {
                    R.id.eliminar_notificacion -> {
                        Toast.makeText(context, "La notificación ha sido eliminada", Toast.LENGTH_LONG).show()
                    }
                }
                true
            })
            popupMenu.show()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            layoutInflater.inflate(
                R.layout.cardview_avisos,
                parent,
                false
            )
        )
    }
    override fun getItemCount(): Int {
        return notificacion.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val opciones = view.findViewById(R.id.opciones) as Button
        val titulo = view.findViewById(R.id.tvTitulo_notificaciones) as TextView
        val fecha = view.findViewById(R.id.tvFecha) as TextView
        val descripcion = view.findViewById(R.id.tvDescripcion) as TextView
        val foto = view.findViewById(R.id.ivFotoNotificaciones) as CircleImageView
        val notificacioness = view.findViewById(R.id.notificaciones_leidas) as RelativeLayout



        fun bind(notificacion: Notificaciones, context: Context){
            titulo.text = notificacion.titulo
            fecha.text = notificacion.fecha
            descripcion.text = notificacion.descripcion

            if (notificacion.foto.isEmpty()){
              foto.setImageResource(R.drawable.icono) //coloca una imagen por defecto

            }else{
            foto.loadUrl(notificacion.foto)
            Picasso.with(context).load(notificacion.foto).into(foto)
            }
         //   itemView.setOnClickListener(View.OnClickListener { Toast.makeText(context, notificacion.titulo, Toast.LENGTH_SHORT).show() })
                if (notificacion.leido){
                    notificacioness.setBackgroundColor(Color.parseColor("#FFFFFF")) //designa un color si la notificación está leida
                }else{
                    notificacioness.setBackgroundColor(Color.parseColor("#ADE0FA")) //designa un color si la notificación No está leida
                }
            itemView.setOnClickListener(View.OnClickListener {

            //  notificacioness.setCardBackgroundColor(Color.parseColor(color"ADE0FA"))
                //notificacioness.setBackgroundColor(Color.parseColor("#F3F3F3"))
                val intent = Intent(context, DetalleAvisosActivity::class.java)
                intent.putExtra("titulo_aviso", notificacion.titulo)
                intent.putExtra("foto_Aviso", notificacion.foto)
                intent.putExtra("fecha", notificacion.fecha)
                intent.putExtra("descripcion", notificacion.descripcion)
                ContextCompat.startActivity(context, intent, null)
            })
        }


        fun CircleImageView.loadUrl(url: String) {
            Picasso.with(context).load(url).into(this)
        }

    }

}