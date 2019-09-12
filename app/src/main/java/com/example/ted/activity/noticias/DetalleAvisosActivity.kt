package com.example.ted.activity.noticias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.ted.R
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class DetalleAvisosActivity : AppCompatActivity() {
    private lateinit var titulo: TextView
    private lateinit var foto: ImageView
    private lateinit var descripcion: TextView
    private lateinit var fecha: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.avisos_contenido)
        titulo=findViewById(R.id.tvTitulo_avisos)
        foto=findViewById(R.id.imagen_cabecera_avisos)
        descripcion=findViewById(R.id.tvDescripcion_avisos)
        fecha=findViewById(R.id.tvFecha)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val bundle :Bundle ?=intent.extras
        val tema =  bundle?.getString("titulo_aviso") //cambiar ? por esto !!
        titulo.text = (tema)

        val bundleFoto :Bundle ?=intent.extras
        val imagen = bundleFoto?.getString("foto_Aviso")
        if (imagen != null) {
            if(imagen.isEmpty()){
                foto.showOrGone(false)

            }else{
                Picasso.with(this).load(imagen).into(foto)

            }
        }

        val bundleDetalle :Bundle ?=intent.extras
        val contenido =  bundleDetalle?.getString("descripcion")
        descripcion.text = (contenido)

        val bundleHora :Bundle ?=intent.extras
        val fechaAvisos =  bundleHora?.getString("fecha")
        fecha.text = (fechaAvisos)

    }

    fun View.showOrGone(show: Boolean) {
        visibility = if(show) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> {
//                val intent = Intent(this, DetalleNoticiaActivity::class.java)
//                startActivity(intent)
                Toast.makeText (applicationContext,  "Publicación eliminada" , Toast.LENGTH_LONG) .show ()
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
