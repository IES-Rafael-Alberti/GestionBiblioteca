package org.pebiblioteca

/**
 * Clase que gestiona la biblioteca, incluyendo la administración del catálogo de elementos y el registro de préstamos.
 * Se inyecta una instancia de Catalogo para cumplir con el principio de inversión de dependencias.
 */


/*class GestorBiblioteca(private val catalogo: Catalogo, private val gestorPrestamos: IGestorPrestamos) {

    /**
     * Realiza el préstamo de un elemento de la biblioteca a un usuario.
     */
    fun prestarElemento(elemento: Prestable, usuario: Usuario) {
        if (elemento.estado == "disponible") {
            elemento.prestar()
            gestorPrestamos.registrarPrestamo(elemento as ElementoBiblioteca, usuario)
        }
    }

    /**
     * Devuelve un elemento de la biblioteca prestado por un usuario.
     */
    fun devolverElemento(elemento: Prestable, usuario: Usuario) {
        if (elemento.estado == "prestado") {
            elemento.devolver()
            gestorPrestamos.registrarDevolucion(elemento as ElementoBiblioteca, usuario)
        }
    }
}*/
