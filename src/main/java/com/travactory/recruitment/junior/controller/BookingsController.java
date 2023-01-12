package com.travactory.recruitment.junior.controller;

import com.travactory.recruitment.junior.model.BookingPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.travactory.recruitment.junior.model.Booking;
import com.travactory.recruitment.junior.model.FlightDuration;
import com.travactory.recruitment.junior.service.BookingsService;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingsController {

    private BookingsService bookingsService;

    @Autowired
    public BookingsController(final BookingsService bookingsService) {this.bookingsService = bookingsService;}

    @GetMapping("{id}")
    public ResponseEntity<?> getBookingById(@PathVariable(name = "id") final Integer id) {
        final Booking booking = bookingsService.getBookingById(id);
        return ResponseEntity.ok(booking);
    }

    @GetMapping("{id}/duration")
    public ResponseEntity<?> calculateDuration(@PathVariable(name = "id") final Integer id) {
        final FlightDuration flightDuration = bookingsService.calculateFlightDuration(id);
        return ResponseEntity.ok(flightDuration);
    }

    @GetMapping("{id}/price")
    public ResponseEntity<?> calculatePrice(@PathVariable(name = "id") final Integer id) {
        final BookingPrice bookingPrice = bookingsService.calculateBookingPrice(id);
        return ResponseEntity.ok(bookingPrice);
    }

    @GetMapping()
    public ResponseEntity<?> getBookings() {
        final List<Booking> bookings =  this.bookingsService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }

    @PostMapping()
    public ResponseEntity<?> saveBooking(@RequestBody final Booking booking) {
        bookingsService.saveBooking(booking);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
