import org.example.JuegoMesa
import org.example.TipoJuego

class JuegoCartas(titulo: String, autor: String, minJug: Int, maxJug: Int, duracion: Int, tipoJuego: TipoJuego, val cartas: Int)
    : JuegoMesa(titulo, autor, minJug, maxJug, duracion, tipoJuego) {

    override fun toArchivo(): String {
        return super.toArchivo() + this.cartas
    }

    override fun toString(): String {
        return super.toString()+ "JuegoCartas(cartas=$cartas)"
    }
}