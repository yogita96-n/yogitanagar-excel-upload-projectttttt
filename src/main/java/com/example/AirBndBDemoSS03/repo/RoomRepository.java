package com.example.AirBndBDemoSS03.repo;

import com.example.AirBndBDemoSS03.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("select r from Room r where r.property.id=:property and r.roomType=:type and r.date=:date")
    Room findByPropertyAndRoomTypeAndDate(
            @Param("property") long propertyId,
            @Param("type") String roomType,
            @Param("date") LocalDate Date);
}