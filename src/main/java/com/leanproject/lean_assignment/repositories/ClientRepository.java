package com.leanproject.lean_assignment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leanproject.lean_assignment.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {

    @Query("select c from Client c where client_id=:client_id")
   public Client getClient(int client_id); 
}
