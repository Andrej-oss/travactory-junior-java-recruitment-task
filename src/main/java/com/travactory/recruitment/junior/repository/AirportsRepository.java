package com.travactory.recruitment.junior.repository;

import com.travactory.recruitment.junior.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportsRepository extends JpaRepository<Airport, Integer> {
}
