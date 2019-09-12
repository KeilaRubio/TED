package com.example.ted

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalle_favorito.*
import kotlinx.android.synthetic.main.activity_detalle_negocio.*
import kotlinx.android.synthetic.main.detalle_cupones.*

class DetalleNegocio : AppCompatActivity() {
    private lateinit var tituloNegocio: TextView
    private lateinit var imagenDetalleNegocio: ImageView
    lateinit var local: Button
    lateinit var cuponLocal:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_negocio)
        tituloNegocio=findViewById(R.id.tvTituloNegocios)
        imagenDetalleNegocio=findViewById(R.id.imagen_cabecera_negocios)
        local=findViewById(R.id.btnLocal)
        cuponLocal=findViewById(R.id.tvLocal)
//        val estrellaNegociosDos = findViewById<View>(R.id.estrella_negocios_dos) as FloatingActionButton
        val estrellaNegocio = findViewById<View>(R.id.estrellaNegocio) as FloatingActionButton
//        val negociosAppBarLayout = findViewById<View>(R.id.barToolNegocios) as AppBarLayout

        setSupportActionBar(findViewById(R.id.toolbar_detalle_negocios))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val bundle :Bundle ?=intent.extras
        val temaDetalleNegocio =  bundle!!.getString("tituloNegocios")
        tituloNegocio.text = (temaDetalleNegocio)

        val bundleImagenCupones :Bundle ?=intent.extras
        val imagenDetalleNegocioo =  bundleImagenCupones!!.getString("imagenNegocio")
        Picasso.with(this).load(imagenDetalleNegocioo).into(imagenDetalleNegocio)
//
//        negociosAppBarLayout.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
//
//            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
//
//                if (Math.abs(verticalOffset)-appBarLayout.getTotalScrollRange() == 0)
//                {
//                    //  on Collapse
//                    estrellaNegociosDos.showOrGone(true)
//                    translate()
//
//                }
//                else
//                {
//                    //  on expand
//                    estrellaNegociosDos.showOrGone(false)
//
//                }
//            }
//        })

        estrellaNegocio.setOnClickListener {
            animaion()
        }

//        estrellaNegociosDos.setOnClickListener {
//            animaion()
//        }
        local.setOnClickListener {
            local.visibility=View.INVISIBLE
//            cuponCodigo.visibility=View.VISIBLE
        }


    }
//    fun View.showOrGone(show: Boolean) {
//        visibility = if(show) {
//            View.VISIBLE
//        } else {
//            View.GONE
//        }
//    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

//    private fun translate() {
//        val anims = AnimatorSet()
//        val sX = ObjectAnimator.ofFloat(estrella_negocios_dos, View.SCALE_X, 0.2f, 1.0f)
//        val sY = ObjectAnimator.ofFloat(estrella_negocios_dos, View.SCALE_Y, 0.2f, 1.0f)
//        anims.playTogether(sX, sY)
//        anims.interpolator = AccelerateInterpolator()
//        anims.start()
//    }
    private fun animaion(){
//        val animator = ObjectAnimator.ofInt(estrella_favorito_dos, "backgroundTint", Color.rgb(0, 121, 107), Color.rgb(226, 143, 34))
//        estrella_favorito_dos.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#000") )
//        estrella_negocios_dos.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorPrimary))
        estrellaNegocio.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorPrimary))
        val anims = AnimatorSet()
//        val sX = ObjectAnimator.ofFloat(estrella_negocios_dos, View.SCALE_X, 0.2f, 1.0f)
        val estrellaX = ObjectAnimator.ofFloat(estrellaNegocio, View.SCALE_X, 0.2f, 1.0f)
//        val sY = ObjectAnimator.ofFloat(estrella_negocios_dos, View.SCALE_Y, 0.2f, 1.0f)
        val estrellaY = ObjectAnimator.ofFloat(estrellaNegocio, View.SCALE_Y, 0.2f, 1.0f)
//        anims.playTogether(sX, sY)
        anims.playTogether(estrellaX, estrellaY)
        anims.interpolator = AccelerateInterpolator()
        anims.start()
    }
}
