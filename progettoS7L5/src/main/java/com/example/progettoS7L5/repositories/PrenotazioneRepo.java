package com.example.progettoS7L5.repositories;

import com.example.progettoS7L5.entities.Prenotazione;
import com.example.progettoS7L5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrenotazioneRepo extends JpaRepository<Prenotazione, Long> {
    List<Prenotazione> findByUser(User user);
}
