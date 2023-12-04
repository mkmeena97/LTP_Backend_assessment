package com.leanproject.lean_assignment.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "consultant")
public class Consultant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int consultant_id;
    String consultant_name;
    String consultant_email;
    String consultant_phone;
    
    public Consultant() {
    }

    public Consultant(int consultant_id, String consultant_name, String consultant_email, String consultant_phone) {
        this.consultant_id = consultant_id;
        this.consultant_name = consultant_name;
        this.consultant_email = consultant_email;
        this.consultant_phone = consultant_phone;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
