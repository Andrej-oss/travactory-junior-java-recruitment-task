package com.travactory.recruitment.junior.service;

import com.travactory.recruitment.junior.model.Airport;
import com.travactory.recruitment.junior.model.Booking;
import com.travactory.recruitment.junior.model.BookingPrice;
import com.travactory.recruitment.junior.model.Customer;
import com.travactory.recruitment.junior.repository.BookingsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class BookingsServiceTest {

    private final static int BOOKING_ID = 1;
    private final static int PASSENGERS = 2;
    private final static double PASSENGER_PRICE = 145.5;
    private final static double TOTAL_PRICE = 291.0;

    @Mock
    private BookingsRepository bookingsRepository;

    @InjectMocks
    private BookingsService bookingsService;

    @Test
    public void shouldCalculateBookingPriceWhenGivenExistBookingId() {
        //given
        Mockito.doReturn(new Booking(BOOKING_ID, new Airport(), new Airport(), new Date(), new Date(), new Customer(),
                        PASSENGER_PRICE, PASSENGERS, "E")).when(bookingsRepository).findOne(Mockito.anyInt());

        //when
        BookingPrice price = this.bookingsService.calculateBookingPrice(BOOKING_ID);

        //then
        assertNotNull(price);
        assertEquals(Optional.ofNullable(price.getTotalPrice()), Optional.of(TOTAL_PRICE));
        assertEquals(Optional.ofNullable(price.getPassengerPrice()), Optional.of(PASSENGER_PRICE));
        assertEquals(Optional.ofNullable(price.getPassengers()), Optional.of(PASSENGERS));
    }
}
