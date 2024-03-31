package org.pebiblioteca

/**
 * Interfaz que especifica los métodos prestar() y devolver().
 * Se asegura que todos los tipos de elementos que pueden ser prestados implementen estos métodos.
 */

interface Prestable {
    var estado: String

    /**
     * Método para marcar el elemento como prestado.
     */

    fun prestar()

    /**
     * Método para marcar el elemento como disponible nuevamente.
     */

    fun devolver()
}