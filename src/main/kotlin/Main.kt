package org.pebiblioteca

fun main() {
    val registroPrestamos = RegistroPrestamos()

    val gestorBiblioteca = GestorBiblioteca(registroPrestamos)

    // Creación de elementos de biblioteca (en este caso, libros)
    val libro1 = Libro("1", "El Señor de los Anillos", "JRR Tolkien", 1954, "Fantasía")
    val libro2 = Libro("2", "El Resplandor", "Stephen King", 1977, "Terror")
    val libro3 = Libro("3", "Cosmos", "Carl Sagan", 1980, "Ciencia")

    // Agregar los libros al catálogo de la biblioteca
    gestorBiblioteca.agregarElemento(libro1)
    gestorBiblioteca.agregarElemento(libro2)
    gestorBiblioteca.agregarElemento(libro3)

    val usuario1 = Usuario(1, "Usuario1")
    val usuario2 = Usuario(2, "Usuario2")

    // Realizar operaciones de préstamo y devolución
    gestorBiblioteca.prestarElemento(libro1, usuario1)
    gestorBiblioteca.prestarElemento(libro2, usuario2)

    gestorBiblioteca.devolverElemento(libro1, usuario1)

    // Mostrar historial de préstamos
    val historialPrestamos = registroPrestamos.consultarHistorialPrestamos()
    println("Historial de préstamos:")
    historialPrestamos.forEach { (elemento, usuario) ->
        println("Elemento: ${elemento.titulo}, Usuario: ${usuario.nombre}")
    }
}



