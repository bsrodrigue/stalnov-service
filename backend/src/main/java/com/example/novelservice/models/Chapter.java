package com.example.novelservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Chapter {

    @Id
    @GeneratedValue
    private Long Id;

    private String title;
    private String body;

    @ManyToOne
    @JoinColumn(name = "novel_id")
    private Novel novel;
}
