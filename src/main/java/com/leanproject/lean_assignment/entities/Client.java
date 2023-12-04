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
    int client_id;
    @Column
    String client_name;
    @Column
    String client_email;
    @Column
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
        return "Client{" + "client_id=" + client_id + ", client_name='" + client_name + '\'' + ", client_email='" + client_email + '\'' + ", client_phone='" + client_phone + '\'' + '}';
    }


}
