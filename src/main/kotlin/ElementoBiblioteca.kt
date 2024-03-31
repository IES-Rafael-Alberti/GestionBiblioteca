package org.pebiblioteca

/**
 * Clase abstracta que representa un elemento de la biblioteca.
 * @property id Identificador único del elemento.
 * @property titulo Título del elemento.
 */
abstract class ElementoBiblioteca(
    val id: String,
    val titulo: String
) {
    abstract var estado: String
}