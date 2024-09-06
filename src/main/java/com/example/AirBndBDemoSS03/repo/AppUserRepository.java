package com.example.AirBndBDemoSS03.repo;

import com.example.AirBndBDemoSS03.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}