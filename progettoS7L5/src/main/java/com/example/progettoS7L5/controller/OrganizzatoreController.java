package com.example.progettoS7L5.controller;

import com.example.progettoS7L5.entities.Organizzatore;
import com.example.progettoS7L5.entities.User;
import com.example.progettoS7L5.services.OrganizzatoreSrv;
import com.example.progettoS7L5.services.UserSrv;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class OrganizzatoreController {


        @Autowired
        private OrganizzatoreSrv organizzatoreSrv;
        @Autowired
        private UserSrv userSrv;

        @PostMapping
        public ResponseEntity<Organizzatore> createEvent(@RequestBody @Valid Organizzatore event) {
            return new ResponseEntity<>(organizzatoreSrv.createEvent(event), HttpStatus.CREATED);
        }

        @GetMapping("/organizer/{id}")
        public ResponseEntity<List<Organizzatore>> getEventsByOrganizer(@PathVariable Long id) {
            User organizer = userSrv.findUserById(id);
            return new ResponseEntity<>(organizzatoreSrv.findEventsByOrganizer(organizer), HttpStatus.OK);
        }
    }

