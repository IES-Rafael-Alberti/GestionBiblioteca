package org.pebiblioteca

/**
 * Representa un libro en la biblioteca.
 * @property id Identificador único del libro.
 * @property titulo Título del libro.
 * @property autor Autor del libro.
 * @property añoPublicacion Año de publicación del libro.
 * @property tematica Temática del libro.
 * @property estado Estado actual del libro (disponible o prestado).
 */

class Libro(
    val id: String,
    val titulo: String,
    val autor: String,
    val añoPublicacion: Int,
    val tematica: String,
    var estado: String = "disponible"
){

    /**
     * Obtiene el identificador único del libro.
     *
     * @return El identificador único del libro.
     */

    fun obtenerId(): String {
        return id
    }

    /**
     * Obtiene el estado actual del libro.
     *
     * @return El estado actual del libro.
     */

    fun obtenerEstado(): String {
        return estado
    }

    /**
     * Cambia el estado del libro.
     *
     * @param nuevoEstado El nuevo estado del libro.
     */

    fun cambiarEstado(nuevoEstado: String) {
        estado = nuevoEstado
    }
}