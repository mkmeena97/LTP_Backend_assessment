package com.leanproject.lean_assignment.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leanproject.lean_assignment.entities.Client;
import com.leanproject.lean_assignment.repositories.ClientRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {
    @Autowired
    ClientRepository crepo;

    public Client getClient(int client_id) {
        Client c;
        Optional<Client> optionalClient = crepo.findById(client_id);
        try{
            c = optionalClient.get();
        }
        catch(Exception e)
        {
            c=null;
        }
        return c;
    }
    public Client getClientByName(String client_name) {
       Client c;
       Optional<Client> cl = crepo.getClientByName(client_name);
       try{
        c = cl.get();
       }
       catch(Exception e)
       {
        c=null;
       }
       return c;
    }
}


