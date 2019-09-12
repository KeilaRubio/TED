package com.example.ted

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.ted.adapter.FavoritosAdapter
import com.example.ted.adapter.NegociosAdapter
import com.example.ted.interfaces.onNegocioListener
import com.example.ted.modelo.Empresa
import com.example.ted.modelo.EmpresaServicio
import com.example.ted.modelo.Favoritos
import kotlinx.android.synthetic.main.activity_recycler_negocios.*
import kotlin.math.E

class RecyclerNegocios : AppCompatActivity(),onNegocioListener{

    lateinit var negociosRecyclerView : RecyclerView
    lateinit var favoritosRecycler:RecyclerView
    lateinit var destacadossRecycler:RecyclerView
    lateinit var lyFiltro:LinearLayout
//    lateinit var cupones:LinearLayout
//    lateinit var imgEmpresaServicios:CircleImageView
//    lateinit var nombreEmpresa:TextView
        val fAdapter : FavoritosAdapter = FavoritosAdapter()
    val dAdapter:FavoritosAdapter= FavoritosAdapter()
    val mAdapter : NegociosAdapter = NegociosAdapter()
    var empresaServicios:MutableList<EmpresaServicio> = ArrayList()
    var empresa:MutableList<Empresa> = ArrayList()
    var empresa2:MutableList<Empresa> = ArrayList()
    var empresa3:MutableList<Empresa> = ArrayList()
    var favorito:MutableList<Favoritos> = ArrayList()
    var destacado:MutableList<Favoritos> = ArrayList()
//    var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_negocios)
        lyFiltro=findViewById(R.id.lyFiltro)
        recyclerView()
        setSupportActionBar(toolbar_negocios)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        lyFiltro.setOnClickListener {
            menuMasOpciones()
        }
    }

    fun recyclerView(){
        negociosRecyclerView = findViewById(R.id.recycler_negocios) as RecyclerView
        negociosRecyclerView.setHasFixedSize(true)
        negociosRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter.RecyclerAdapter(obtenerNegocios(), this, this)
        negociosRecyclerView.adapter = mAdapter

        favoritosRecycler = findViewById(R.id.recycler_favoritos) as RecyclerView
        favoritosRecycler.setHasFixedSize(true)
        favoritosRecycler.layoutManager = LinearLayoutManager(this,OrientationHelper.HORIZONTAL,false)
        fAdapter.RecyclerAdapter(favorito, this)
//        mAdapter.RecyclerAdapter(empresaServicios.favorito,context)
        favoritosRecycler.adapter = fAdapter

        destacadossRecycler = findViewById(R.id.recycler_destacados) as RecyclerView
        destacadossRecycler.setHasFixedSize(true)
        destacadossRecycler.layoutManager = LinearLayoutManager(this,OrientationHelper.HORIZONTAL,false)
        dAdapter.RecyclerAdapter(destacado, this)
        destacadossRecycler.adapter = dAdapter

    }



    fun obtenerNegocios(): MutableList<EmpresaServicio>{

        empresaServicios.add(
            EmpresaServicio(
                "Pet Club",
                "http://cupones.geaecuador.ec/storage/coupon/2034/medialibraryhdW5mG",
                "7.5",
                "Fragmento de un escrito con unidad temática, que queda diferenciado del resto de fragmentos por un punto y aparte y " +
                        "generalmente también por llevar letra mayúscula inicial y un espacio en blanco en el margen izquierdo de alineación del " +
                        "texto principal de la primera línea." +
                        "Fragmento de un escrito con unidad temática, que queda diferenciado del resto de fragmentos por un punto y aparte y" +
                        "generalmente también por llevar letra mayúscula inicial y un espacio en blanco en el margen izquierdo de alineación del" +
                        "texto principal de la primera línea." +
                        "Fragmento de un escrito con unidad temática, que queda diferenciado del resto de fragmentos por un punto y aparte y" +
                        "generalmente también por llevar letra mayúscula inicial y un espacio en blanco en el margen izquierdo de alineación del" +
                        "texto principal de la primera línea.",
                empresa,
                favorito
            )
        )
                empresa.add(
                    Empresa(
                        "http://cupones.geaecuador.ec/storage/coupon/2033/medialibraryfdeDbX",
                        "Hospedaje en habitación presidencial  precio normal $30 precio cespecial $24,99 gratis pasaje ZEN con aromas y aceites relajantes",
                        "Subtitulo1"
                    )

                )
                empresa.add(
                    Empresa(
                        "http://cupones.geaecuador.ec/storage/coupon/2037/medialibraryhCKMV7",
                        "Hospedaje en habitación standard  precio normal $20 Precio especial $14.99 gratis Masaje ZEN con aromas y aceites relajantes",
                        "Subtitulo1"
                    )
                )
                empresa.add(
                    Empresa(
                        "http://cupones.geaecuador.ec/storage/coupon/2041/medialibrarypH33Ut",
                        "Parque Acuático, socios Pet Lover primera visita gratis",
                        "Subtitulo1"
                    )

                )
                favorito.add(
                    Favoritos(
                        "http://cupones.geaecuador.ec/storage/coupon/2041/medialibrarypH33Ut",
                        "Parque Acuático, socios Pet Lover primera visita gratis",
                        "Subtitulo1"
                    )
                )
                favorito.add(
                    Favoritos(
                        "http://cupones.geaecuador.ec/storage/coupon/1966/medialibraryFP1Wl2",
                        "Sesión Estándar precio normal $135, precio especial clientes Pet Lover $79.99",
                        "Subtitulo2"
                    )
                )
                favorito.add(
                    Favoritos(
                        "http://cupones.geaecuador.ec/storage/coupon/1895/medialibrary6j9wsO",
                        "20% de descuento en Kennels (bolsos y transportadores parar mascotas",
                        "Subtitulo2"
                    )
                )
                destacado.add(
                    Favoritos(
                        "http://cupones.geaecuador.ec/storage/coupon/1887/medialibrarylfPxWC",
                        "15% de descuento en alimentos balanceados marca Mascota",
                        "Subtitulo1"
                    )
                )
                destacado.add(
                    Favoritos(
                        "http://cupones.geaecuador.ec/storage/coupon/1970/medialibraryjWvdcj",
                        "Sesión Básica precio normal $95, precio especial clientes Pet Lover $59.99",
                        "Subtitulo2"
                    )
                )
                destacado.add(
                    Favoritos(
                        "http://cupones.geaecuador.ec/storage/coupon/2037/medialibraryhCKMV7",
                        "15% de descuento en todos los artículos pet shop",
                        "Subtitulo2"
                    )
                )




        empresaServicios.add(
            EmpresaServicio(
                "Nuo Foto Mascotas",
                "http://cupones.geaecuador.ec/storage/coupon/1963/medialibraryvP3vKH",
                "4.2",
                "Fragmento de un escrito con unidad temática, que queda diferenciado del resto de fragmentos por un punto y aparte y" +
                        "                        generalmente también por llevar letra mayúscula inicial y un espacio en blanco en el margen izquierdo de alineación del" +
                        "                        texto principal de la primera línea.",
                empresa2
            )
        )
                empresa2.add(
                    Empresa(
                        "http://cupones.geaecuador.ec/storage/coupon/1970/medialibraryjWvdcj",
                        "Sesión Básica precio normal $95, precio especial clientes Pet Lover $59.99",
                        "Subtitulo2"
                    )
                )

                empresa2.add(
                    Empresa(
                        "http://cupones.geaecuador.ec/storage/coupon/1966/medialibraryFP1Wl2",
                        "Sesión Estándar precio normal $135, precio especial clientes Pet Lover $79.99",
                        "Subtitulo2"
                    )
                )
                empresa2.add(
                    Empresa(
                        "http://cupones.geaecuador.ec/storage/coupon/1962/medialibraryLri4x6",
                        "Sesión Mini precio normal $65, precio especial clientes Pet Lover $39.99",
                        "Subtitulo2"
                    )
                )



        empresaServicios.add(
            EmpresaServicio(
                "Gallito",
                "http://cupones.geaecuador.ec/storage/coupon/1884/medialibrarylgoYLH",
                "7.2",
                "Fragmento de un escrito con unidad temática, que queda diferenciado del resto de fragmentos por un punto y aparte y " +
                        "generalmente también por llevar letra mayúscula inicial y un espacio en blanco en el margen izquierdo de alineación del " +
                        "texto principal de la primera línea.",
                empresa3
            )
        )
        empresa3.add(
            Empresa(
                "http://cupones.geaecuador.ec/storage/coupon/1883/medialibraryt9gI5k",
                "Consulta veterinaria, precio normal $15, precio especial $5",
                "Subtitulo2"
            )
        )

        empresa3.add(
            Empresa(
                "http://cupones.geaecuador.ec/storage/coupon/1887/medialibrarylfPxWC",
                "15% de descuento en alimentos balanceados marca Mascota",
                "Subtitulo2"
            )
        )
        empresa3.add(
            Empresa(
                "http://cupones.geaecuador.ec/storage/coupon/1891/medialibraryQ3f5Rs",
                "22% de descuento en alimentos balanceados marca Royal Canin",
                "Subtitulo2"
            )
        )
        empresa3.add(
            Empresa(
                "http://cupones.geaecuador.ec/storage/coupon/1895/medialibrary6j9wsO",
                "20% de descuento en Kennels (bolsos y transportadores parar mascotas)",
                "Subtitulo2"
            )
        )
//
        return empresaServicios
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
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
////                cupones.visibility=View.VISIBLE
//
////                Toast.makeText (applicationContext,  "Listo" , Toast.LENGTH_LONG) .show ()
//                return true
//            }
//
//        }
//        return super.onOptionsItemSelected(item)
//    }

    fun menuMasOpciones() {
        val f = supportFragmentManager.findFragmentByTag("fragmento") as FiltroFragment?

        if (f != null) {
            supportFragmentManager.popBackStack()//ocultar
        } else {
            supportFragmentManager.beginTransaction()//mostrar
                .setCustomAnimations(R.animator.slide_up, R.animator.slide_down, R.animator.slide_down, R.animator.slide_up)
                .add(
                    R.id.flFiltroCupones,
                    Fragment.instantiate(this, FiltroFragment::class.java.name),
                    "fragmento"
                ).addToBackStack(null).commit()

        }
    }
//
    fun masOpcionesNegocio(negocio : EmpresaServicio) {
        val f = supportFragmentManager.findFragmentByTag("fragmento") as MenuLocalesFragment?

        if (f != null) {
            supportFragmentManager.popBackStack()//ocultar
        } else {
            val args = Bundle() //envio de parámetros al MenuLocalesFragment
            args.putString( "nombreLocal" ,negocio.negocios)
            args.putString( "descripcionLocal" ,negocio.descripcion)
            args.putString( "imagenLocal" ,negocio.img_negocios)

            supportFragmentManager.beginTransaction()//mostrar
                .setCustomAnimations(R.animator.slide_up_mas_opciones, R.animator.slide_down_mas_opciones, R.animator.slide_up_mas_opciones, R.animator.slide_down_mas_opciones)
                .add(
                    R.id.flDetalleCupones,
                    Fragment.instantiate(this, MenuLocalesFragment::class.java.name, args),
                    "fragmento"
                ).addToBackStack(null).commit()

        }
    }

    override fun masOpciones(negocio:EmpresaServicio) {
//        Toast.makeText(this,"Hola",Toast.LENGTH_SHORT ).show()
//        Toast.makeText(this, negocio.negocios ,Toast.LENGTH_SHORT ).show()
        masOpcionesNegocio(negocio)
//        showBottomSheetDialogFragment(negocio)
    }

    private fun showBottomSheetDialogFragment(negocio : EmpresaServicio) {
        val bottomSheetFragment = Example()
        val args = Bundle() //envio de parámetros al MenuLocalesFragment
        args.putString( "nombreLocal" ,negocio.negocios)
        args.putString( "descripcionLocal" ,negocio.descripcion)
        args.putString( "imagenLocal" ,negocio.img_negocios)
        bottomSheetFragment.arguments = args
        bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
    }

}
