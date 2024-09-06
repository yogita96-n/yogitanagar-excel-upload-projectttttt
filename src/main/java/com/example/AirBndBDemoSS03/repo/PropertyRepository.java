package com.example.AirBndBDemoSS03.repo;

import com.example.AirBndBDemoSS03.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}