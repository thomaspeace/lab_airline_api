package com.example.airline_api.controllers;

import com.example.airline_api.models.Passenger;
import com.example.airline_api.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    // TODO: Display details of all passengers
    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers(){
        List<Passenger> passengers = passengerService.getAllPassengers();
        return new ResponseEntity<>(passengers, HttpStatus.OK);
    }

    // TODO: Display specific passenger details
    @GetMapping(value = "/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable Long id){
        Optional<Passenger> foundPassenger = passengerService.getPassengerById(id);
        if (foundPassenger.isPresent()){
            return new ResponseEntity<>(foundPassenger.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // TODO: Add a new passenger
    @PostMapping
    public ResponseEntity<Passenger> addNewPassenger(@RequestBody Passenger passenger){
        Passenger newPassenger = passengerService.addNewPassenger(passenger);
        return new ResponseEntity<>(newPassenger, HttpStatus.OK);
    }

}
