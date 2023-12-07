package com.leanproject.lean_assignment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leanproject.lean_assignment.entities.SessionHistory;
@Repository
public interface SessionHistoryRepository extends JpaRepository<SessionHistory, Integer> {

    @Query("SELECT sh FROM SessionHistory sh WHERE sh.client=:client_id")
    public SessionHistory getSessionHistoryByClient(int client_id);

    @Query("SELECT sh FROM SessionHistory sh WHERE sh.consultant=:consultant_id")
    public SessionHistory getSessionHistoryByConsultant(int consultant_id);
    
}
