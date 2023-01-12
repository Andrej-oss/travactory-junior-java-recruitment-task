package com.travactory.recruitment.junior.model;

public class BookingPrice {
    private Integer passengers;
    private Double passengerPrice;
    private Double totalPrice;

    public BookingPrice(Integer passengers, Double passengerPrice, Double totalPrice) {
        this.passengers = passengers;
        this.passengerPrice = passengerPrice;
        this.totalPrice = totalPrice;
    }

    public Integer getPassengers() {
        return this.passengers;
    }

    public Double getPassengerPrice() {
        return this.passengerPrice;
    }

    public Double getTotalPrice() {
        return this.totalPrice;
    }
}
