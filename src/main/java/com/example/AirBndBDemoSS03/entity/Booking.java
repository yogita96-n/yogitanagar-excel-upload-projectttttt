package com.example.AirBndBDemoSS03.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "no_of_guest", nullable = false)
    private Integer noOfGuest;

    @Column(name = "no_of_nights", nullable = false)
    private Integer noOfNights;

    @Column(name = "total_price", nullable = false)
    private Double totalPrice;

    @Column(name = "check_in", nullable = false)
    private LocalDate checkIn;

    @Column(name = "check_out", nullable = false)
    private LocalDate checkOut;

    @Column(name = "guest_name", nullable = false)
    private String guestName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;
//
//    @ManyToOne
//    @JoinColumn(name = "app_user_id")
//    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

}