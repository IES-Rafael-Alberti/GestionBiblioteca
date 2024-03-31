package org.pebiblioteca

/**
 * Clase que gestiona los préstamos en la biblioteca.
 */

class RegistroPrestamos : IGestorPrestamos {
    private val historialPrestamos = mutableListOf<Pair<ElementoBiblioteca, Usuario>>()

    override fun registrarPrestamo(elemento: ElementoBiblioteca, usuario: Usuario) {
        historialPrestamos.add(Pair(elemento, usuario))
    }

    override fun registrarDevolucion(elemento: ElementoBiblioteca, usuario: Usuario) {
        historialPrestamos.add(Pair(elemento, usuario))
    }

    override fun consultarHistorialPrestamos(): List<Pair<ElementoBiblioteca, Usuario>> {
        return historialPrestamos.toList()
    }
}