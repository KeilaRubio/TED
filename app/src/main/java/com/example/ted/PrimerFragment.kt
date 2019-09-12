package com.example.ted

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment

class PrimerFragment : Fragment() {
    lateinit var lyOpciones1:LinearLayout
    lateinit var lyOpciones2:LinearLayout
    lateinit var lyOpciones3:LinearLayout
    lateinit var lyOpciones4:LinearLayout
    lateinit var lyOpciones5:LinearLayout
    lateinit var visto1:ImageView
    lateinit var visto2:ImageView
    lateinit var visto3:ImageView
    lateinit var visto4:ImageView
    lateinit var visto5:ImageView


    //lateinit var tvOpcion1: TextView

        //    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_primer_fragment)
//    }
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
//        inflater.inflate(R.layout.activity_primer_fragment, container, false)!!
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            val view:View = inflater!!.inflate(R.layout.activity_primer_fragment, container, false)
            lyOpciones1=view.findViewById(R.id.lyOpcion1)
            lyOpciones2=view.findViewById(R.id.lyOpcion2)
            lyOpciones3=view.findViewById(R.id.lyOpcion3)
            lyOpciones4=view.findViewById(R.id.lyOpcion4)
            lyOpciones5=view.findViewById(R.id.lyOpcion5)
            visto1=view.findViewById(R.id.visto)
            visto2=view.findViewById(R.id.visto2)
            visto3=view.findViewById(R.id.visto3)
            visto4=view.findViewById(R.id.visto4)
            visto5=view.findViewById(R.id.visto5)
           // tvOpcion1 =view.findViewById(R.id.tvOpcion1)

            lyOpciones1.setOnClickListener {
                visto2.visibility = View.INVISIBLE
                visto3.visibility = View.INVISIBLE
                visto4.visibility = View.INVISIBLE
                visto5.visibility = View.INVISIBLE
                if(visto1.isVisible){
                    visto1.visibility = View.INVISIBLE
                }else{
                    visto1.visibility = View.VISIBLE
                }
//                Toast.makeText (activity,  "Listo" , Toast.LENGTH_LONG) .show ()
            }
            lyOpciones2.setOnClickListener {
                visto1.visibility = View.INVISIBLE
                visto3.visibility = View.INVISIBLE
                visto4.visibility = View.INVISIBLE
                visto5.visibility = View.INVISIBLE
                if(visto2.isVisible){
                    visto2.visibility = View.INVISIBLE
                }else{
                    visto2.visibility = View.VISIBLE
                }
//                Toast.makeText (activity,  "Listo" , Toast.LENGTH_LONG) .show ()
            }
            lyOpciones3.setOnClickListener {
                visto1.visibility = View.INVISIBLE
                visto2.visibility = View.INVISIBLE
                visto4.visibility = View.INVISIBLE
                visto5.visibility = View.INVISIBLE
                if(visto3.isVisible){
                    visto3.visibility = View.INVISIBLE
                }else{
                    visto3.visibility = View.VISIBLE
                }
//                Toast.makeText (activity,  "Listo" , Toast.LENGTH_LONG) .show ()
            }
            lyOpciones4.setOnClickListener {
                visto1.visibility = View.INVISIBLE
                visto2.visibility = View.INVISIBLE
                visto3.visibility = View.INVISIBLE
                visto5.visibility = View.INVISIBLE

                if(visto4.isVisible){
                    visto4.visibility = View.INVISIBLE
                }else{
                    visto4.visibility = View.VISIBLE
                }
//                Toast.makeText (activity,  "Listo" , Toast.LENGTH_LONG) .show ()
            }
            lyOpciones5.setOnClickListener {
                visto1.visibility = View.INVISIBLE
                visto2.visibility = View.INVISIBLE
                visto3.visibility = View.INVISIBLE
                visto4.visibility = View.INVISIBLE
                if(visto5.isVisible){
                    visto5.visibility = View.INVISIBLE
                }else{
                    visto5.visibility = View.VISIBLE
                }
//                Toast.makeText (activity,  "Listo" , Toast.LENGTH_LONG) .show ()
            }

//            if(visto1.visibility == View.VISIBLE)
//            {
//            }
            return view
        }
}
