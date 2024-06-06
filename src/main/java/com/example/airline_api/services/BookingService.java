package com.example.airline_api.services;

import com.example.airline_api.models.Booking;
import com.example.airline_api.models.BookingDTO;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.BookingRepository;
import org.hibernate.property.access.internal.PropertyAccessStrategyResolverStandardImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    FlightService flightService;

    @Autowired
    PassengerService passengerService;

    public Booking addNewBooking(BookingDTO bookingDTO){
        Flight flight = flightService.getFlightById(bookingDTO.getFlightId()).get();
        Passenger passenger = passengerService.getPassengerById(bookingDTO.getPassengerId()).get();

        Booking createdBooking = new Booking(flight, passenger, bookingDTO.getSeatNumber());

        return bookingRepository.save(createdBooking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
