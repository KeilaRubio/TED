package com.example.ted

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ted.adapter.CuponesAdapter
import com.example.ted.modelo.Cupones
import kotlinx.android.synthetic.main.activity_recycler_cupones.*
import kotlin.math.log


class Recycler_cupones : AppCompatActivity() {
    lateinit var cuponesRecyclerView: RecyclerView
    val cuponesAdapter: CuponesAdapter = CuponesAdapter()
    lateinit var lyCuponesFiltro: LinearLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_cupones)
        lyCuponesFiltro=findViewById(R.id.lyCuponesFiltro)

        setUpRecyclerView()
        setSupportActionBar(toolbar_cupones)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        lyCuponesFiltro.setOnClickListener {
            menuMasOpciones()
        }

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun setUpRecyclerView() {
        cuponesRecyclerView = findViewById(R.id.rv_cupones) as RecyclerView
        cuponesRecyclerView.setHasFixedSize(true)
        cuponesRecyclerView.layoutManager = LinearLayoutManager(this)
        cuponesAdapter.RecyclerAdapter(obtenerCupones(), this)
        cuponesRecyclerView.adapter = cuponesAdapter
    }

    fun obtenerCupones(): MutableList<Cupones> {
        var cupon:MutableList<Cupones> = ArrayList()
        cupon.add(
            Cupones(
                "https://s-ec.bstatic.com/images/hotel/max1024x768/159/159731698.jpg",
                "https://www.nowplayingaustin.com/wp-content/uploads/sites/www.nowplayingaustin.com/images/2018/06/16114515_1833201600283838_6741605974118969609_n.jpg",
                "Parque Acuático, socios Pet Lover primera visita gratis"
            )
        )
        cupon.add(
            Cupones(
                "https://santecentromedico.files.wordpress.com/2014/01/densitometria.jpg",
                "https://lapiazzaecuador.com/wp-content/uploads/2018/06/veris-express-Piazza-villa-club-300x300.jpg",
                "15% de descuento en alimentos balanceados marca Mascota"
            )
        )
        cupon.add(
            Cupones(
                "https://www.dream-alcala.com/wp-content/uploads/2018/12/mcdonalds_hamburguesas_menu.jpg",
                "https://i1.wp.com/www.eatthis.com/wp-content/uploads/2019/02/mcdonalds-logo.jpg?fit=500%2C366&ssl=1",
                "20% de descuento en Kennels (bolsos y transportadores parar mascotas"
            )
        )

        return cupon
    }



//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        super.onCreateOptionsMenu(menu)
//
//        menuInflater.inflate(R.menu.menu_cupones, menu)
//
////        val submenu = menu!!.addSubMenu(0,Menu.NONE,1,"NUEVO")
////        submenu.add("elemento1")
//        return true
//    }
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.action_setting -> {
////                val intent = Intent(this, DetalleNoticiaActivity::class.java)
////                startActivity(intent)
////                menuFiltro()
//
//
//                menuMasOpciones()
////                Toast.makeText (applicationContext,  "Listo" , Toast.LENGTH_LONG) .show ()
//                return true
//            }
//
//        }
//        return super.onOptionsItemSelected(item)
//    }

//    private fun llamar(){
//        val menu : MenuDeslizante
//        menu =  MenuDeslizante()
//        menu.menuMasOpciones()
//
//
//    }

    fun menuMasOpciones() {
        val f = supportFragmentManager.findFragmentByTag("fragmento") as FiltroFragment?
        if (f != null) {
            supportFragmentManager.popBackStack()//ocultar
        } else {
            supportFragmentManager.beginTransaction()//mostrar
                .setCustomAnimations(R.animator.slide_up, R.animator.slide_down, R.animator.slide_up, R.animator.slide_down)
                .add(
                    R.id.flFiltro,
                    Fragment.instantiate(this, FiltroFragment::class.java.name),
                    "fragmento"
                ).addToBackStack(null).commit()
        }
    }




}