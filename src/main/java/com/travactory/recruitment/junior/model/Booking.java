package com.travactory.recruitment.junior.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.PERSIST })
    @JoinColumn(name = "departure_airport_id")
    private Airport departure;
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.PERSIST })
    @JoinColumn(name = "destination_airport_id")
    private Airport destination;
    private Date departureDate;
    private Date arrivalDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private Double passengerPrice;
    private Integer passengers;
    private String classType;

    public Booking() {
    }

    public Booking(Integer id, Airport departure, Airport destination, Date departureDate, Date arrivalDate,
                   Customer customer, Double passengerPrice, Integer passengers, String classType) {
        this.id = id;
        this.departure = departure;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.customer = customer;
        this.passengerPrice = passengerPrice;
        this.passengers = passengers;
        this.classType = classType;
    }

    public Integer getId() {
        return this.id;
    }

    public Airport getDeparture() {
        return this.departure;
    }

    public Airport getDestination() {
        return this.destination;
    }

    public Date getDepartureDate() {
        return this.departureDate;
    }

    public Date getArrivalDate() {
        return this.arrivalDate;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public Double getPassengerPrice() {
        return this.passengerPrice;
    }

    public Integer getPassengers() {
        return this.passengers;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDeparture(Airport departure) {
        this.departure = departure;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setPassengerPrice(Double passengerPrice) {
        this.passengerPrice = passengerPrice;
    }

    public void setPassengers(Integer passengers) {
        this.passengers = passengers;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getClassType() {
        String classTypeFullName;
        switch (this.classType) {
            case "F":
                classTypeFullName = "First";
                break;
            case "E":
                classTypeFullName = "Economy";
                break;
            case "B":
                classTypeFullName = "Business";
                break;
            default:
                classTypeFullName = "Unknown class " + classType;

        }
        return classTypeFullName;
    }
}
