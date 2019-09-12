package com.example.ted

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ted.adapter.NoticiaAdapter
import com.example.ted.modelo.Noticia

class MainActivity : AppCompatActivity() {
    lateinit var expositorRecyclerView : RecyclerView
    val mAdapter : NoticiaAdapter = NoticiaAdapter()
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView()
    }

    fun recyclerView(){
        expositorRecyclerView = findViewById(R.id.expositorLista) as RecyclerView
        expositorRecyclerView.setHasFixedSize(true)
        expositorRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter.RecyclerAdapter(obtenerExpositores(), this)
        expositorRecyclerView.adapter = mAdapter
    }

    fun obtenerExpositores(): MutableList<Noticia>{
        var expositor:MutableList<Noticia> = ArrayList()
        expositor.add(
            Noticia(
                "Ken Robinson dice que las escuelas matan la creatividad",
                "https://www.roastbrief.com.mx/wp-content/uploads/2018/07/roastbrief-oratoria-7-consejos-para-dar-conferencias-inolvidables-780x405.jpg",
                "12:30",
                "Lo que Ken Robinson pone de manifiesto, es que es necesario potenciar otros métodos de aprendizaje y enseñanza, resolución de problemas y respaldo de la creatividad, y esto es algo que considero que podemos conseguir gracias a utilizar mucho más nuestro pensamiento visual. Dentro de la educación es vital empezar a dar protagonismo y fomentar la Creatividad, teniendo que llegar a considerarla algo básico como la alfabetización."
            )
        )
        expositor.add(
            Noticia(
                "El lenguaje corporal moldea nuestra nuestra identidad",
                "https://criterionoticias.com/wp-content/uploads/2019/04/sippina-780x405.jpg",
                "15:50",
                "Lo que Ken Robinson pone de manifiesto, es que es necesario potenciar otros métodos de aprendizaje y enseñanza, resolución de problemas y respaldo de la creatividad, y esto es algo que considero que podemos conseguir gracias a utilizar mucho más nuestro pensamiento visual. Dentro de la educación es vital empezar a dar protagonismo y fomentar la Creatividad, teniendo que llegar a considerarla algo básico como la alfabetización."
            )
        )
        expositor.add(
            Noticia(
                "Esto es lo que pasa cuando uno responde a un correo basura",
                "https://www.datasur.com/website/wp-content/uploads/2019/06/cuentaaduana-780x405.jpg",
                "21:10",
                "Lo que Ken Robinson pone de manifiesto, es que es necesario potenciar otros métodos de aprendizaje y enseñanza, resolución de problemas y respaldo de la creatividad, y esto es algo que considero que podemos conseguir gracias a utilizar mucho más nuestro pensamiento visual. Dentro de la educación es vital empezar a dar protagonismo y fomentar la Creatividad, teniendo que llegar a considerarla algo básico como la alfabetización."
            )
        )
        expositor.add(
            Noticia(
                "Arranque de CONQUE 2018",
                "https://updatemexico.com/wp-content/uploads/2018/05/CONQUE-TRINO-2-780x405.jpg",
                "9:20",
                "Lo que Ken Robinson pone de manifiesto, es que es necesario potenciar otros métodos de aprendizaje y enseñanza, resolución de problemas y respaldo de la creatividad, y esto es algo que considero que podemos conseguir gracias a utilizar mucho más nuestro pensamiento visual. Dentro de la educación es vital empezar a dar protagonismo y fomentar la Creatividad, teniendo que llegar a considerarla algo básico como la alfabetización."
            )
        )
        expositor.add(
            Noticia(
                "Es un deber que el sector público tenga bolsillos de cristal",
                "https://nuestropuntodevista.com/wp-content/uploads/2018/12/Carlos-Gonz%C3%A1lez-Es-un-deber-que-el-sector-p%C3%BAblico-tenga-bolsillos-de-cristal-780x405.jpg",
                "18:45",
                "Lo que Ken Robinson pone de manifiesto, es que es necesario potenciar otros métodos de aprendizaje y enseñanza, resolución de problemas y respaldo de la creatividad, y esto es algo que considero que podemos conseguir gracias a utilizar mucho más nuestro pensamiento visual. Dentro de la educación es vital empezar a dar protagonismo y fomentar la Creatividad, teniendo que llegar a considerarla algo básico como la alfabetización."
            )
        )
        return expositor
    }


}




