package com.example.progettoS7L5.services;

import com.example.progettoS7L5.entities.Organizzatore;
import com.example.progettoS7L5.repositories.OrganizzatoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizzatoreSrv {
    @Autowired
    private OrganizzatoreRepo organizzatoreRepo;

    public Organizzatore createEvent(Organizzatore event) {
        return organizzatoreRepo.save(event);
    }



    public List<Organizzatore> findEventsByOrganizer(User organizer) {
        return organizzatoreRepo.findByOrganizer(organizer);
    }
}
