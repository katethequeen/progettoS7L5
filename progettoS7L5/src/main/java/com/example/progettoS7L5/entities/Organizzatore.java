package com.example.progettoS7L5.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "organizzatori")
public class Organizzatore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 3, max = 50)
    private String title;
    @NotBlank
    private String description;
    @NotNull
    private LocalDateTime date;
    @NotBlank
    private String location;
    @NotNull
    private Integer seatsAvailable;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private User organizer;
}
