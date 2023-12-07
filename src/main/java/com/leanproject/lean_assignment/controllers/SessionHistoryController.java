package com.leanproject.lean_assignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.leanproject.lean_assignment.entities.SessionHistory;
import com.leanproject.lean_assignment.services.SessionHistoryService;

@RestController
public class SessionHistoryController {
    
    @Autowired
    SessionHistoryService shservice;

    @GetMapping("/getsessionhistorybyclient/{client_id}")
    public SessionHistory getSessionHistoryByClient(@PathVariable("client_id") int client_id)
    {
        return shservice.getSessionByClient(client_id);
    }

    @GetMapping("/getsessionhistorybyconsultant/{consultant_id}")
    public SessionHistory getSessionHistoryByConsultant(@PathVariable("consultant_id") int consultant_id)
    {
        return shservice.getSessionByConsultant(consultant_id);
    }


}
