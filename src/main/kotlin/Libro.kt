package org.pebiblioteca

/**
 * Representa un libro en la biblioteca.
 * @property id Identificador único del libro.
 * @property titulo Título del libro.
 * @property autor Autor del libro.
 * @property añoPublicacion Año de publicación del libro.
 * @property tematica Temática del libro.
 */

class Libro(id: String, titulo: String, var autor: String, var añoPublicacion: Int, var tematica: String) :
    ElementoBiblioteca(id, titulo), Prestable {

    override fun prestar() {
        if (estado == "disponible") {
            estado = "prestado"
        }
    }

    override fun devolver() {
        if (estado == "prestado") {
            estado = "disponible"
        }
    }
}