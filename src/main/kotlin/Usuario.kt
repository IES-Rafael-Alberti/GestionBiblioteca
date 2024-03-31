package org.pebiblioteca

/**
 * Clase que representa un usuario de la biblioteca.
 *
 * @property id Identificador único del usuario.
 * @property nombre Nombre del usuario.
 */

class Usuario(val id: Int, val nombre: String) {
    private val librosPrestados = mutableListOf<Libro>()

    /**
     * Agrega un libro a la lista de libros prestados del usuario.
     *
     * @param libro El libro a agregar.
     */

    fun agregarLibroPrestado(libro: Libro) {
        librosPrestados.add(libro)
    }

    /**
     * Quita un libro de la lista de libros prestados del usuario.
     *
     * @param libro El libro a quitar.
     */

    fun quitarLibroPrestado(libro: Libro) {
        librosPrestados.remove(libro)
    }

    /**
     * Consulta la lista de libros prestados por el usuario.
     *
     * @return La lista de libros prestados.
     */

    fun consultarLibrosPrestados(): List<Libro> {
        return librosPrestados.toList()
    }
}