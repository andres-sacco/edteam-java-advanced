package com.edteam.reservations.model;

import java.math.BigDecimal;
import java.util.Objects;

public class PriceDTO {

    private Long id;

    private BigDecimal totalPrice;

    private BigDecimal totalTax;

    private BigDecimal basePrice;

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(BigDecimal totalTax) {
        this.totalTax = totalTax;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PriceDTO{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", totalTax=" + totalTax +
                ", basePrice=" + basePrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PriceDTO priceDTO = (PriceDTO) o;
        return Objects.equals(id, priceDTO.id) && Objects.equals(totalPrice, priceDTO.totalPrice) && Objects.equals(totalTax, priceDTO.totalTax) && Objects.equals(basePrice, priceDTO.basePrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalPrice, totalTax, basePrice);
    }
}
