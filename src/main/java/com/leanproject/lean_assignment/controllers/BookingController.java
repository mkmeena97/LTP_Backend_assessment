package com.leanproject.lean_assignment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.leanproject.lean_assignment.entities.Booking;
import com.leanproject.lean_assignment.services.BookingService;

@RestController
public class BookingController {
    
    @Autowired
    BookingService bserv;

    @GetMapping("/getdetailsbybookingid/{booking_id}")
    public ResponseEntity<Booking> getBookingDetails(@PathVariable("booking_id") int booking_id) {
        return ResponseEntity.ofNullable(bserv.getDetailsByBookingId(booking_id));
    }

    @GetMapping("/getclientbookingdetails/{client_id}")
    public List<Booking> getClientBookingDetails(@PathVariable("client_id") int client_id) {
        return bserv.getClientBookingDetails(client_id);
    }

    @GetMapping("/getconsultantbookingdetails/{consultant_id}")
    public List<Booking> getConsultantBookingDetails(@PathVariable("consultant_id") int consultant_id) {
        return bserv.getConsultantBookingDetails(consultant_id);
    }
}
