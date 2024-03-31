import org.pebiblioteca.Libro
import org.pebiblioteca.GestorBiblioteca

fun main() {
    val gestor = GestorBiblioteca()

    var libro1 = Libro(1, "El Señor de los Anillos", "JRR Tolkien", 1954, "Fantasía")
    var libro2 = Libro(2, "El Resplandor", "Stephen King", 1977, "Terror")
    var libro3 = Libro(3, "Cosmos", "Carl Sagan", 1980, "Ciencia")

    // Se añaden los libros al catálogo
    gestor.agregarLibro(libro1)
    gestor.agregarLibro(libro2)
    gestor.agregarLibro(libro3)

    gestor.registrarPrestamo(1, "Usuario1") // Préstamo libro 1
    gestor.registrarPrestamo(2, "Usuario2") // Préstamo libro 2
    gestor.devolverLibro(1) // Devolución del libro 1
    gestor.devolverLibro(1) // No lo devuelve porque ya no está prestado
    gestor.devolverLibro(4) // No lo devuelve puesto que no existe en el catálogo

    gestor.mostrarCatalogo() // Se muestra el catálogo de los libros registrados
    gestor.mostrarPrestamos() // Se muestran los préstamos actuales
}



