package com.travactory.recruitment.junior.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    private Airport departure;
    @ManyToOne
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

    public String getClassType() {
        String classTypeFullName;
        switch (classType) {
            case "F":
                classTypeFullName = "First";
                break;
            case "E":
                classTypeFullName = "Economy";
            case "B":
                classTypeFullName = "Business";
                break;
            default:
                classTypeFullName = "Unknown class " + classType;

        }
        return classTypeFullName;
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

    public Booking() {
    }
}
