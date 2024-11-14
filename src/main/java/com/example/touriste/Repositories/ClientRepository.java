package com.example.touriste.Repositories;

import com.example.touriste.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client ,Long> {
}
