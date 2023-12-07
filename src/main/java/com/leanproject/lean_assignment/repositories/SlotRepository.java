package com.leanproject.lean_assignment.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leanproject.lean_assignment.entities.Slot;

@Transactional
@Repository
public interface SlotRepository extends JpaRepository<Slot, Integer> {

    @Query("Select s from Slot s where isBooked=false")
    public List<Slot> getAvailableSlots();

    
    @Modifying
    @Query("UPDATE Slot s SET s.clientId = :client_id, s.isBooked = true WHERE s.slotId = :slot_id AND s.isBooked = false")
    public int bookSlot(int slot_id, int client_id);
    
}
