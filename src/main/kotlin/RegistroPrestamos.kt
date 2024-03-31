import org.pebiblioteca.Libro
import org.pebiblioteca.Usuario
import java.time.LocalDateTime

/**
 * Clase que registra los préstamos de libros realizados en la biblioteca.
 */

class RegistroPrestamos{
    private val prestamosActuales = mutableListOf<Pair<Libro, Usuario>>()
    private val historialPrestamos = mutableListOf<Triple<Libro, Usuario, LocalDateTime>>()

    /**
     * Registra un préstamo de libro realizado por un usuario.
     *
     * @param libro El libro prestado.
     * @param usuario El usuario que realiza el préstamo.
     */

    fun registrarPrestamo(libro: Libro, usuario: Usuario) {
        prestamosActuales.add(Pair(libro, usuario))
        historialPrestamos.add(Triple(libro, usuario, LocalDateTime.now()))
    }

    /**
     * Registra la devolución de un libro prestado por un usuario.
     *
     * @param libro El libro devuelto.
     * @param usuario El usuario que devuelve el libro.
     */

    fun devolverLibro(libro: Libro, usuario: Usuario) {
        val prestamo = prestamosActuales.find { it.first == libro && it.second == usuario }
        if (prestamo != null) {
            prestamosActuales.remove(prestamo)
            historialPrestamos.add(Triple(libro, usuario, LocalDateTime.now()))
        }
    }

    /**
     * Consulta el historial de préstamos de un libro específico.
     *
     * @param libro El libro del cual se quiere consultar el historial de préstamos.
     * @return El historial de préstamos del libro.
     */

    fun consultarHistorialPrestamosLibro(libro: Libro): List<Triple<Libro, Usuario, LocalDateTime>> {
        return historialPrestamos.filter { it.first == libro }
    }

    /**
     * Consulta el historial de préstamos realizados por un usuario específico.
     *
     * @param usuario El usuario del cual se quiere consultar el historial de préstamos.
     * @return El historial de préstamos del usuario.
     */

    fun consultarHistorialPrestamosUsuario(usuario: Usuario): List<Triple<Libro, Usuario, LocalDateTime>> {
        return historialPrestamos.filter { it.second == usuario }
    }
}