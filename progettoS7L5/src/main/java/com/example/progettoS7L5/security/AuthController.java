package com.example.progettoS7L5.security;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AppUserSrv appUserSrv;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterReq registerRequest) {
        appUserSrv.registerUser(
                registerRequest.getUsername(),
                registerRequest.getPassword(),
                Set.of(Role.UTENTE_NORMALE) // Assegna il ruolo di default
        );
        return ResponseEntity.ok("Registrazione avvenuta con successo");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginReq loginRequest) {
        String token = appUserSrv.authenticateUser(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        );
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
