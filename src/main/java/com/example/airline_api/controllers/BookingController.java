package com.example.airline_api.controllers;

import com.example.airline_api.models.Booking;
import com.example.airline_api.models.BookingDTO;
import com.example.airline_api.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    BookingService bookingService;

    // TODO: Display all bookings
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings(){
        List<Booking> bookings = bookingService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    // TODO: Add details of a new booking
    @PostMapping
    public ResponseEntity<Booking> addNewBooking(@RequestBody BookingDTO bookingDTO){
        Booking newBooking = bookingService.addNewBooking(bookingDTO);
        return new ResponseEntity<>(newBooking, HttpStatus.CREATED);
    }

    // GET BOOKING BY ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable long id) {
        Optional<Booking> optionalBooking = bookingService.getBookingById(id);
        if (optionalBooking.isPresent()) {
            return new ResponseEntity<>(optionalBooking.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

//    // TODO: Extension - Update passenger meal preference
//    @PatchMapping
//    public ResponseEntity<Booking> updateMealPreference(long id, String newMeal){
//        Optional<Booking> optionalBooking = bookingService.get;
//    }

}
