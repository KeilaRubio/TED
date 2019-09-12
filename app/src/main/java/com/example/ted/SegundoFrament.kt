package com.example.ted

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment

class SegundoFrament : Fragment() {
    lateinit var lyOpciones1:LinearLayout
    lateinit var lyOpciones2:LinearLayout
    lateinit var lyOpciones3:LinearLayout
    lateinit var visto1: ImageView
    lateinit var visto2:ImageView
    lateinit var visto3:ImageView


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_segundo_frament)
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
       val view:View= inflater!!.inflate(R.layout.activity_segundo_frament, container, false)
        lyOpciones1=view.findViewById(R.id.lyUbicacionOpcion1)
        lyOpciones2=view.findViewById(R.id.lyUbicacionOpcion2)
        lyOpciones3=view.findViewById(R.id.lyUbicacionOpcion3)
        visto1=view.findViewById(R.id.vistoUbicacion)
        visto2=view.findViewById(R.id.vistoUbicacion2)
        visto3=view.findViewById(R.id.vistoUbicacion3)
        lyOpciones1.setOnClickListener {
            visto1.visibility = View.VISIBLE
//            Toast.makeText (activity,  "Listo" , Toast.LENGTH_LONG) .show ()
        }
        lyOpciones1.setOnClickListener {
            visto2.visibility = View.INVISIBLE
            visto3.visibility = View.INVISIBLE
            if(visto1.isVisible){
                visto1.visibility = View.INVISIBLE
            }else{
                visto1.visibility = View.VISIBLE
            }
        }
        lyOpciones2.setOnClickListener {
            visto1.visibility = View.INVISIBLE
            visto3.visibility = View.INVISIBLE
            if(visto2.isVisible){
                visto2.visibility = View.INVISIBLE
            }else{
                visto2.visibility = View.VISIBLE
            }
        }
        lyOpciones3.setOnClickListener {
            visto1.visibility = View.INVISIBLE
            visto2.visibility = View.INVISIBLE
            if(visto3.isVisible){
                visto3.visibility = View.INVISIBLE
            }else{
                visto3.visibility = View.VISIBLE
            }
        }
        return view

    }
}
