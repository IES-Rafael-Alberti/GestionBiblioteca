import org.pebiblioteca.Libro
import org.pebiblioteca.GestorBiblioteca

fun main() {
    val gestor = GestorBiblioteca()

    println("Agregando libros:")
    gestor.agregarLibro("El Señor de los Anillos", "JRR Tolkien", 1954, "Fantasía")
    gestor.agregarLibro("El Resplandor", "Stephen King", 1977, "Terror")
    gestor.agregarLibro("Cosmos", "Carl Sagan", 1980, "Ciencia")

    println("\nCatálogo de libros:")
    gestor.mostrarCatalogo()
}



