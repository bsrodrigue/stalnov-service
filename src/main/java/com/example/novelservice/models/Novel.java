package com.example.novelservice.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
public class Novel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long Id;

    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private Date createdAt;

    public Novel() {
    }

    public Novel(String title, String description, Genre genre) {
        this.title = title;
        this.description = description;
        this.genre = genre;
    }

    public Long getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Genre getGenre() {
        return genre;
    }
}
