package com.leanproject.lean_assignment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leanproject.lean_assignment.entities.SessionHistory;
import com.leanproject.lean_assignment.repositories.SessionHistoryRepository;

@Service
public class SessionHistoryService {
    
    @Autowired
    SessionHistoryRepository shrepo;

    public SessionHistory getSessionByClient(int client_id)
    {

        return shrepo.getSessionHistoryByClient(client_id);
    }

    public SessionHistory getSessionByConsultant(int consultant_id)
    {
        
        return shrepo.getSessionHistoryByConsultant(consultant_id);
    }
}
