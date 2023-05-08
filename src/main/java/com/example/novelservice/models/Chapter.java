package com.example.novelservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Chapter extends Base {

  private String title;

  private String body;

  @ManyToOne @JoinColumn(name = "novel_id") private Novel novel;

  public Chapter() {}

  public Chapter(String title, String body) {
    this.title = title;
    this.body = body;
  }

  public String getTitle() { return title; }

  public String getBody() { return body; }

  public void setNovel(Novel novel) { this.novel = novel; }
}
