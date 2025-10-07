package org.example

import JuegoCartas
import JuegoTablero
import java.io.File
import java.nio.file.Path
import java.util.Locale.getDefault

class JuegoColeccion<JuegoMesa> : ArrayList<JuegoMesa>(){

    fun busqueda(text: String): List<JuegoMesa>{
        val text = text.lowercase(getDefault())
        val lista = mutableListOf<JuegoMesa>()
        this.forEach {
            juego ->
            when (juego) {
                is JuegoCartas -> {if (juego.titulo.lowercase().contains(text)) lista.add(juego) }
                is JuegoTablero -> {if (juego.titulo.lowercase().contains(text)) lista.add(juego) }
            }
        }
        return lista
    }

    fun imprimirLista(){
        for (Juego in this){
            println(Juego.toString())
        }
    }

    fun leerArchivo(){
        val path: Path = Path.of("src", "main", "kotlin", "coleccion.txt")
        val file: File = path.toFile()
        val tempList = mutableListOf<JuegoMesa>()
        file.useLines { lines ->
            lines.forEach { line ->
                println(line)
                tempList.add(parseJuego(line) as JuegoMesa);
            }
        }
        this.addAll(tempList)
    }

    fun parseJuego(line: String): JuegoMesa? {
        return try {
            val espe = line.split(";")
            val test: TipoJuego = TipoJuego.valueOf(espe[6])
            println(espe)
            when (espe[0].trim().lowercase()){
                "cartas" -> JuegoCartas(espe[1], espe[2], espe[3].toInt(),
                    espe[4].toInt(), espe[5].toInt(), tipoJuego = test, espe[7].toInt()
                )

                "tablero" -> JuegoTablero(espe[1], espe[2], espe[3].toInt(),
                    espe[4].toInt(), espe[5].toInt(), test, espe[7]
                )

                else -> null
            }
        } catch (e: Exception) {
            println(e.toString())
        } as JuegoMesa?
    }

    fun escribirArchivo() {
        val path: Path = Path.of("src", "main", "kotlin", "coleccion.txt")
        val file: File = path.toFile()
        file.bufferedWriter().use { writer ->

            this.forEach { juego ->
                val line = when (juego) {
                    is JuegoCartas -> "cartas;${juego.titulo};${juego.autor};${juego.minJug};${juego.maxJug};${juego.duracion};${juego.tipoJuego};${juego.cartas}"
                    is JuegoTablero -> "tablero;${juego.titulo};${juego.autor};${juego.minJug};${juego.maxJug};${juego.duracion};${juego.tipoJuego};${juego.size}"
                    else -> {
                        null
                    }
                }
                line?.let {
                    writer.write(it)
                    writer.newLine()
                }
            }
        }
    }
}

