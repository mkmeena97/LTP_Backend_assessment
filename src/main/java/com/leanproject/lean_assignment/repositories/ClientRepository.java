package com.leanproject.lean_assignment.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leanproject.lean_assignment.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {

   public Optional<Client> findById(int client_id);

   @Query("select c from Client c where clientName=:client_name")
  public Optional<Client> getClientByName(String client_name); 
  
}
