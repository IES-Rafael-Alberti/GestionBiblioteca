import org.pebiblioteca.Libro
import org.pebiblioteca.Usuario
import java.time.LocalDateTime

class RegistroPrestamos{
    private val prestamosActuales = mutableListOf<Pair<Libro, Usuario>>()
    private val historialPrestamos = mutableListOf<Triple<Libro, Usuario, LocalDateTime>>()

    fun registrarPrestamo(libro: Libro, usuario: Usuario) {
        prestamosActuales.add(Pair(libro, usuario))
        historialPrestamos.add(Triple(libro, usuario, LocalDateTime.now()))
    }

    fun devolverLibro(libro: Libro, usuario: Usuario) {
        val prestamo = prestamosActuales.find { it.first == libro && it.second == usuario }
        if (prestamo != null) {
            prestamosActuales.remove(prestamo)
            historialPrestamos.add(Triple(libro, usuario, LocalDateTime.now()))
        }
    }

    fun consultarHistorialPrestamosLibro(libro: Libro): List<Triple<Libro, Usuario, LocalDateTime>> {
        return historialPrestamos.filter { it.first == libro }
    }

    fun consultarHistorialPrestamosUsuario(usuario: Usuario): List<Triple<Libro, Usuario, LocalDateTime>> {
        return historialPrestamos.filter { it.second == usuario }
    }
}