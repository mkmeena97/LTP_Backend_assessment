package com.leanproject.lean_assignment.entities;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int client_id;
    String client_name;
    String client_email;
    String client_phone;

    public Client(){
        super();

    }

    public Client(int client_id,String client_name,String client_email,String client_phone){
        super();
        this.client_id = client_id;
        this.client_name = client_name;
        this.client_email = client_email;
        this.client_phone = client_phone;
    }
    @Override
    public String toString() {
        return super.toString();
    }

}
