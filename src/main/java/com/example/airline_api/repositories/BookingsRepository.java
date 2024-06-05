package com.example.airline_api.repositories;

import com.example.airline_api.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingsRepository extends JpaRepository<Booking, Long> {
}
