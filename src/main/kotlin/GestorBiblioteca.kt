package org.pebiblioteca

import RegistroPrestamos
import java.time.LocalDateTime

class GestorBiblioteca {
    private val catalogo = mutableListOf<Libro>()
    private val registroPrestamos = RegistroPrestamos()

    fun agregarLibro(titulo: String, autor: String, añoPublicacion: Int, tematica: String) {
        val id = UtilidadesBiblioteca.generarIdentificadorUnico()
        val libro = Libro(id, titulo, autor, añoPublicacion, tematica)
        catalogo.add(libro)
    }

    fun realizarPrestamo(libro: Libro, usuario: Usuario) {
        if (libro.obtenerEstado() == "disponible") {
            libro.cambiarEstado("prestado")
            registroPrestamos.registrarPrestamo(libro, usuario)
            usuario.agregarLibroPrestado(libro)
        }
    }

    fun realizarDevolucion(libro: Libro, usuario: Usuario) {
        if (libro.obtenerEstado() == "prestado" && usuario.consultarLibrosPrestados().contains(libro)) {
            libro.cambiarEstado("disponible")
            registroPrestamos.devolverLibro(libro, usuario)
            usuario.quitarLibroPrestado(libro)
        }
    }

    fun consultarHistorialPrestamosLibro(libro: Libro): List<Triple<Libro, Usuario, LocalDateTime>> {
        return registroPrestamos.consultarHistorialPrestamosLibro(libro)
    }

    fun consultarHistorialPrestamosUsuario(usuario: Usuario): List<Triple<Libro, Usuario, LocalDateTime>> {
        return registroPrestamos.consultarHistorialPrestamosUsuario(usuario)
    }

    fun consultarCatalogo(): List<Libro> {
        return catalogo.toList()
    }
}