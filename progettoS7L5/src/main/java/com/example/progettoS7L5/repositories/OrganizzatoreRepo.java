package com.example.progettoS7L5.repositories;

import com.example.progettoS7L5.entities.Organizzatore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface OrganizzatoreRepo extends JpaRepository<Organizzatore, Long> {
    List<Organizzatore> findByOrganizer(User organizer);
}
