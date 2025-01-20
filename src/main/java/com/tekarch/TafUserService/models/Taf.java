package com.tekarch.TafUserService.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data

public class Taf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tafId;

    @Column(name = "flight_number", nullable = false, unique = true, length = 20)
    private String tafFlightNumber;

    @Column(name = "departure_time", nullable = false, length = 50)
    private String tafDeparture;

    @Column(name = "arrival_time", nullable = false, length = 50)
    private String tafArrivalTime;

    @Column(name = "price", columnDefinition = "VARCHAR(10) DEFAULT 'USD'")
    private String tafPrice;

    @Column(name = "available_seats", columnDefinition = "VARCHAR(10) DEFAULT 'USD'")
    private String tafAvailableSeats;


    @Column(name = "created_at",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist()
    {
        this.createdAt= LocalDateTime.now();

    }
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}