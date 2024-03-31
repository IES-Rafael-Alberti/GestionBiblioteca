package org.pebiblioteca


/**
 * Clase que representa un usuario de la biblioteca.
 *
 * @property id Identificador único del usuario.
 * @property nombre Nombre del usuario.
 */

class Usuario(val id: Int, val nombre: String) {
    val elementosPrestados = mutableListOf<ElementoBiblioteca>()
}