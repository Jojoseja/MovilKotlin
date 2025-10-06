package org.example

import JuegoCartas

abstract class JuegoMesa(
    val titulo: String,
    val autor: String,
    val minJug: Int,
    val maxJug: Int,
    val duracion: Int,
    val tipoJuego: TipoJuego
) {

    open fun toArchivo(): String {
        return this.titulo + ";;" + this.autor + ";;" + this.minJug + ";" + this.maxJug + ";" + this.duracion + ";" + this.tipoJuego + ";";
    }

    override fun toString(): String {
        return "JuegoMesa(titulo='$titulo', autor='$autor', minJug=$minJug, maxJug=$maxJug, duracion=$duracion, tipoJuego=$tipoJuego)"
    }

    companion object {
        private val coleccion = ArrayList<JuegoMesa>()
        val juego: List<JuegoMesa> = coleccion

    }

}