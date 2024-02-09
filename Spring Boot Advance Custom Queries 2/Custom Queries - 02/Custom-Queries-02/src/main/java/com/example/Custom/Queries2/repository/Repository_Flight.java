package com.example.Custom.Queries2.repository;

import com.example.Custom.Queries2.entity.Flight;
import com.example.Custom.Queries2.entity.TypeFlight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Repository_Flight extends JpaRepository<Flight, Long> {

    List<Flight> findFlightByTypeFlight(TypeFlight typeFlight);

    @Query(value = "SELECT f FROM Flight f WHERE f.typeFlight = :stato1 OR f.typeFlight = :stato2")
    List<Flight> findFlyCose(@Param("stato1") TypeFlight cosa1, @Param("stato2") TypeFlight cosa2);
}
