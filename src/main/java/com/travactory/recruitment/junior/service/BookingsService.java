package com.travactory.recruitment.junior.service;

import java.time.Duration;
import java.util.List;

import com.travactory.recruitment.junior.dto.BookingDTO;
import com.travactory.recruitment.junior.model.*;
import com.travactory.recruitment.junior.repository.AirportsRepository;
import com.travactory.recruitment.junior.repository.CustomersRepository;
import com.travactory.recruitment.junior.utils.LocalDateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travactory.recruitment.junior.repository.BookingsRepository;

import javax.transaction.Transactional;

@Service
public class BookingsService {

    private final BookingsRepository bookingsRepository;
    private final AirportsRepository airportsRepository;
    private final CustomersRepository customersRepository;

    @Autowired
    public BookingsService(final BookingsRepository bookingsRepository, final AirportsRepository airportsRepository,
                           final CustomersRepository customersRepository) {
        this.bookingsRepository = bookingsRepository;
        this.airportsRepository = airportsRepository;
        this.customersRepository = customersRepository;
    }

    public Booking getBookingById(final Integer id) {
        return this.bookingsRepository.findOne(id);
    }

    public FlightDuration calculateFlightDuration(final Integer bookingId) {
        final Booking booking = this.getBookingById(bookingId);

        final Duration duration = Duration.between(
                LocalDateTimeFormatter.getLocalDateTimeWithOffSet(booking.getDepartureDate(),
                        booking.getDestination().getGmtTimeZoneOffset()),
                LocalDateTimeFormatter.getLocalDateTimeWithOffSet(booking.getArrivalDate(),
                        booking.getDeparture().getGmtTimeZoneOffset())
                );

        return new FlightDuration(
                duration.toDays(),
                duration.toHours() % 24,
                duration.toMinutes() % 60);
    }

    public BookingPrice calculateBookingPrice(final Integer bookingId) {
        final Booking booking = this.getBookingById(bookingId);

        return new BookingPrice(
                booking.getPassengers(),
                booking.getPassengerPrice(),
                booking.getPassengers() * booking.getPassengerPrice());
    }

    public List<Booking> getAllBookings() {
        return this.bookingsRepository.findAll();
    }

    @Transactional
    public void saveBooking(final BookingDTO bookingDTO) {
        this.bookingsRepository.save(this.createBookingFromBookingDTO(bookingDTO));
    }

    private Booking createBookingFromBookingDTO(BookingDTO bookingDTO) {
        final Airport departureAirport = this.airportsRepository.findOne(bookingDTO.getDepartureAirportId());
        if (departureAirport == null) {
            throw new RuntimeException(String.format("Airport with %s id doesn't exist",
                    bookingDTO.getDepartureAirportId()));
        }
        final Airport destinationAirport = this.airportsRepository.findOne(bookingDTO.getDestinationAirportId());
        if (destinationAirport == null) {
            throw new RuntimeException(String.format("Destination Airport with %s id doesn't exist",
                    bookingDTO.getDestinationAirportId()));
        }
        final Customer customer = this.customersRepository.findOne(bookingDTO.getCustomerId());
        if (customer == null) {
            throw new RuntimeException(String.format("Customer with %s id doesn't exist",
                    bookingDTO.getCustomerId()));
        }
        return this.transformDtoToBooking(bookingDTO, customer, destinationAirport, departureAirport);
    }
    private Booking transformDtoToBooking(BookingDTO bookingDTO, Customer customer, Airport destinationAirport,
                                          Airport departureAirport) {
        Booking booking = new Booking();
        booking.setDeparture(departureAirport);
        booking.setDestination(destinationAirport);
        booking.setArrivalDate(bookingDTO.getArrivalDate());
        booking.setCustomer(customer);
        booking.setPassengers(bookingDTO.getPassengers());
        booking.setPassengerPrice(bookingDTO.getPassengerPrice());
        booking.setClassType(bookingDTO.getClassType());
        booking.setDepartureDate(bookingDTO.getDepartureDate());
        return booking;
    }
}
