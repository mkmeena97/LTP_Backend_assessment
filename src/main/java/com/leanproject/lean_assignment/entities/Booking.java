package com.leanproject.lean_assignment.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int booking_id;
    int consultant_id;
    int client_id;
    int slot_id;
    Date booking_date;
    Date booking_time;
    
    public Booking() {
    }

    public Booking(int booking_id, int consultant_id, int client_id, int slot_id, Date booking_date,
            Date booking_time) {
        this.booking_id = booking_id;
        this.consultant_id = consultant_id;
        this.client_id = client_id;
        this.slot_id = slot_id;
        this.booking_date = booking_date;
        this.booking_time = booking_time;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

}
