package com.example.ted

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_principal.*

class PrincipalActivity : AppCompatActivity() {
    private lateinit var principal:Button
    private lateinit var aviso:Button
    private lateinit var noticia:Button
    private lateinit var negocios:Button
    private lateinit var cupon:Button
    private lateinit var calificar:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        principal=findViewById(R.id.principal)
        noticia=findViewById(R.id.noticia)
        aviso=findViewById(R.id.aviso)
        negocios=findViewById(R.id.negocios)
        cupon=findViewById(R.id.cupones)
        calificar=findViewById(R.id.calificar)

        principal.setOnClickListener {
            val intent = Intent(this, InicioActivity::class.java)
            startActivity(intent)
        }

        noticia.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        aviso.setOnClickListener {
            val intent = Intent(this, Recycler_avisos::class.java)
            startActivity(intent)
        }

        servicioss.setOnClickListener {
            val intent = Intent(this, ServiciosActivity::class.java)
            startActivity(intent)
        }

         negocios.setOnClickListener {
                val intent = Intent(this, RecyclerNegocios::class.java)
                startActivity(intent)
        }
        cupon.setOnClickListener {
            val intent = Intent(this, Recycler_cupones::class.java)
            startActivity(intent)
        }
        calificar.setOnClickListener {
            val intent = Intent(this, CalificarNegocio::class.java)
            startActivity(intent)
        }

    }
}
