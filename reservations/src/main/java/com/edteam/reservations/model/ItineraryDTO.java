package com.edteam.reservations.model;

import java.util.List;
import java.util.Objects;

public class ItineraryDTO {

    private Long id;

    private List<SegmentDTO> segment;

    private PriceDTO price;

    public List<SegmentDTO> getSegment() {
        return segment;
    }

    public void setSegment(List<SegmentDTO> segment) {
        this.segment = segment;
    }

    public PriceDTO getPrice() {
        return price;
    }

    public void setPrice(PriceDTO price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ItineraryDTO{" +
                "id=" + id +
                ", segment=" + segment +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ItineraryDTO that = (ItineraryDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(segment, that.segment) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, segment, price);
    }
}
