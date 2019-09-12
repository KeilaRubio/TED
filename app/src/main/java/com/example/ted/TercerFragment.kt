package com.example.ted

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment

class TercerFragment : Fragment() {
    lateinit var lyOtrosOpciones1: LinearLayout
    lateinit var visto1: ImageView

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_tercer_fragment)
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view:View= inflater!!.inflate(R.layout.activity_tercer_fragment, container, false)
        lyOtrosOpciones1=view.findViewById(R.id.lyOtrosOpcion1)
        visto1=view.findViewById(R.id.vistoOtros)

        lyOtrosOpciones1.setOnClickListener {
            if(visto1.isVisible){
                visto1.visibility = View.INVISIBLE
            }else{
                visto1.visibility = View.VISIBLE
            }
        }

        return view
    }
}
