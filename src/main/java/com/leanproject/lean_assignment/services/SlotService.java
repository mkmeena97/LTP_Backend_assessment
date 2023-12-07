package com.leanproject.lean_assignment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leanproject.lean_assignment.entities.Slot;
import com.leanproject.lean_assignment.repositories.SlotRepository;

@Service
public class SlotService {

    @Autowired
    SlotRepository srepo;
    
    public Slot getSlotByID(int slot_id)
    {
        Slot s;
        Optional<Slot> os = srepo.findById(slot_id);
        try{
            s = os.get();
        }
        catch(Exception e)
        {
            s = null;
        }
        return s;
    }

    public List<Slot> getAvailableSlots()
    {
        List<Slot> os = srepo.getAvailableSlots();
        return os;
    }

    public boolean bookSlot(int slot_id, int client_id)
    {
        int slot = srepo.bookSlot(slot_id, client_id);
        if(slot>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
