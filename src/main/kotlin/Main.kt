import org.example.JuegoColeccion
import org.example.JuegoMesa
import org.example.TipoJuego

fun main(){
    val juco = JuegoColeccion<JuegoMesa>();

    //Inicio Programa
    val menu = true;
    juco.leerArchivo()
    while (menu){
        println("1. Crear Juego \n2. Placeholder \n3. Placeholder \n4. Salir del Programa \n")
        val opcion = readln()
        when (opcion) {
            "1" -> {
                //Titulo
                print("Insertar el título: ")
                val titulo = devolverString()

                //Autor
                print("Insertar el autor: ")
                val autor = devolverString()

                //Mínimo de Jugadores
                print("Mínimo de Jugadores: ")
                val minJug = devolverInt()

                //Maximo de Jugadores
                print("Máximo de Jugadores: ")
                val maxJug = devolverInt()

                //Duracion
                print("Duración de una partida: ")
                val duracion = devolverInt()

                //Tipo de juego
                print("Tipo de Juego:  ")
                var tipoJuegoInput = readln()
                var tipoJuego:TipoJuego = TipoJuego.OTRO
                tipoJuegoInput = tipoJuegoInput.uppercase()
                when (tipoJuegoInput) {
                    "FAMILIAR" -> tipoJuego = TipoJuego.FAMILIAR
                    "PARTY" -> tipoJuego = TipoJuego.PARTY
                    "ESTRATEGIA" -> tipoJuego = TipoJuego.ESTRATEGIA
                    else -> tipoJuego = TipoJuego.OTRO
                }

                //JuegoCartas o JuegoTablero
                print("Es de cartas o tablero?: ")
                var formato:String = "";
                while (formato != "cartas" && formato != "tablero")
                {
                    formato = readln()
                    formato = formato.lowercase()
                }
                if (formato.equals("cartas")){
                    print("Numero de cartas: ")
                    val numeroCartasInput = readln()
                    val numeroCartas:Int = Integer.valueOf(numeroCartasInput)

                    juco.add(JuegoCartas(titulo, autor, minJug, maxJug, duracion, tipoJuego, numeroCartas))
                }
                else {
                    print("Tamaño del tablero: ")
                    val size = readln()

                    juco.add(JuegoTablero(titulo, autor, minJug, maxJug, duracion, tipoJuego, size))
                }
            }
            "2" -> {
                println("Listado");
                juco.imprimirLista()
            }
            "3" -> {
                println("Busqueda");
                print("Texto a Buscar: ")
                val texto = readln()
                val lista = juco.busqueda(texto)
                println(lista)
            }
            "4" -> {
                println("Saliendo del programa...");
                juco.escribirArchivo();
                break
            }
        }
    }

}
fun devolverString(): String {
    var nombre:String = ""
    while (true) {
        try {
            nombre = readln()
            break
        } catch (e:Exception ){

        }
    }
    return nombre
}

fun devolverInt(): Int{
    var numero:Int = 0
    while (true) {
        try {
            numero = Integer.valueOf(readln())
            break;
        } catch (e:Exception){ }
    }
    return numero
}

