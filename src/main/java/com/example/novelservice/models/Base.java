package com.example.novelservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

@Entity
public abstract class Base {
  @jakarta.persistence.Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long Id;

  @Column(name = "created_at")
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;

  @Column(name = "modified_at")
  @Temporal(TemporalType.TIMESTAMP)
  private Date modifiedAt;

  public Base() {}

  public Long getId() { return this.Id; }

  public Date getCreatedAt() { return this.createdAt; }

  @PrePersist
  public void setCreatedAt() {
    this.createdAt = new Date();
  }

  @PreUpdate
  public void setModifiedAt() {
    this.modifiedAt = new Date();
  }
}
