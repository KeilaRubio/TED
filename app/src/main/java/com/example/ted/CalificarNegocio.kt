package com.example.ted

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import android.R.attr.y
import android.R.attr.x



class CalificarNegocio : AppCompatActivity() {
    lateinit var btnCalificar:Button
    lateinit var calificar:RatingBar
    lateinit var valorCalificacion:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calificar_negocio)
        btnCalificar=findViewById(R.id.btnCalificar)
        calificar = findViewById(R.id.rating_rating_bar)
        valorCalificacion = findViewById(R.id.valorCalificacion)
        btnCalificar.setOnClickListener {
            val rating = "Gracias por su calificación: " + calificar.rating
            //.text=rating
            Toast.makeText(this, "Gracias por su calificación $rating",Toast.LENGTH_SHORT ).show()


        }
    }
}
