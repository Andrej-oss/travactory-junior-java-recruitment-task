package com.travactory.recruitment.junior.repository;

import com.travactory.recruitment.junior.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingsRepository extends JpaRepository<Booking, Integer> {
}
