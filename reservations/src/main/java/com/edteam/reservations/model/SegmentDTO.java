package com.edteam.reservations.model;

import java.util.Objects;

public class SegmentDTO {

    private Long id;

    private String origin;

    private String destination;

    private String departure;

    private String arrival;

    private String carrier;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SegmentDTO{" +
                "id=" + id +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                ", carrier='" + carrier + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SegmentDTO that = (SegmentDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(origin, that.origin) && Objects.equals(destination, that.destination) && Objects.equals(departure, that.departure) && Objects.equals(arrival, that.arrival) && Objects.equals(carrier, that.carrier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, origin, destination, departure, arrival, carrier);
    }
}
