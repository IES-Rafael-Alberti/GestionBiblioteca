package org.pebiblioteca

class Usuario(val id: Int, val nombre: String) {
    private val librosPrestados = mutableListOf<Libro>()

    fun agregarLibroPrestado(libro: Libro) {
        librosPrestados.add(libro)
    }

    fun quitarLibroPrestado(libro: Libro) {
        librosPrestados.remove(libro)
    }

    fun consultarLibrosPrestados(): List<Libro> {
        return librosPrestados.toList()
    }
}