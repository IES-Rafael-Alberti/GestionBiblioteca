import org.pebiblioteca.Libro
import org.pebiblioteca.GestorBiblioteca
import org.pebiblioteca.Usuario

fun main() {
    val gestor = GestorBiblioteca()

    // Se crean los usuarios
    val usuario1 = Usuario(1, "Usuario1")
    val usuario2 = Usuario(2, "Usuario2")

    // Se agregan los libros a la biblioteca
    gestor.agregarLibro("El Señor de los Anillos", "JRR Tolkien", 1954, "Fantasía")
    gestor.agregarLibro("El Resplandor", "Stephen King", 1977, "Terror")
    gestor.agregarLibro("Cosmos", "Carl Sagan", 1980, "Ciencia")

    // Consulta del catálogo
    val librosCatalogo = gestor.consultarCatalogo()
    println("Catálogo de libros:")
    librosCatalogo.forEach { println("${it.titulo}, ${it.autor}, ${it.añoPublicacion}, ${it.tematica}, ${it.obtenerEstado()}") }

    // Préstamos
    gestor.realizarPrestamo(librosCatalogo[0], usuario1)
    gestor.realizarPrestamo(librosCatalogo[1], usuario2)

    // Libros prestados por un usuario en específico
    println("\nLibros prestados por ${usuario1.nombre}:")
    usuario1.consultarLibrosPrestados().forEach { println("${it.titulo}") }

    // Historial de préstamos de un usuario en específico
    println("\nHistorial de préstamos para ${librosCatalogo[0].titulo}:")
    val historialLibro1 = gestor.consultarHistorialPrestamosLibro(librosCatalogo[0])
    historialLibro1.forEach { println("${it.second.nombre} - ${it.third}") }
}



