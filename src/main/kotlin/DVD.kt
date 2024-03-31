package org.pebiblioteca


/**
 * Clase que representa un DVD en la biblioteca.
 * @property duracion Duración en minutos del contenido del DVD.
 * @property genero Género del contenido del DVD.
 */
class DVD(
    id: String,
    titulo: String,
    val duracion: Int,
    val genero: String
) : ElementoBiblioteca(id, titulo), Prestable {
    override var estado: String = "disponible"

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