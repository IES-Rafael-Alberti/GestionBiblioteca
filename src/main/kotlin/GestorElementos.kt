package org.pebiblioteca

/**
 * Clase genérica para gestionar elementos de biblioteca.
 */
class GestorElementos<T : ElementoBiblioteca> {
    private val elementos = mutableListOf<T>()

    /**
     * Agrega un elemento al gestor de elementos.
     */
    fun agregarElemento(elemento: T) {
        elementos.add(elemento)
    }

    /**
     * Elimina un elemento del gestor de elementos por su identificador.
     */
    fun eliminarElementoPorId(id: String) {
        elementos.removeAll { it.id == id }
    }

    /**
     * Retorna los elementos gestionados.
     */
    fun obtenerElementos(): List<T> {
        return elementos.toList()
    }

    /**
     * Busca elementos por diversos criterios.
     * @param criterio Función de filtrado que determina si un elemento debe ser incluido en los resultados.
     * @return Lista de elementos que cumplen con el criterio de búsqueda.
     */
    fun filtrarPorCriterio(criterio: (T) -> Boolean): List<T> {
        return elementos.filter(criterio)
    }
}