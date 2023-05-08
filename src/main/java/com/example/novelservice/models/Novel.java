package com.example.novelservice.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Novel extends Base {
  private String title;
  private String description;
  @Enumerated(EnumType.STRING) private Genre genre;

  // Relations

  @OneToMany(mappedBy = "novel", cascade = CascadeType.ALL)
  private List<Chapter> chapters = new ArrayList<Chapter>();

  public Novel() {}

  public Novel(String title, String description, Genre genre) {
    this.title = title;
    this.description = description;
    this.genre = genre;
  }

  public String getTitle() { return title; }

  public String getDescription() { return description; }

  public Genre getGenre() { return genre; }

  public List<Chapter> getChapters() { return this.chapters; }
}
