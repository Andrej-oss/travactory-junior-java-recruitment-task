package com.travactory.recruitment.junior.service;

import java.time.Duration;
import java.time.ZoneOffset;
import java.util.List;

import com.travactory.recruitment.junior.model.BookingPrice;
import com.travactory.recruitment.junior.repository.AirportsRepository;
import com.travactory.recruitment.junior.utils.LocalDateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travactory.recruitment.junior.model.Booking;
import com.travactory.recruitment.junior.model.FlightDuration;
import com.travactory.recruitment.junior.repository.BookingsRepository;

import javax.transaction.Transactional;

@Service
public class BookingsService {

    private BookingsRepository bookingsRepository;
    private AirportsRepository airportsRepository;

    @Autowired
    public BookingsService(final BookingsRepository bookingsRepository, final AirportsRepository airportsRepository) {
        this.bookingsRepository = bookingsRepository;
        this.airportsRepository = airportsRepository;
    }

    public Booking getBookingById(final Integer id) {
        return bookingsRepository.findOne(id);
    }

    public FlightDuration calculateFlightDuration(final Integer bookingId) {
        final Booking booking = getBookingById(bookingId);

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
    public void saveBooking(final Booking booking) {
        this.airportsRepository.save(booking.getDeparture());
        this.airportsRepository.save(booking.getDestination());
        this.bookingsRepository.save(booking);
    }
}
