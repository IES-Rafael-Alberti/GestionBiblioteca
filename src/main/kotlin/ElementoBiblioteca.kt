package org.pebiblioteca

/**
 * Clase abstracta que define las propiedades y métodos comunes a todos los elementos de una biblioteca,
 * como libros, revistas, DVDs, etc.
 *
 * @property id Identificador único del elemento.
 * @property titulo Título del elemento.
 * @property estado Estado del elemento, puede ser "disponible" o "prestado".
 */

abstract class ElementoBiblioteca(
    val id: String,
    val titulo: String,
    var estado: String = "disponible"
)