package com.example.ted

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class Example: BottomSheetDialogFragment()  {
    lateinit var nombreNegocio: TextView
    lateinit var descripcionLocal: TextView
    lateinit var imgLocal: CircleImageView
    lateinit var menuLocales:RelativeLayout
    lateinit var rlGeneralLocales:RelativeLayout




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.activity_menu_locales, container, false)
        nombreNegocio = view.findViewById(R.id.tvNombreNegocio)
        descripcionLocal = view.findViewById(R.id.tvDescripcionLocal)
        imgLocal = view.findViewById(R.id.ivNegocio)
        menuLocales = view.findViewById(R.id.menuLocales)
//        rlGeneralLocales = view.findViewById(R.id.rlGeneralLocales)
//        rlGeneralLocales.setBackgroundResource(0x00000000)
        val arguments = arguments
//
        val imagenLocal = arguments!!.getString("imagenLocal")
//    nombreNegocio.text = (imagenLocal)
        Picasso.with(context).load(imagenLocal).into(imgLocal)
//
//
        val nombreLocal = arguments!!.getString("nombreLocal")
        nombreNegocio.text = (nombreLocal)
//
        val descripcion = arguments!!.getString("descripcionLocal")
        descripcionLocal.text = (descripcion)

        menuLocales.setOnClickListener {
            cerrarFragmentMenuLocales()
        }

//    Toast.makeText(context, "fragments$desired_string", Toast.LENGTH_SHORT ).show()

        return view

    }

    fun cerrarFragmentMenuLocales (){
        activity!!.supportFragmentManager.popBackStack()
//            .beginTransaction().setCustomAnimations(R.animator.slide_up, R.animator.slide_down, R.animator.slide_up, R.animator.slide_down)
    }
}