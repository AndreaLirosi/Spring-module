package com.example.springRepositories.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "car")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "modelName", nullable = false)
    private String modelName;
    @Column(name = "serialNumber", nullable = false)
    private int serialNumber;
    @Column(name = "currentPrice", nullable = true)
    private BigDecimal currentPrice;
}
