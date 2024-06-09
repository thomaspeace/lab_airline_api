package com.example.airline_api.components;

import com.example.airline_api.models.Booking;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.BookingRepository;
import com.example.airline_api.services.FlightService;
import com.example.airline_api.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightService flightService;

    @Autowired
    PassengerService passengerService;

//    Using BookingRepository BookingService only has the ability to
//    add a booking with BookingDTO.
    @Autowired
    BookingRepository bookingRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception{

        Passenger tom = new Passenger("Tom", "tom@email.com");
        Passenger portia = new Passenger("Portia", "portia@email.com");
        Passenger ryan = new Passenger("Ryan", "ryan@email.com");

        Flight londonToMadrid = new Flight("Madrid", 200, "25/12/2024", "1200");
        Flight londonToParis = new Flight("Paris", 220, "29/11/2024", "1300");

        Booking tomToMadrid = new Booking(londonToMadrid, tom, 24);
        Booking portiaToMadrid = new Booking(londonToMadrid, portia, 25);
        Booking tomToParis = new Booking(londonToParis, tom, 75);
        Booking ryanToParis = new Booking(londonToParis, ryan, 31);

        passengerService.addNewPassenger(tom);
        passengerService.addNewPassenger(portia);
        passengerService.addNewPassenger(ryan);

        flightService.addNewFlight(londonToMadrid);
        flightService.addNewFlight(londonToParis);

        bookingRepository.save(tomToMadrid);
        bookingRepository.save(portiaToMadrid);
        bookingRepository.save(tomToParis);
        bookingRepository.save(ryanToParis);

    }
}
