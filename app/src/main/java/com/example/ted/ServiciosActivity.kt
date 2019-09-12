package com.example.ted

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.ted.adapter.ServiciosAdapter
import com.example.ted.modelo.Servicios
import kotlinx.android.synthetic.main.activity_servicios.*

class ServiciosActivity : AppCompatActivity() {
    lateinit var serviciosRecyclerView : RecyclerView
    val sAdapter : ServiciosAdapter = ServiciosAdapter()
    lateinit var servicios2RecyclerView: RecyclerView
    val s2Adapter:ServiciosAdapter = ServiciosAdapter()
    lateinit var servicios3RecyclerView: RecyclerView
    val s3Adapter:ServiciosAdapter = ServiciosAdapter()
    lateinit var servicios4RecyclerView: RecyclerView
    val s4Adapter:ServiciosAdapter = ServiciosAdapter()

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servicios)
        recyclerView()
        setSupportActionBar(toolbar_servicios)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        supportActionBar!!.title = "My title"
//        toolbar_servicios.title = "Hello APP"
//        toolbar_servicios.subtitle="thhfghfghfgh"
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    fun recyclerView(){
        serviciosRecyclerView = findViewById(R.id.listaServicios) as RecyclerView
        servicios2RecyclerView = findViewById(R.id.listaServicios2) as RecyclerView
        servicios3RecyclerView = findViewById(R.id.listaServicios3)as RecyclerView
        servicios4RecyclerView = findViewById(R.id.listaServicios4)as RecyclerView

        serviciosRecyclerView.setHasFixedSize(true)
        servicios2RecyclerView.setHasFixedSize(true)
        servicios3RecyclerView.setHasFixedSize(true)
        servicios4RecyclerView.setHasFixedSize(true)

        serviciosRecyclerView.layoutManager = LinearLayoutManager(this,OrientationHelper.HORIZONTAL,false)
        servicios2RecyclerView.layoutManager = LinearLayoutManager(this,OrientationHelper.HORIZONTAL,false)
        servicios3RecyclerView.layoutManager = LinearLayoutManager(this,OrientationHelper.HORIZONTAL,false)
        servicios4RecyclerView.layoutManager = LinearLayoutManager(this,OrientationHelper.HORIZONTAL,false)

        sAdapter.RecyclerAdapter(obtenerServicios(), this)
        s2Adapter.RecyclerAdapter(obtenerServicios2(), this)
        s3Adapter.RecyclerAdapter(obtenerServicios3(), this)
        s4Adapter.RecyclerAdapter(obtenerServicios4(),this)

        serviciosRecyclerView.adapter = sAdapter
        servicios2RecyclerView.adapter = s2Adapter
        servicios3RecyclerView.adapter = s3Adapter
        servicios4RecyclerView.adapter = s4Adapter

    }

    fun obtenerServicios(): MutableList<Servicios>{
        var servicios:MutableList<Servicios> = ArrayList()
        servicios.add(
            Servicios("servicio1",
                "http://www.elexpres.com/images_news/d866a9entrega-paquete.jpg")
        )
        servicios.add(
            Servicios("servicio2",
                "https://storage.googleapis.com/www-saludiario-com/wp-content/uploads/2016/01/Derechos-Trabajadores-de-La-Salud-e1475534855758.jpg")
        )
        servicios.add(
            Servicios("servicio3",
                "https://www.sat-alicante.es/wp-content/uploads/2015/06/Fotolia_49417332_Subscription_Monthly_M.jpg")
        )
        servicios.add(
            Servicios("servicio4",
                "https://i1.wp.com/www.kats.com.co/wp-content/uploads/2016/05/laboratorio7.png?fit=858%2C570&ssl=1")
        )
        servicios.add(
            Servicios("servicio5",
                "https://previews.123rf.com/images/andreypopov/andreypopov1508/andreypopov150800741/43693629-joven-reparador-reparaci%C3%B3n-nevera-delante-de-la-mujer-hermosa.jpg")
        )
        return servicios

    }

    fun obtenerServicios2():MutableList<Servicios>{
        var servicios2: MutableList<Servicios> = ArrayList()
        servicios2.add(
            Servicios("servicio1",
                "http://pcacompany.com.ec/wp-content/uploads/2016/09/servicios-varios.jpg")
        )
        servicios2.add(
            Servicios("servicio2",
                "https://previews.123rf.com/images/dolgachov/dolgachov1611/dolgachov161103250/65345448-servicio-de-coche-reparaci%C3%B3n-mantenimiento-y-concepto-de-la-gente-hombre-mec%C3%A1nico-de-autom%C3%B3viles-con-l%C3%A1mpara-d.jpg")
        )
        servicios2.add(
            Servicios("servicio3",
                "https://akademilider.com/wp-content/uploads/2019/03/O69AM30-600x400.jpg")
        )
        servicios2.add(
            Servicios("servicio4",
                "https://ep01.epimg.net/economia/imagenes/2017/02/14/actualidad/1487092303_329119_1487092469_noticia_normal.jpg")
        )
        servicios2.add(
            Servicios("servicio5",
                "https://ichef.bbci.co.uk/news/660/cpsprodpb/182FE/production/_95207099_gettyimages-479021752.jpg")
        )
        return servicios2

    }

    fun obtenerServicios3():MutableList<Servicios>{
        var servicios2: MutableList<Servicios> = ArrayList()
        servicios2.add(
            Servicios("servicio1",
                "http://www.clasicuyo.com.ar/Materiales/2017-06//02/00162224.jpg")
        )
        servicios2.add(
            Servicios("servicio2",
                "https://revistasumma.com/wp-content/uploads/2018/03/mujeres-2.jpg")
        )
        servicios2.add(
            Servicios("servicio3",
                "http://roka-multiservicios.com/sec_din/archivos/imgs/15248163443193.jpg")
        )
        servicios2.add(
            Servicios("servicio4",
                "https://st.depositphotos.com/1158045/2720/i/450/depositphotos_27203679-stock-photo-gardener-pruning-an-hedge.jpg")
        )
        servicios2.add(
            Servicios("servicio5",
                "https://static.wixstatic.com/media/a7eebc_23d4cb32598c4a9c852208281a4d7fbc~mv2.jpg/v1/fill/w_682,h_682,al_b,q_85/a7eebc_23d4cb32598c4a9c852208281a4d7fbc~mv2.webp")
        )
        return servicios2

    }

    fun obtenerServicios4():MutableList<Servicios>{
        var servicios2: MutableList<Servicios> = ArrayList()
        servicios2.add(
            Servicios("servicio1",
                "http://www.clasicuyo.com.ar/Materiales/2017-06//02/00162224.jpg")
        )
        servicios2.add(
            Servicios("servicio2",
                "https://revistasumma.com/wp-content/uploads/2018/03/mujeres-2.jpg")
        )
        servicios2.add(
            Servicios("servicio3",
                "http://roka-multiservicios.com/sec_din/archivos/imgs/15248163443193.jpg")
        )
        servicios2.add(
            Servicios("servicio4",
                "https://st.depositphotos.com/1158045/2720/i/450/depositphotos_27203679-stock-photo-gardener-pruning-an-hedge.jpg")
        )
        servicios2.add(
            Servicios("servicio5",
                "https://static.wixstatic.com/media/a7eebc_23d4cb32598c4a9c852208281a4d7fbc~mv2.jpg/v1/fill/w_682,h_682,al_b,q_85/a7eebc_23d4cb32598c4a9c852208281a4d7fbc~mv2.webp")
        )
        return servicios2

    }

}
