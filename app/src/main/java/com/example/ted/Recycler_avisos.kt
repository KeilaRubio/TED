package com.example.ted

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ted.adapter.NoticiaAdapter
import com.example.ted.adapter.NotificacionesAdapter
import com.example.ted.modelo.Notificaciones

class Recycler_avisos : AppCompatActivity() {
    lateinit var notificacionesRecyclerView : RecyclerView
    val mAdapter : NotificacionesAdapter = NotificacionesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_avisos)
        setUpRecyclerView()
    }
    fun setUpRecyclerView(){
        notificacionesRecyclerView = findViewById(R.id.notificacionesLista) as RecyclerView
        notificacionesRecyclerView.setHasFixedSize(true)
        notificacionesRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter.RecyclerAdapter(obtenerNotificaciones(), this)
        notificacionesRecyclerView.adapter = mAdapter
    }

    fun obtenerNotificaciones(): MutableList<Notificaciones>{
        var notificacion:MutableList<Notificaciones> = ArrayList()
        notificacion.add(Notificaciones("https://psicologiayautoayuda.com/wp-content/uploads/2016/05/personas-toxicas.jpg",
            "Daniel se hizo amigo de Mayra Orellana",
            "Ya tengo el nuevo Logo, si quieres nos reunimos mañana para dar....",
            "Hace 3 horas",true))
        notificacion.add(Notificaciones("https://www.diariodecuyo.com.ar/export/sites/diariodecuyo/img/2018/04/24/2672272w1033.jpg_1263951180.jpg",
            "Mario compartió tu publicación",
            "Ya tengo el nuevo Logo, si quieres nos reunimos mañana para dar....",
            "Ayer, a las 10 a.m",false))
        notificacion.add(Notificaciones("http://www.docnews.es/wp-content/uploads/2015/04/650_img_222_nafarroa-bai-irunea-propone-ampliar-el-perfil-de-los-destinatarios-de-las-viviendas-municipales.jpg",
            "Carlos cumple años el día de hoy",
            "Ya tengo el nuevo Logo, si quieres nos reunimos mañana para dar....",
            "sáb. a las 9:07 p.m", false))
        notificacion.add(Notificaciones("https://www.trecebits.com/wp-content/uploads/2019/02/Persona-1-445x445.jpg",
            "Juanito inica que le gusta tal página",
            "Ya tengo el nuevo Logo, si quieres nos reunimos mañana para dar....",
            "2 jul. a las 3:31 p.m.", true))
        notificacion.add(Notificaciones("",
            "Arianna compartió nueva foto",
            "Ya tengo el nuevo Logo, si quieres nos reunimos mañana para dar....",
            "2 jul. a las 3:31 p.m.", false))
        return notificacion

    }
}
