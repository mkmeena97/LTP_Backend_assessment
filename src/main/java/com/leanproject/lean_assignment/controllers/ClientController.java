package com.leanproject.lean_assignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leanproject.lean_assignment.entities.Client;
import com.leanproject.lean_assignment.services.ClientService;

@RestController
public class ClientController {

    @Autowired
    ClientService cserv;

    @GetMapping("/getclient")
    public Client getClient(@RequestParam("client_id") int client_id)
    {
        return cserv.getClient(client_id);
    }

    
}
