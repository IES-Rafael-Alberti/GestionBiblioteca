package org.pebiblioteca

import RegistroPrestamos
import java.time.LocalDateTime

/**
 * Clase que gestiona la biblioteca, incluyendo la administración del catálogo de libros y el registro de préstamos.
 */

class GestorBiblioteca {
    private val catalogo = mutableListOf<Libro>()
    private val registroPrestamos = RegistroPrestamos()

    /**
     * Agrega un libro al catálogo de la biblioteca.
     *
     * @param titulo Título del libro.
     * @param autor Autor del libro.
     * @param añoPublicacion Año de publicación del libro.
     * @param tematica Temática del libro.
     */

    fun agregarLibro(titulo: String, autor: String, añoPublicacion: Int, tematica: String) {
        val id = UtilidadesBiblioteca.generarIdentificadorUnico()
        val libro = Libro(id, titulo, autor, añoPublicacion, tematica)
        catalogo.add(libro)
    }

    /**
     * Realiza un préstamo de un libro a un usuario.
     *
     * @param libro El libro a prestar.
     * @param usuario El usuario que realizará el préstamo.
     */

    fun realizarPrestamo(libro: Libro, usuario: Usuario) {
        if (libro.obtenerEstado() == "disponible") {
            libro.cambiarEstado("prestado")
            registroPrestamos.registrarPrestamo(libro, usuario)
            usuario.agregarLibroPrestado(libro)
        }
    }

    /**
     * Realiza la devolución de un libro prestado por un usuario.
     *
     * @param libro El libro a devolver.
     * @param usuario El usuario que realizará la devolución.
     */

    fun realizarDevolucion(libro: Libro, usuario: Usuario) {
        if (libro.obtenerEstado() == "prestado" && usuario.consultarLibrosPrestados().contains(libro)) {
            libro.cambiarEstado("disponible")
            registroPrestamos.devolverLibro(libro, usuario)
            usuario.quitarLibroPrestado(libro)
        }
    }

    /**
     * Consulta el historial de préstamos de un libro específico.
     *
     * @param libro El libro del cual se quiere consultar el historial de préstamos.
     * @return El historial de préstamos del libro.
     */

    fun consultarHistorialPrestamosLibro(libro: Libro): List<Triple<Libro, Usuario, LocalDateTime>> {
        return registroPrestamos.consultarHistorialPrestamosLibro(libro)
    }

    /**
     * Consulta el historial de préstamos de un usuario específico.
     *
     * @param usuario El usuario del cual se quiere consultar el historial de préstamos.
     * @return El historial de préstamos del usuario.
     */

    fun consultarHistorialPrestamosUsuario(usuario: Usuario): List<Triple<Libro, Usuario, LocalDateTime>> {
        return registroPrestamos.consultarHistorialPrestamosUsuario(usuario)
    }

    /**
     * Consulta el catálogo de libros de la biblioteca.
     *
     * @return El catálogo de libros.
     */

    fun consultarCatalogo(): List<Libro> {
        return catalogo.toList()
    }
}