package org.pebiblioteca

/**
 * Representa un libro en la biblioteca.
 * @property id Identificador único del libro.
 * @property titulo Título del libro.
 * @property autor Autor del libro.
 * @property añoPublicacion Año de publicación del libro.
 * @property tematica Temática del libro.
 */

class Libro(id: String, titulo: String, autor: String, añoPublicacion: Int, tematica: String) :
    ElementoBiblioteca(id, titulo, autor, añoPublicacion, tematica), Prestable {

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