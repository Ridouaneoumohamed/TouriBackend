package com.example.touriste.Repositories;

import com.example.touriste.Entities.Activite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiviteRepository extends JpaRepository<Activite ,Long> {
}
