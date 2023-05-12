package com.example.novelservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Novel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @OneToMany(mappedBy = "novel", cascade = CascadeType.ALL)
    private ArrayList<Chapter> chapters;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonIgnore
    private User author;

    public String getAuthor() {
        return this.author.getUsername();
    }

}
