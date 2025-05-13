package com.edteam.reservations.module.one;

import com.edteam.reservations.model.*;

import java.math.BigDecimal;

public class SwitchExpressionsExercises {

    // Ejercicio 1: Categorizar la aerolínea por nombre
    public String categoriaAereolinea(SegmentDTO segmento) {
        if (segmento == null || segmento.getCarrier() == null) return "Desconocida";
        String carrier = segmento.getCarrier();
        switch (carrier) {
            case "AR": return "Aerolíneas Argentinas";
            case "LA": return "Latam";
            case "G3": return "Gol";
            default: return "Otra";
        }
    }

    public String categoriaAereolineaSwitch(SegmentDTO segmento) {
        String carrier = segmento == null ? null : segmento.getCarrier();

        assert segmento != null;
        return switch(segmento.getCarrier()) {
            case "AR" -> "Aerolíneas Argentinas";
            case "LA" -> "Latam";
            case "G3" -> "Gol";
            default -> "Otra";
        };
    }

    // Ejercicio 2: Clasificar cantidad de pasajeros en la reserva
    public String clasificarReservaPorPasajeros(ReservationDTO reserva) {
        if (reserva == null || reserva.getPassengers() == null) return "Vacía";
        int cantidad = reserva.getPassengers().size();
        switch (cantidad) {
            case 0: return "Vacía";
            case 1: return "Individual";
            case 2: return "Doble";
            default: return "Grupo";
        }
    }

    // Ejercicio 3: Calcular zona de destino del primer segmento
    public String zonaDestino(ItineraryDTO itinerario) {
        if (itinerario == null || itinerario.getSegment() == null || itinerario.getSegment().isEmpty()) return "Desconocida";
        String destino = itinerario.getSegment().get(0).getDestination();
        switch (destino) {
            case "EZE": return "Argentina";
            case "SCL": return "Chile";
            case "GRU": return "Brasil";
            default: return "Internacional";
        }
    }

    // Ejercicio 4: Categorizar horario de salida
    public String clasificarHorarioSalida(SegmentDTO segmento) {
        if (segmento == null || segmento.getDeparture() == null) return "Sin horario";
        String hora = segmento.getDeparture().substring(0, 2);
        switch (hora) {
            case "06": case "07": case "08": return "Mañana";
            case "12": case "13": case "14": return "Mediodía";
            case "18": case "19": case "20": return "Tarde";
            default: return "Otro";
        }
    }

    public String clasificarHorarioSalidaSwitch(SegmentDTO segmento) {
        if (segmento == null || segmento.getDeparture() == null) return "Sin horario";
        String hora = segmento.getDeparture().substring(0, 2);
        return switch (hora) {
            case "06", "07", "08", "09", "10" -> "Mañana";
            case "12", "13", "14" -> "Mediodía";
            case "18", "19", "20" -> "Tarde";
            case null, default -> "Otro";
        };
    }

    // Ejercicio 5: Categorizar tipo de documento
    public String categoriaDocumento(PassengerDTO pasajero) {
        if (pasajero == null || pasajero.getDocumentType() == null) return "ND";
        switch (pasajero.getDocumentType()) {
            case "DNI": return "Nacional";
            case "PAS": return "Internacional";
            default: return "Otro";
        }
    }

    // Ejercicio 6: Clasificar precio total
    public String clasificarPrecio(PriceDTO precio) {
        if (precio == null || precio.getTotalPrice() == null) return "ND";
        BigDecimal valor = precio.getTotalPrice();
        switch (valor.intValue()) {
            case 0 -> { return "Gratis"; }
            case 1, 2, 3 -> { return "Muy económico"; }
            default -> { return "Con costo"; }
        }
    }

    // Ejercicio 7: Tipo de trayecto según origen y destino
    public String tipoTrayecto(SegmentDTO segmento) {
        if (segmento == null || segmento.getOrigin() == null || segmento.getDestination() == null) return "Desconocido";
        if (segmento.getOrigin().equals(segmento.getDestination())) return "Local";
        return "Nacional o Internacional";
    }

    public String tipoTrayectoSwitch(SegmentDTO segmento) {
        if (segmento == null || segmento.getOrigin() == null || segmento.getDestination() == null) return "Desconocido";

        return switch (segmento.getOrigin().equals(segmento.getDestination())) {
            case true -> "Local";
            case false -> "Nacional o Internacional";
        };
    }
}
