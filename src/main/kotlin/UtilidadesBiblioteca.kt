import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class UtilidadesBiblioteca {
    companion object {
        /**
         * Genera un identificador único para cada libro nuevo agregado al catálogo.
         * @return Identificador único generado.
         */
        fun generarIdentificadorUnico(): String {
            val fechaHoraActual = LocalDateTime.now()
            val formato = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")
            val fechaHoraFormateada = fechaHoraActual.format(formato)
            return fechaHoraFormateada
        }
    }
}