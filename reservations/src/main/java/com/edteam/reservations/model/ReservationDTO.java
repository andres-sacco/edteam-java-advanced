package com.edteam.reservations.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class ReservationDTO {

    private Long id;

    private List<PassengerDTO> passengers;

    private ItineraryDTO itinerary;

    private LocalDate creationDate;

    public List<PassengerDTO> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengerDTO> passengers) {
        this.passengers = passengers;
    }

    public ItineraryDTO getItinerary() {
        return itinerary;
    }

    public void setItinerary(ItineraryDTO itinerary) {
        this.itinerary = itinerary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "id=" + id +
                ", passengers=" + passengers +
                ", itinerary=" + itinerary +
                ", creationDate=" + creationDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ReservationDTO that = (ReservationDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(passengers, that.passengers) && Objects.equals(itinerary, that.itinerary) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, passengers, itinerary, creationDate);
    }
}
