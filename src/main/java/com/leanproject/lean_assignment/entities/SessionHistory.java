package com.leanproject.lean_assignment.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sessionhistory")
public class SessionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private int sessionId;

    @ManyToOne
    @JoinColumn(name = "consultant_id")
    private Consultant consultant;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "session_date")
    private LocalDate sessionDate;

    @Column(name = "session_time")
    private LocalTime sessionTime;

    public SessionHistory() {
    }

    public SessionHistory(int sessionId, Consultant consultant, Client client, LocalDate sessionDate,
            LocalTime sessionTime) {
        this.sessionId = sessionId;
        this.consultant = consultant;
        this.client = client;
        this.sessionDate = sessionDate;
        this.sessionTime = sessionTime;
    }

    public int getSessionId() {
        return sessionId;
    }

    public Consultant getConsultant() {
        return consultant;
    }

    public Client getClient() {
        return client;
    }

    public LocalDate getSessionDate() {
        return sessionDate;
    }

    public LocalTime getSessionTime() {
        return sessionTime;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public void setConsultant(Consultant consultant) {
        this.consultant = consultant;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setSessionDate(LocalDate sessionDate) {
        this.sessionDate = sessionDate;
    }

    public void setSessionTime(LocalTime sessionTime) {
        this.sessionTime = sessionTime;
    }

    @Override
    public String toString() {
        return "SessionHistory [sessionId=" + sessionId + ", consultant=" + consultant + ", client=" + client
                + ", sessionDate=" + sessionDate + ", sessionTime=" + sessionTime + "]";
    }

    

}

