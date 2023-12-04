package com.leanproject.lean_assignment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leanproject.lean_assignment.entities.Booking;
import com.leanproject.lean_assignment.repositories.BookingRepository;

@Service
public class BookingService {
    
    @Autowired
    BookingRepository brepo;

    public Booking getDetailsByBookingId(int booking_id)
    {
        Booking b;
        Optional<Booking> ob = brepo.findById(booking_id);
        try{
            b = ob.get();
        }
        catch(Exception e)
        {
            b = null;
        }
        return b;
    }

    public List<Booking> getClientBookingDetails(int client_id)
    {
        List<Booking> ob = brepo.getClientBookingDetails(client_id);
         return ob;
    }

    public List<Booking> getConsultantBookingDetails(int client_id)
    {
        List<Booking> ob = brepo.getConsultantBookingDetails(client_id);
        return ob;
    }

}
