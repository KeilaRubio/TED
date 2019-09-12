package com.example.ted

import android.R.attr.onClick
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalle_favorito.*
import kotlinx.android.synthetic.main.activity_detalle_negocio.*
import android.graphics.drawable.TransitionDrawable
import android.graphics.drawable.ColorDrawable
import android.widget.Toast
import android.R.attr.start
import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import androidx.core.content.ContextCompat
import android.content.res.ColorStateList
import android.view.animation.Animation
import androidx.core.view.ViewCompat.setBackgroundTintList
import android.view.animation.DecelerateInterpolator
import android.view.animation.ScaleAnimation
import android.widget.Button
import kotlinx.android.synthetic.main.detalle_cupones.*


class DetalleFavorito : AppCompatActivity() {
    private lateinit var tituloFavorito: TextView
    private lateinit var imagenDetalleFavorito: ImageView
    lateinit var cupon:Button
    lateinit var cuponCodigo:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_favorito)
        tituloFavorito=findViewById(R.id.tvTituloFavorito)
        imagenDetalleFavorito=findViewById(R.id.imagen_cabecera_favorito)
        cupon=findViewById(R.id.btnCupon)
        cuponCodigo=findViewById(R.id.tvCupon)
        //val estrellaFavoritoDos = findViewById<View>(R.id.estrella_favorito_dos) as FloatingActionButton
        val estrellaFavorito = findViewById<View>(R.id.estrellaFavorito) as FloatingActionButton
//        val favoritoAppBarLayout = findViewById<View>(R.id.barToolDetalleFavorito) as AppBarLayout

        setSupportActionBar(findViewById(R.id.toolbar_detalle_favorito))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val bundleImagenFavorito :Bundle ?=intent.extras
        val imagenFavorito =  bundleImagenFavorito!!.getString("imagenFavorito")
        Picasso.with(this).load(imagenFavorito).into(imagenDetalleFavorito)

        val bundleFavorito :Bundle ?=intent.extras
        val temaDetalleFavorito =  bundleFavorito!!.getString("tituloFavorito")
        tituloFavorito.text = (temaDetalleFavorito)

//        favoritoAppBarLayout.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
//
//            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
//
//                if (Math.abs(verticalOffset)-appBarLayout.totalScrollRange == 0)
//                {
//                    //  on Collapse
//                   // estrellaFavoritoDos.showOrGone(true)
//                   // translate()
//
//                }
//                else
//                {
//                    //  on expand
//                  //  estrellaFavoritoDos.showOrGone(false)
//                }
//            }
//        })

//        estrellaFavoritoDos.setOnClickListener {
////            Toast.makeText(this,"entro",Toast.LENGTH_LONG).show()
//            animaion()
////            estrellaFavoritoDos.rippleColor = ContextCompat.getColor(this, R.color.colorPrimary)
//        }

        estrellaFavorito.setOnClickListener {
            animaion()
        }

        cupon.setOnClickListener {
            cupon.visibility=View.INVISIBLE
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
//        val sX = ObjectAnimator.ofFloat(estrella_favorito_dos, View.SCALE_X, 0.2f, 1.0f)
//        val sY = ObjectAnimator.ofFloat(estrella_favorito_dos, View.SCALE_Y, 0.2f, 1.0f)
//        anims.playTogether(sX, sY)
//        anims.interpolator = AccelerateInterpolator()
//        anims.start()
//    }

    private fun animaion(){
//        val animator = ObjectAnimator.ofInt(estrella_favorito_dos, "backgroundTint", Color.rgb(0, 121, 107), Color.rgb(226, 143, 34))
//        estrella_favorito_dos.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#3EBFED") )
       // estrella_favorito_dos.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorPrimary))
        estrellaFavorito.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorPrimary))
        val anims = AnimatorSet()
      //  val sX = ObjectAnimator.ofFloat(estrella_favorito_dos, View.SCALE_X, 0.2f, 1.0f)
        val estrellaX = ObjectAnimator.ofFloat(estrellaFavorito, View.SCALE_X, 0.2f, 1.0f)
       // val sY = ObjectAnimator.ofFloat(estrella_favorito_dos, View.SCALE_Y, 0.2f, 1.0f)
        val estrellaY = ObjectAnimator.ofFloat(estrellaFavorito, View.SCALE_Y, 0.2f, 1.0f)
        //anims.playTogether(sX, sY)
        anims.playTogether(estrellaX, estrellaY)
        anims.interpolator = AccelerateInterpolator()
        anims.start()
    }


}
