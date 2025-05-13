package com.edteam.reservations.module.one;

import com.edteam.reservations.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class OptionalExercises {

    // Ejercicio 1: Obtener totalPrice de una reserva
    public BigDecimal obtenerTotalPrice(ReservationDTO reserva) {
        if (reserva != null && reserva.getItinerary() != null && reserva.getItinerary().getPrice() != null) {
            return reserva.getItinerary().getPrice().getTotalPrice();
        }
        return BigDecimal.ZERO;
    }

    public BigDecimal obtenerTotalPriceSeguro(ReservationDTO reserva) {
        return Optional.ofNullable(reserva)
                .map(ReservationDTO::getItinerary)
                .map(ItineraryDTO::getPrice)
                .map(PriceDTO::getTotalPrice)
                .orElse(BigDecimal.ZERO);
    }

    // Ejercicio 2: Obtener email del primer pasajero
    public String obtenerEmailPrimerPasajero(ReservationDTO reserva) {
        if (reserva != null && reserva.getPassengers() != null && !reserva.getPassengers().isEmpty()) {
            PassengerDTO pasajero = reserva.getPassengers().get(0);
            if (pasajero.getEmail() != null) {
                return pasajero.getEmail();
            }
        }
        return "sin-email";
    }

    // Ejercicio 3: Obtener el ID del primer segmento
    public Long obtenerPrimerSegmentoId(ItineraryDTO itinerary) {
        if (itinerary != null && itinerary.getSegment() != null && !itinerary.getSegment().isEmpty()) {
            return itinerary.getSegment().get(0).getId();
        }
        return null;
    }

    // Ejercicio 4: Obtener apellido de un pasajero
    public String obtenerApellido(PassengerDTO pasajero) {
        if (pasajero != null && pasajero.getLastName() != null) {
            return pasajero.getLastName();
        }
        return "Desconocido";
    }

    public String obtenerApellidoSeguro(PassengerDTO pasajero) {
        return Optional.ofNullable(pasajero)
                .map(PassengerDTO::getLastName)
                .orElse("Desconocido");
    }

    // Ejercicio 5: Verificar si el número de documento está presente
    public boolean documentoPresente(PassengerDTO pasajero) {
        return pasajero != null && pasajero.getDocumentNumber() != null;
    }

    public boolean documentoPresenteSeguro(PassengerDTO pasajero) {
        return Optional.ofNullable(pasajero)
                .map(PassengerDTO::getDocumentNumber)
                .isPresent();
    }

    // Ejercicio 6: Obtener fecha de creación
    public LocalDate obtenerFechaCreacion(ReservationDTO reserva) {
        if (reserva != null && reserva.getCreationDate() != null) {
            return reserva.getCreationDate();
        }
        return LocalDate.now();
    }

    // Ejercicio 7: Verificar si hay precio base
    public boolean hayPrecioBase(ItineraryDTO itinerary) {
        return itinerary != null &&
                itinerary.getPrice() != null &&
                itinerary.getPrice().getBasePrice() != null;
    }

    // Ejercicio 8: Obtener basePrice obligatorio
    public BigDecimal obtenerBasePriceObligatorio(ReservationDTO reserva) {
        if (reserva == null || reserva.getItinerary() == null || reserva.getItinerary().getPrice() == null) {
            throw new IllegalStateException("Falta el precio base en la reserva");
        }
        return reserva.getItinerary().getPrice().getBasePrice();
    }

    public BigDecimal obtenerBasePriceObligatorioSeguro(ReservationDTO reserva) {
        return Optional.ofNullable(reserva)
                .map(ReservationDTO::getItinerary)
                .map(ItineraryDTO::getPrice)
                .map(PriceDTO::getBasePrice)
                .orElseThrow(()-> new IllegalStateException("Falta el precio base en la reserva"));
    }

    // Ejercicio 9: Usar orElseGet para valor por defecto calculado
    public LocalDate obtenerFechaConGenerador(ReservationDTO reserva) {
        if (reserva != null && reserva.getCreationDate() != null) {
            return reserva.getCreationDate();
        }
        return LocalDate.now();
    }

    // Ejercicio 10: Usar ifPresent para ejecutar acción condicional
    public void imprimirEmailPasajero(PassengerDTO pasajero) {
        if (pasajero != null && pasajero.getEmail() != null) {
            System.out.println("Email del pasajero: " + pasajero.getEmail());
        }
    }
}
