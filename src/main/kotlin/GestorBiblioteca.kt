package org.pebiblioteca

/**
 * Clase encargada de gestionar los libros de la biblioteca.
 */

class GestorBiblioteca {
    val catalogo = mutableListOf<Libro>()
    val registroPrestamos = mutableListOf<Pair<Libro, String>>() // (Libro, Usuario)

    /**
     * Agrega un libro al catálogo de la biblioteca.
     * @param libro El libro a agregar al catálogo.
     */

    fun agregarLibro(titulo: String, autor: String, añoPublicacion: Int, tematica: String) {
        val id = UtilidadesBiblioteca.generarIdentificadorUnico()
        val libro = Libro(id, titulo, autor, añoPublicacion, tematica)
        catalogo.add(libro)
    }

    /**
     * Elimina un libro del catálogo de la biblioteca.
     * @param id Identificador del libro a eliminar.
     */

    fun eliminarLibro(id: String) {
        val libro = catalogo.find { it.id == id }
        if (libro != null) {
            catalogo.remove(libro)
        } else {
            println("El libro con ID $id no existe en el catálogo.")
        }
    }

    /**
     * Registra un préstamo de un libro a un usuario.
     * @param idLibro Identificador del libro a prestar.
     * @param usuario Nombre del usuario que realiza el préstamo.
     */

    fun registrarPrestamo(idLibro: String, usuario: String) {
        val libro = catalogo.find { it.id == idLibro }
        if (libro != null) {
            if (libro.estado == "disponible") {
                libro.estado = "prestado"
                registroPrestamos.add(Pair(libro, usuario))
                println("Préstamo registrado correctamente.")
            } else {
                println("El libro con ID $idLibro no está disponible para préstamo.")
            }
        } else {
            println("El libro con ID $idLibro no existe en el catálogo.")
        }
    }

    /**
     * Registra la devolución de un libro.
     * @param idLibro Identificador del libro a devolver.
     */

    fun devolverLibro(idLibro: String) {
        val libro = catalogo.find { it.id == idLibro }
        if (libro != null) {
            if (libro.estado == "prestado") {
                libro.estado = "disponible"
                val removed = registroPrestamos.removeIf { it.first.id == idLibro }
                if (removed) {
                    println("Devolución realizada correctamente.")
                } else {
                    println("Error: El libro con ID $idLibro no estaba registrado como prestado.")
                }
            } else {
                println("El libro con ID $idLibro no está prestado.")
            }
        } else {
            println("El libro con ID $idLibro no existe en el catálogo.")
        }
    }

    /**
     * Consulta la disponibilidad de un libro en el catálogo.
     * @param idLibro Identificador del libro a consultar.
     */

    fun consultarDisponibilidad(idLibro: String) {
        val libro = catalogo.find { it.id == idLibro }
        if (libro != null) {
            println("El libro con ID $idLibro está ${libro.estado}.")
        } else {
            println("El libro con ID $idLibro no existe en el catálogo.")
        }
    }

    /**
     * Muestra el catálogo de libros de la biblioteca.
     */

    fun mostrarCatalogo() {
        println("Catálogo de libros:")
        catalogo.forEach { println("${it.id}: ${it.titulo}, ${it.autor}, ${it.añoPublicacion}, ${it.tematica}, ${it.estado}") }
    }

    /**
     * Muestra el registro de préstamos de la biblioteca.
     */

    fun mostrarPrestamos() {
        println("Registro de préstamos:")
        registroPrestamos.forEach { println("${it.first.id}: ${it.first.titulo}, Prestado a ${it.second}") }
    }
}