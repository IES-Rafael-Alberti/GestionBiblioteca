package org.pebiblioteca


/**
 * Clase que representa una revista en la biblioteca.
 * @property edicion Número de edición de la revista.
 * @property tematica Temática de la revista.
 */
class Revista(
    id: String,
    titulo: String,
    val edicion: Int,
    val tematica: String
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