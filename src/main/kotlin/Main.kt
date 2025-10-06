import org.example.JuegoColeccion
import org.example.JuegoMesa
import org.example.TipoJuego

fun main(){
    val juco01 = JuegoColeccion<JuegoMesa>();
    //juco01.busqueda("TEST");
    val ju01 = JuegoTablero("Hola", "Autor", 2, 3, 90, TipoJuego.ESTRATEGIA, "Grande");
    println(ju01);


    //Inicio Programa
    val menu = true;
    while (menu){
        println("1. Placeholder \n2. Placeholder \n3. Placeholder \n4. Salir del Programa \n")
        val opcion = readln()
        when (opcion) {
            "1" -> println("Hola")
            "2" -> {println("Listado"); JuegoMesa.coleccion}
            "3" -> println("Grande")
            "4" -> {println("Saliendo del programa..."); break}
        }
    }
}