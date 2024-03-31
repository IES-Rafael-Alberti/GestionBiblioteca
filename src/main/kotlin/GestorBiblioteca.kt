package org.pebiblioteca

/**
 * Clase que gestiona la biblioteca, incluyendo la administración del catálogo de elementos y el registro de préstamos.
 *
 * @property gestorPrestamos Instancia del gestor de préstamos a utilizar.
 */

class GestorBiblioteca(private val gestorPrestamos: IGestorPrestamos) {
    val catalogo = mutableListOf<ElementoBiblioteca>()

    /**
     * Agrega un elemento al catálogo de la biblioteca.
     *
     * @param elemento Elemento a agregar.
     */

    fun agregarElemento(elemento: ElementoBiblioteca) {
        catalogo.add(elemento)
    }

    /**
     * Realiza un préstamo de un elemento a un usuario.
     *
     * @param elemento Elemento a prestar.
     * @param usuario Usuario que realiza el préstamo.
     */

    fun prestarElemento(elemento: Prestable, usuario: Usuario) {
        if (elemento.estado == "disponible") {
            elemento.prestar()
            gestorPrestamos.registrarPrestamo(elemento as ElementoBiblioteca, usuario)
        }
    }

    /**
     * Devuelve un elemento prestado por un usuario.
     *
     * @param elemento Elemento a devolver.
     * @param usuario Usuario que devuelve el elemento.
     */

    fun devolverElemento(elemento: Prestable, usuario: Usuario) {
        if (elemento.estado == "prestado") {
            elemento.devolver()
            gestorPrestamos.registrarDevolucion(elemento as ElementoBiblioteca, usuario)
        }
    }
}