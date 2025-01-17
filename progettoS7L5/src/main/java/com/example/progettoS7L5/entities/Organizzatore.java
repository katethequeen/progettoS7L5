package com.example.progettoS7L5.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "organizzatori")
public class Organizzatore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Integer seats;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User organizer;
}
