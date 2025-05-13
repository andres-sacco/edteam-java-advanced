package com.edteam.reservations.module.one;

import com.edteam.reservations.model.PassengerDTO;
import com.edteam.reservations.model.PriceDTO;
import com.edteam.reservations.model.ReservationDTO;
import com.edteam.reservations.model.SegmentDTO;

public class TextBlocksExercises {

    // Ejercicio 1: Mostrar información básica de un pasajero con `formatted`
    public String resumenPasajero(PassengerDTO p) {
        return "Nombre: " + p.getFirstName() + "\n" +
                "Apellido: " + p.getLastName() + "\n" +
                "Documento: " + p.getDocumentNumber();
    }

    public String resumenPasajeroTextBlocks(PassengerDTO p) {
        return """
               Nombre: %s
               Apellido: %s
               Documento: %s
               """.formatted(p.getFirstName(), p.getLastName(), p.getDocumentNumber());
    }

    // Ejercicio 2: Resumen de reserva con `stripIndent()
    public String resumenReserva(ReservationDTO r) {
        return "Reserva:\n" +
                "  ID: " + r.getId() + "\n" +
                "  Fecha: " + r.getCreationDate();
    }

    // Ejercicio 3: Ruta de vuelo con `formatted`
    public String rutaVuelo(SegmentDTO segment) {
        return "Vuelo de " + segment.getOrigin() + " a " + segment.getDestination();
    }

    // Ejercicio 4: Tabla de precios con `stripIndent()`
    public String tablaPrecios(PriceDTO price) {
        return "Precios:\n" +
                "  Base: " + price.getBasePrice() + "\n" +
                "  Total: " + price.getTotalPrice();
    }

    public String tablaPreciosTextBlock(PriceDTO p) {
        return """
                  Precios:
                    Base: %s
                    Total: %s
               """.stripIndent().formatted(p.getBasePrice(), p.getTotalPrice());
    }

    // Ejercicio 5: Mensaje con `translateEscapes()`
    public String mensajeConSaltos() {
        return "Línea 1\\nLínea 2\\nLínea 3";
    }

    // Ejercicio 6: Mensaje multilínea con tabulaciones (`translateEscapes()`)
    public String mensajeTabulado() {
        return "ID\\tNombre\\tApellido";
    }

    public String mensajeTabuladoTextBlock() {
        return """
               ID\\tNombre\\tApellido
               """.translateEscapes();
    }

    // Ejercicio 7: Mensaje dinámico para error con `formatted()`
    public String errorSegmento(String campo) {
        return "Error: el campo '" + campo + "' no puede ser nulo.";
    }
}
