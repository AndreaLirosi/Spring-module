package com.example.Custom.Queries1.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private String fromAirport;
    private String toAirport;
    private TypeFlight typeFlight;

}
