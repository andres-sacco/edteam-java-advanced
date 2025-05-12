package com.edteam.reservations.util;

import com.edteam.reservations.model.*;
import net.datafaker.Faker;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataFakerUtil {

    private static final Faker faker = new Faker();
    private static final Random random = new Random();

    public static List<ReservationDTO> generateFakeReservations() {
        List<ReservationDTO> reservations = new ArrayList<>();
        int count = faker.number().numberBetween(5, 15);
        for (int i = 0; i < count; i++) {
            reservations.add(generateFakeReservation());
        }
        return reservations;
    }

    public static ReservationDTO generateFakeReservation() {
        ReservationDTO reservation = new ReservationDTO();
        reservation.setId(faker.number().randomNumber());
        reservation.setCreationDate(LocalDate.now().minusDays(faker.number().numberBetween(1, 365)));
        reservation.setPassengers(generateFakePassengers(faker.number().numberBetween(5, 9)));
        reservation.setItinerary(generateFakeItinerary());
        return reservation;
    }

    public static List<PassengerDTO> generateFakePassengers(int count) {
        List<PassengerDTO> passengers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            PassengerDTO passenger = new PassengerDTO();
            passenger.setId(faker.number().randomNumber());
            passenger.setFirstName(faker.name().firstName());
            passenger.setLastName(faker.name().lastName());
            passenger.setDocumentNumber(faker.idNumber().valid());
            passenger.setDocumentType(random.nextBoolean() ? "DNI" : "Pasaporte");
            passenger.setBirthday(LocalDate.now().minusYears(faker.number().numberBetween(1, 60)));
            passenger.setEmail(faker.internet().emailAddress());
            passengers.add(passenger);
        }
        return passengers;
    }

    public static List<ItineraryDTO> generateFakeItineraries(int count) {
        List<ItineraryDTO> itineraries = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            itineraries.add(generateFakeItinerary());
        }
        return itineraries;
    }

    public static ItineraryDTO generateFakeItinerary() {
        ItineraryDTO itinerary = new ItineraryDTO();
        itinerary.setId(faker.number().randomNumber());
        itinerary.setSegment(generateFakeSegments(faker.number().numberBetween(1, 4)));
        itinerary.setPrice(generateFakePrice());
        return itinerary;
    }

    public static List<SegmentDTO> generateFakeSegments(int count) {
        List<SegmentDTO> segments = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            SegmentDTO segment = new SegmentDTO();
            segment.setId(faker.number().randomNumber());
            segment.setDeparture(LocalDate.now().plusDays(faker.number().numberBetween(1, 30)).toString());
            segment.setArrival(LocalDate.now().plusDays(faker.number().numberBetween(1, 30)).toString());
            segment.setOrigin(faker.address().city());
            segment.setDestination(faker.address().city());
            segments.add(segment);
        }
        return segments;
    }

    private static PriceDTO generateFakePrice() {
        PriceDTO price = new PriceDTO();
        price.setId(faker.number().randomNumber());
        BigDecimal basePrice = BigDecimal.valueOf(faker.number().randomDouble(2, 100, 500));
        BigDecimal totalTax = basePrice.multiply(BigDecimal.valueOf(0.21));
        price.setBasePrice(basePrice);
        price.setTotalTax(totalTax);
        price.setTotalPrice(basePrice.add(totalTax));
        return price;
    }
}
