package com.example.AirBndBDemoSS03.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "count")
    private int count;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "price", nullable = false)
    private Double price;
@Setter
@Getter
    @ManyToOne
    @JoinColumn(name="property_id")
    private Property property;

}