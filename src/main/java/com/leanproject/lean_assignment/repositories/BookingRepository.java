package com.leanproject.lean_assignment.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leanproject.lean_assignment.entities.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{

    @Query("SELECT b FROM Booking b WHERE b.clientId = :client_id")
    public List<Booking> getClientBookingDetails(int client_id);

    @Query("SELECT b FROM Booking b WHERE b.consultantId = :consultant_id")
    public List<Booking> getConsultantBookingDetails(int consultant_id);

    
    
}
