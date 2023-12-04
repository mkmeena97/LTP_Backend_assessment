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
    int consultantId;
    String consultantName;
    String consultantEmail;
    String consultantPhone;
    
    public Consultant() {
    }

  
    public Consultant(int consultantId, String consultantName, String consultantEmail, String consultantPhone) {
        this.consultantId = consultantId;
        this.consultantName = consultantName;
        this.consultantEmail = consultantEmail;
        this.consultantPhone = consultantPhone;
    }




    public int getConsultantId() {
        return consultantId;
    }


    public String getConsultantName() {
        return consultantName;
    }


    public String getConsultantEmail() {
        return consultantEmail;
    }


    public String getConsultantPhone() {
        return consultantPhone;
    }


    public void setConsultantId(int consultantId) {
        this.consultantId = consultantId;
    }


    public void setConsultantName(String consultantName) {
        this.consultantName = consultantName;
    }


    public void setConsultantEmail(String consultantEmail) {
        this.consultantEmail = consultantEmail;
    }


    public void setConsultantPhone(String consultantPhone) {
        this.consultantPhone = consultantPhone;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
