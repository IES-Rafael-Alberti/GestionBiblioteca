package org.pebiblioteca

/**
 * Programa principal para gestionar una biblioteca.
 */

fun main() {
    // Crear instancias de elementos de biblioteca
    val libro = Libro("L001", "El señor de los anillos", "J.R.R. Tolkien", 1954, "Fantasía")
    val revista = Revista("R002", "National Geographic", 2021, "Ciencia")
    val dvd = DVD("D003", "Interestelar", 169, "Ciencia ficción")

    // Crear el catálogo y agregar elementos
    val catalogo = Catalogo<ElementoBiblioteca>()
    catalogo.agregarElemento(libro)
    catalogo.agregarElemento(revista)
    catalogo.agregarElemento(dvd)

    // Mostrar los elementos del catálogo
    println("Catálogo de la biblioteca:")
    catalogo.obtenerTodosLosElementos().forEach { println("${it.titulo} - ${it.id}") }

    // Realizar préstamo y devolución de elementos
    println("\nOperaciones de préstamo y devolución:")
    val usuario = Usuario(1, "Juan")

    catalogo.buscarElementosPorCriterio { it.id == "L001" }.firstOrNull()?.let {
        println("Préstamo de ${it.titulo}")
        if (it is Prestable) {
            it.prestar()
            println("Préstamo realizado: ${it.estado}")
        }
    }

    catalogo.buscarElementosPorCriterio { it.id == "D001" }.firstOrNull()?.let {
        println("Préstamo de ${it.titulo}")
        if (it is Prestable) {
            it.prestar()
            println("Préstamo realizado: ${it.estado}")
        }
    }

    catalogo.buscarElementosPorCriterio { it.id == "LE001" }.firstOrNull()?.let {
        println("Préstamo de ${it.titulo}")
        if (it is Prestable) {
            it.prestar()
            println("Préstamo realizado: ${it.estado}")
        }
    }

    catalogo.buscarElementosPorCriterio { it.id == "R001" }.firstOrNull()?.let {
        println("Devolución de ${it.titulo}")
        if (it is Prestable) {
            it.devolver()
            println("Devolución realizada: ${it.estado}")
        }
    }

    // Búsqueda de elementos en el catálogo
    println("\nBúsqueda de elementos:")
    val resultadoBusqueda = catalogo.buscarElementosPorCriterio { it is DVD && it.genero == "Ciencia ficción" }
    resultadoBusqueda.firstOrNull()?.let { println("Se encontró un DVD de ciencia ficción: ${it.titulo}") }
}





