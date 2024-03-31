package org.pebiblioteca

/**
 * Clase que representa el catálogo de la biblioteca.
 * @param T Tipo de elementos en el catálogo.
 */
class Catalogo<T : ElementoBiblioteca> {
    private val elementos = mutableListOf<T>()

    /**
     * Método para agregar un elemento al catálogo.
     * @param elemento Elemento a agregar.
     */
    fun agregarElemento(elemento: T) {
        elementos.add(elemento)
    }

    /**
     * Método para eliminar un elemento del catálogo por su ID.
     * @param id ID del elemento a eliminar.
     */
    fun eliminarElementoPorId(id: String) {
        val elemento = elementos.find { it.id == id }
        elemento?.let {
            elementos.remove(it)
        }
    }

    /**
     * Método para buscar elementos en el catálogo que cumplan ciertos criterios.
     * @param criterio Criterio de búsqueda.
     * @return Lista de elementos que cumplen el criterio.
     */
    fun buscarElementosPorCriterio(criterio: (T) -> Boolean): List<T> {
        return elementos.filter(criterio)
    }

    /**
     * Método para obtener todos los elementos del catálogo.
     * @return Lista de todos los elementos del catálogo.
     */
    fun obtenerTodosLosElementos(): List<T> {
        return elementos.toList()
    }
}


