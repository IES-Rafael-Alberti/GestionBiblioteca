import org.pebiblioteca.Libro
import org.pebiblioteca.GestorBiblioteca
import org.pebiblioteca.Usuario

fun main() {
    val gestor = GestorBiblioteca()
    val usuario1 = Usuario(1, "Usuario1")
    val usuario2 = Usuario(2, "Usuario2")

    gestor.agregarLibro("El Señor de los Anillos", "JRR Tolkien", 1954, "Fantasía")
    gestor.agregarLibro("El Resplandor", "Stephen King", 1977, "Terror")
    gestor.agregarLibro("Cosmos", "Carl Sagan", 1980, "Ciencia")

    val librosCatalogo = gestor.consultarCatalogo()
    println("Catálogo de libros:")
    librosCatalogo.forEach { println("${it.titulo}, ${it.autor}, ${it.añoPublicacion}, ${it.tematica}, ${it.obtenerEstado()}") }

    gestor.realizarPrestamo(librosCatalogo[0], usuario1)
    gestor.realizarPrestamo(librosCatalogo[1], usuario2)

    println("\nLibros prestados por ${usuario1.nombre}:")
    usuario1.consultarLibrosPrestados().forEach { println("${it.titulo}") }

    println("\nHistorial de préstamos para ${librosCatalogo[0].titulo}:")
    val historialLibro1 = gestor.consultarHistorialPrestamosLibro(librosCatalogo[0])
    historialLibro1.forEach { println("${it.second.nombre} - ${it.third}") }
}



