package com.example.ted

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import android.app.Activity
import android.view.View.*
import android.widget.LinearLayout
import android.widget.SearchView
import android.content.Context.INPUT_METHOD_SERVICE
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService




class FiltroFragment : Fragment() {
    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null
    lateinit var cerrar:ImageView
    lateinit var restablecer:TextView
    lateinit var listo:TextView
    lateinit var lyCerrar:LinearLayout
    lateinit var filtro:LinearLayout
//    lateinit var buscador:SearchView



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view:View = inflater.inflate(R.layout.activity_filtro, container, false)

        viewPager = view.findViewById(R.id.viewPagerFiltro)
        cerrar =view.findViewById(R.id.iv_cerrar)
        restablecer = view.findViewById(R.id.tv_restablecer)
        listo = view.findViewById(R.id.listo)
        lyCerrar = view.findViewById(R.id.lyCerrar)
        filtro = view.findViewById(R.id.filtro)
//        buscador = view.findViewById(R.id.buscador2)
        setupViewPager(viewPager!!)
        tabLayout = view.findViewById(R.id.tabs)
        tabLayout!!.setupWithViewPager(viewPager)


//
//        buscador.setOnCloseListener {
//            buscador.clearFocus()

//        }
//        buscador.isIconified = false
//
//        buscador.setOnClickListener(OnClickListener {
//                buscador.isIconified = false
//
//        })


        filtro.setOnClickListener {
            cerrarFragment()
        }

        lyCerrar.setOnClickListener {
            cerrarFragment()
        }
        restablecer.setOnClickListener {
            cerrarFragment()
        }
        listo.setOnClickListener {
            enviar()
        }

        return view
    }



    fun enviar(){
//        val intent = Intent(this, Recycler_cupones::class.java)
        val intent = Intent(activity, Recycler_cupones::class.java)
        startActivity(intent)
    }

    fun cerrarFragment (){
        activity!!.supportFragmentManager.popBackStack()
//            .beginTransaction().setCustomAnimations(R.animator.slide_up, R.animator.slide_down, R.animator.slide_up, R.animator.slide_down)
    }

    fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(PrimerFragment(), "Categorías")
        adapter.addFragment(SegundoFrament(), "Ubicación")
        adapter.addFragment(TercerFragment(), "Otros")
        viewPager.adapter = adapter
    }
//    private fun llamar(){
////        val menu : MenuDeslizante
////        menu =  MenuDeslizante()
////        menu.menuMasOpciones()
//        val fragment = Fragmentt()
//        fragment.tabs()



}


