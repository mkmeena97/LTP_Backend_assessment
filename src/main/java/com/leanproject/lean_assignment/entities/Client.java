package com.leanproject.lean_assignment.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    int clientId;
    @Column
    String clientName;
    @Column
    String clientEmail;
    @Column
    String clientPhone;

    public Client(){
        super();

    }

    

    public Client(int clientId, String clientName, String clientEmail, String clientPhone) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.clientPhone = clientPhone;
    }



    public int getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    @Override
    public String toString() {
        return "Client{" + "client_id=" + clientId + ", client_name='" + clientName + '\'' + ", client_email='" + clientEmail + '\'' + ", client_phone='" + clientPhone + '\'' + '}';
    }
}
