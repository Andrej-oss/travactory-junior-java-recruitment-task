package com.travactory.recruitment.junior.dto;

import java.util.Date;

public class BookingDTO {

    private Integer departureAirportId;
    private Integer destinationAirportId;
    private Date departureDate;
    private Date arrivalDate;
    private Integer customerId;
    private Double passengerPrice;
    private Integer passengers;
    private String classType;

    public BookingDTO() {
    }

    public BookingDTO(Integer departureAirportId, Integer destinationAirportId, Date departureDate, Date arrivalDate,
                      Integer customerId, Double passengerPrice, Integer passengers, String classType) {
        this.departureAirportId = departureAirportId;
        this.destinationAirportId = destinationAirportId;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.customerId = customerId;
        this.passengerPrice = passengerPrice;
        this.passengers = passengers;
        this.classType = classType;
    }

    public Integer getDepartureAirportId() {
        return this.departureAirportId;
    }

    public void setDepartureAirportId(Integer departureAirportId) {
        this.departureAirportId = departureAirportId;
    }

    public Integer getDestinationAirportId() {
        return this.destinationAirportId;
    }

    public void setDestinationAirportId(Integer destinationAirportId) {
        this.destinationAirportId = destinationAirportId;
    }

    public Date getDepartureDate() {
        return this.departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return this.arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Integer getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Double getPassengerPrice() {
        return this.passengerPrice;
    }

    public void setPassengerPrice(Double passengerPrice) {
        this.passengerPrice = passengerPrice;
    }

    public Integer getPassengers() {
        return this.passengers;
    }

    public void setPassengers(Integer passengers) {
        this.passengers = passengers;
    }

    public String getClassType() {
        return this.classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }
}
