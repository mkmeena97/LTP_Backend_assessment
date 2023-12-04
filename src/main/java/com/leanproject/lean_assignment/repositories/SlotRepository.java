package com.leanproject.lean_assignment.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leanproject.lean_assignment.entities.Slot;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Integer> {

    @Query("Select s from Slot s where isBooked=false")
    public List<Slot> getAvailableSlots();
    
}
