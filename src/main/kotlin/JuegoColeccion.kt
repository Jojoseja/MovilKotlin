package org.example

import java.util.Locale.getDefault

//TODO-1: Portar JuegoColección
public class JuegoColeccion<JuegoMesa> : ArrayList<JuegoMesa>(){

    fun busqueda(text: String){
        val text = text.lowercase(getDefault())

    }
}