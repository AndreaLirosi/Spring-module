package com.example.Custom.Queries1.repository;

import com.example.Custom.Queries1.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FlightRepo extends JpaRepository<Flight,Long> {

   }

