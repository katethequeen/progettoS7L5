package com.example.progettoS7L5.services;

import com.example.progettoS7L5.entities.Prenotazione;
import com.example.progettoS7L5.entities.User;
import com.example.progettoS7L5.repositories.PrenotazioneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneSrv {
    @Autowired
    private PrenotazioneRepo prenotazioneRepo;

    public Prenotazione createBooking(Prenotazione booking) {
        return prenotazioneRepo.save(booking);
    }
    public List<Prenotazione> findBookingsByUser(User user) {
        return prenotazioneRepo.findByUser(user);
    }
    public void deleteBooking(Long bookingId) {
        prenotazioneRepo.deleteById(bookingId);
    }
}
