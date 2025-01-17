package com.example.progettoS7L5.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
public class AuthRunner implements ApplicationRunner {
    @Autowired
    private AppUserSrv appUserSrv;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Creazione dell'utente admin se non esiste
        Optional<AppUser> adminUser = appUserSrv.findByUsername("admin");
        if (adminUser.isEmpty()) {
            appUserSrv.registerUser("organizzatore_eventi", "adminpwd", Set.of(Role.ORGANIZZATORE_EVENTI));
        }

        // Creazione dell'utente user se non esiste
        Optional<AppUser> normalUser = appUserSrv.findByUsername("user");
        if (normalUser.isEmpty()) {
            appUserSrv.registerUser("user", "userpwd", Set.of(Role.UTENTE_NORMALE));
        }




    }
}
