package com.example.ted.modelo

data class EmpresaServicio (
    var negocios:String,
    var img_negocios:String,
    var puntos:String,
    var descripcion:String,
    var empresa:MutableList<Empresa> = ArrayList(),
    var favorito:MutableList<Favoritos> = ArrayList()
)