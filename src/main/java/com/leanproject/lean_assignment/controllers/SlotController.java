package com.leanproject.lean_assignment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leanproject.lean_assignment.entities.Slot;
import com.leanproject.lean_assignment.services.SlotService;

@RestController
public class SlotController {
    
    @Autowired
    SlotService slotServ;

    @GetMapping("/getslotdetails/{slot_id}")
    public ResponseEntity<Slot> getSlotDetails(@PathVariable("slot_id") int slot_id)
    {
        return  ResponseEntity.ofNullable(slotServ.getSlotByID(slot_id));
    }

    @GetMapping("/getavailableslots")
    public List<Slot> getAvailableSlots()
    {
        return slotServ.getAvailableSlots();
    }

    @PostMapping("/bookslot")
    public boolean bookSlot(@RequestParam("slot_id") int slot_id, @RequestParam("client_id") int client_id)
    {
        return slotServ.bookSlot(slot_id, client_id);
    }
}
