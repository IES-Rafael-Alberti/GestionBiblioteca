package org.pebiblioteca

/**
 * Clase que gestiona el catálogo de elementos de la biblioteca.
 */
class Catalogo {
    private val gestorElementos = GestorElementos<ElementoBiblioteca>()

    /**
     * Agrega un elemento al catálogo de la biblioteca.
     */
    fun agregarElemento(elemento: ElementoBiblioteca) {
        gestorElementos.agregarElemento(elemento)
    }

    /**
     * Elimina un elemento del catálogo por su identificador.
     */
    fun eliminarElementoPorId(id: String) {
        gestorElementos.eliminarElementoPorId(id)
    }

    /**
     * Retorna los elementos del catálogo.
     */
    fun obtenerElementos(): List<ElementoBiblioteca> {
        return gestorElementos.obtenerElementos()
    }

    /**
     * Busca elementos en el catálogo por diversos criterios.
     * @param criterio Función de filtrado que determina si un elemento debe ser incluido en los resultados.
     * @return Lista de elementos que cumplen con el criterio de búsqueda.
     */
    fun buscarElementosPorCriterio(criterio: (ElementoBiblioteca) -> Boolean): List<ElementoBiblioteca> {
        return gestorElementos.filtrarPorCriterio(criterio)
    }
}
