package com.leanproject.lean_assignment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leanproject.lean_assignment.entities.Client;
import com.leanproject.lean_assignment.repositories.ClientRepository;

@Service
public class ClientService {
    @Autowired
    ClientRepository crepo;

    public Client getClient(int client_id)
    {
        return crepo.getClient(client_id);
    }

}
