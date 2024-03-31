package org.pebiblioteca

fun main() {
    // Creación del catálogo
    val catalogo = Catalogo()

    // Creación del gestor de préstamos
    val registroPrestamos = RegistroPrestamos()

    // Creación del gestor de biblioteca
    val gestorBiblioteca = GestorBiblioteca(catalogo, registroPrestamos)

    // Creación y agregación de elementos al catálogo
    val libro1 = Libro("1", "El Señor de los Anillos", "JRR Tolkien", 1954, "Fantasía")
    val libro2 = Libro("2", "El Resplandor", "Stephen King", 1977, "Terror")
    val libro3 = Libro("3", "Cosmos", "Carl Sagan", 1980, "Ciencia")
    catalogo.agregarElemento(libro1)
    catalogo.agregarElemento(libro2)
    catalogo.agregarElemento(libro3)

    // Realizar operaciones de préstamo y devolución
    gestorBiblioteca.prestarElemento(libro1, Usuario(1, "Usuario1"))
    gestorBiblioteca.prestarElemento(libro2, Usuario(2, "Usuario2"))
    gestorBiblioteca.devolverElemento(libro1, Usuario(1, "Usuario1"))

    // Mostrar catálogo actualizado
    println("Catálogo de elementos:")
    val elementosCatalogo = catalogo.obtenerElementos()
    elementosCatalogo.forEach { println("${it.titulo}, ${it.autor}, ${it.añoPublicacion}, ${it.tematica}, ${it.estado}") }

    // Mostrar historial de préstamos
    println("\nHistorial de préstamos:")
    val historialPrestamos = registroPrestamos.consultarHistorialPrestamos()
    historialPrestamos.forEach { println("Elemento: ${it.first.titulo}, Usuario: ${it.second.nombre}") }
}



