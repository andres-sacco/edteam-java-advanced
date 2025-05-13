package com.edteam.reservations.module.one;

import com.edteam.reservations.model.PassengerDTO;
import com.edteam.reservations.model.PriceDTO;
import com.edteam.reservations.model.SegmentDTO;

import java.math.BigDecimal;

public class PatternMatchingExercises {


    // Ejercicio 1: Validar tipo de objeto con `instanceof` (antes y después)
    public String obtenerNombreSiPasajero(Object obj) {
        if (obj instanceof PassengerDTO) {
            PassengerDTO p = (PassengerDTO) obj;
            return p.getFirstName();
        }
        return "No es pasajero";
    }

    public String obtenerNombreSiPasajeroPattern(Object obj) {
        if (obj instanceof PassengerDTO p) {
            return p.getFirstName();
        }
        return "No es pasajero";
    }


    // Ejercicio 2: Mostrar email solo si es PassengerDTO y tiene uno
    public String mostrarEmail(Object obj) {
        if (obj instanceof PassengerDTO) {
            PassengerDTO p = (PassengerDTO) obj;
            if (p.getEmail() != null) {
                return p.getEmail();
            }
        }
        return "No disponible";
    }

    // Ejercicio 3: Mostrar nombre si es `PassengerDTO`, destino si es `SegmentDTO`
    public String mostrarInfo(Object obj) {
        if (obj instanceof PassengerDTO) {
            PassengerDTO p = (PassengerDTO) obj;
            return "Pasajero: " + p.getFirstName();
        } else if (obj instanceof SegmentDTO) {
            SegmentDTO s = (SegmentDTO) obj;
            return "Segmento a: " + s.getDestination();
        }
        return "Desconocido";
    }

    public String mostrarInfoPattern(Object obj) {
        return switch (obj) {
            case PassengerDTO p -> "Pasajero: " + p.getFirstName();
            case SegmentDTO s -> "Segmento a: " + s.getDestination();
            default -> "Desconocido";
        };
    }

    // Ejercicio 4: Obtener total si es PriceDTO, si no, null
    public BigDecimal obtenerTotal(Object obj) {
        if (obj instanceof PriceDTO) {
            return ((PriceDTO) obj).getTotalPrice();
        }
        return null;
    }

    // Ejercicio 5: Validar tipo y atributo con `&&`
    public boolean pasajeroConEmail(Object obj) {
        if (obj instanceof PassengerDTO) {
            PassengerDTO p = (PassengerDTO) obj;
            return p.getEmail() != null && !p.getEmail().isEmpty();
        }
        return false;
    }

    // Ejercicio 6: `switch` por tipo con múltiples casos
    public String tipoEntidad(Object obj) {
        if (obj instanceof PassengerDTO) return "Pasajero";
        if (obj instanceof SegmentDTO) return "Segmento";
        if (obj instanceof PriceDTO) return "Precio";
        return "Otro";
    }

    // Ejercicio 7: Validar tipo y atributo con `switch` y `when`
    public String validarTipo(Object obj) {
        if (obj instanceof PassengerDTO) {
            PassengerDTO p = (PassengerDTO) obj;
            if (p.getFirstName() != null && p.getFirstName().startsWith("A")) {
                return "Pasajero con A";
            }
        }
        return "Otro";
    }

    public String validarTipoPattern(Object obj) {
        return switch (obj) {
            case PassengerDTO p when p.getFirstName() != null && p.getFirstName().startsWith("A") -> "Pasajero con A";
            default -> "Otro";
        };
    }
}
