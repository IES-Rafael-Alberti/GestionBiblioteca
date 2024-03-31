package org.pebiblioteca

/**
 * Interfaz que define los métodos necesarios para gestionar préstamos.
 */

interface IGestorPrestamos {

    /**
     * Registra un préstamo en el sistema.
     *
     * @param elemento Elemento prestado.
     * @param usuario Usuario que realiza el préstamo.
     * @param fecha Fecha y hora del préstamo.
     */

    fun registrarPrestamo(elemento: ElementoBiblioteca, usuario: Usuario)

    /**
     * Registra la devolución de un elemento prestado.
     *
     * @param elemento Elemento devuelto.
     * @param usuario Usuario que devuelve el elemento.
     * @param fecha Fecha y hora de la devolución.
     */

    fun registrarDevolucion(elemento: ElementoBiblioteca, usuario: Usuario)

    /**
     * Consulta el historial de préstamos en el sistema.
     *
     * @return Lista de triples con información de los préstamos (elemento, usuario, fecha).
     */

    fun consultarHistorialPrestamos(): List<Pair<ElementoBiblioteca, Usuario>>
}