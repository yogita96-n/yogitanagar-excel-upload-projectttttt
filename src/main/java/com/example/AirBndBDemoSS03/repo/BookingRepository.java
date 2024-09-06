package com.example.AirBndBDemoSS03.repo;

import com.example.AirBndBDemoSS03.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}