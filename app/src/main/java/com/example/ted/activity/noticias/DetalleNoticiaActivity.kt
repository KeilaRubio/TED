package com.example.ted.activity.noticias

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.BounceInterpolator
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import androidx.core.widget.NestedScrollView
import com.example.ted.R
import com.example.ted.Recycler_avisos
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.ejemplo.*

class DetalleNoticiaActivity : AppCompatActivity() {
    private lateinit var titulo: TextView
    private lateinit var foto: ImageView
    private lateinit var detalle: TextView
    private lateinit var hora: TextView
    private lateinit var revision: TextView
    private lateinit var traduccioon: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ejemplo)
        titulo=findViewById(R.id.tvTitulo)
        foto=findViewById(R.id.imagen_cabecera)
        detalle=findViewById(R.id.tvDetalle)
        hora=findViewById(R.id.tvHora)
        traduccioon=findViewById(R.id.tvTraduccion)
        revision=findViewById(R.id.tvRevision)
        val like_dos = findViewById<View>(R.id.like_dos) as FloatingActionButton
        val like = findViewById<View>(R.id.like) as FloatingActionButton
        val mAppBarLayout = findViewById<View>(R.id.barTool) as AppBarLayout

        // Direciona al otro Activity
        like.setOnClickListener {
            val intent = Intent(this, Recycler_avisos::class.java)
                startActivity(intent)
        }

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //toolbar.title="hola"

//        val toolbar=supportActionBar
//        toolbar!!.title="TED"
//        setSupportActionBar(toolbar)
//        toolbar.setDisplayHomeAsUpEnabled(true)
//        toolbar.setDisplayHomeAsUpEnabled(true)


        val traduccion="Traducido al Español por Francisco Gneco"
        val colorTexto= SpannableString(traduccion)
        val red=ForegroundColorSpan(Color.RED)
        val gray=ForegroundColorSpan(Color.GRAY)
        colorTexto.setSpan(gray,0, 24, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        colorTexto.setSpan(red,25, 40, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        traduccioon.text = colorTexto


        val bundle :Bundle ?=intent.extras
        val tema =  bundle!!.getString("titulo")
        titulo.text = (tema)

        val bundleFoto :Bundle ?=intent.extras
        val imagen =  bundleFoto!!.getString("foto")
        Picasso.with(this).load(imagen).into(foto)


        val bundleDetalle :Bundle ?=intent.extras
        val contenido =  bundleDetalle!!.getString("detalle")
        detalle.text = (contenido)

        val bundleHora :Bundle ?=intent.extras
        val horaNoticia =  bundleHora!!.getString("hora")
        hora.text = (horaNoticia)


        mAppBarLayout.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {

            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {

                if (Math.abs(verticalOffset)-appBarLayout.getTotalScrollRange() == 0)
                {
                    //  on Collapse
                    like_dos.showOrGone(true)
                    translate()

                }
                else
                {
                    //  on expand
                    like_dos.showOrGone(false)

                }
            }
        })

    }

//        fun validarPrimerLike() {
//            if (like.visibility == View.VISIBLE){
//                like_dos.showOrGone(false)
//
//            }else{
//                like_dos.showOrGone(true)
//
//            }
//        }
//

        fun View.showOrGone(show: Boolean) {
            visibility = if(show) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
//
//        fun showHide(view:View) {
//            view.visibility = if (view.visibility == View.VISIBLE){
//                View.INVISIBLE //si esta visible
//            } else{
//                View.VISIBLE // si esta invisible
//            }
//        }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun translate() {
        val anims = AnimatorSet()
        val sX = ObjectAnimator.ofFloat(like_dos, View.SCALE_X, 0.2f, 1.0f)
        val sY = ObjectAnimator.ofFloat(like_dos, View.SCALE_Y, 0.2f, 1.0f)
        anims.playTogether(sX, sY)
        anims.interpolator = AccelerateInterpolator()
        anims.start()
    }

}
