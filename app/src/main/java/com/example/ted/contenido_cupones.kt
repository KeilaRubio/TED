package com.example.ted

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.detalle_cupones.*

class contenido_cupones : AppCompatActivity() {
    private lateinit var tituloCupones: TextView
    private lateinit var imagenCupones: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalle_cupones)
        tituloCupones=findViewById(R.id.tvTituloCupones)
        imagenCupones=findViewById(R.id.imagen_cabecera_cupones)
        val estrella = findViewById<View>(R.id.estrella) as FloatingActionButton
        val estrellaDos = findViewById<View>(R.id.estrella_dos) as FloatingActionButton
        val cuponesAppBarLayout = findViewById<View>(R.id.barToolDetalleCupones) as AppBarLayout

        setSupportActionBar(findViewById(R.id.toolbar_detalle_cupones))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val bundle :Bundle ?=intent.extras
        val temaDetalleCupones =  bundle!!.getString("tituloCupones")
        tituloCupones.text = (temaDetalleCupones)

        val bundleImagenCupones :Bundle ?=intent.extras
        val imagenDetalleCupones =  bundleImagenCupones!!.getString("imagenCupones")
        Picasso.with(this).load(imagenDetalleCupones).into(imagenCupones)

        cuponesAppBarLayout.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {

            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {

                if (Math.abs(verticalOffset)-appBarLayout.getTotalScrollRange() == 0)
                {
                    //  on Collapse
                    estrellaDos.showOrGone(true)
                    translate()

                }
                else
                {
                    //  on expand
                    estrellaDos.showOrGone(false)

                }
            }
        })
    }

    fun View.showOrGone(show: Boolean) {
        visibility = if(show) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun translate() {
        val anims = AnimatorSet()
        val sX = ObjectAnimator.ofFloat(estrella_dos, View.SCALE_X, 0.2f, 1.0f)
        val sY = ObjectAnimator.ofFloat(estrella_dos, View.SCALE_Y, 0.2f, 1.0f)
        anims.playTogether(sX, sY)
        anims.interpolator = AccelerateInterpolator()
        anims.start()
    }
}
