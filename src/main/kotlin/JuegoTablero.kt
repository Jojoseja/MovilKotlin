import org.example.JuegoMesa
import org.example.TipoJuego

class JuegoTablero(titulo: String, autor: String, minJug: Int, maxJug: Int, duracion: Int, tipoJuego: TipoJuego, val size: String, )
    : JuegoMesa(titulo, autor, minJug, maxJug, duracion, tipoJuego) {

    override fun toArchivo(): String {
        return super.toArchivo() + this.size
    }

    override fun toString(): String {
        return super.toString() + "JuegoTablero(size='$size')"
    }

}