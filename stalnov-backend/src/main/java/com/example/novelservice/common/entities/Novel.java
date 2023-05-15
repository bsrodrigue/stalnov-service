package com.example.novelservice.common.entities;

import com.example.novelservice.auth.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Novel extends BaseEntity {
    @NotNull
    private String title;
    @NotNull
    private String description;

    private String coverUrl;

    private boolean isMature;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Genre genre;

    @Enumerated(EnumType.STRING)
    @NotNull
    private NovelStatus status;

    @OneToMany(mappedBy = "novel", cascade = CascadeType.ALL)
    private List<Chapter> chapters;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonIgnore
    private User author;

}
