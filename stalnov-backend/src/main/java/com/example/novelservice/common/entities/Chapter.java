package com.example.novelservice.common.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Chapter extends BaseEntity {
    @NotNull
    private String title;
    private String body;

    @Enumerated(EnumType.STRING)
    @NotNull
    private ChapterStatus status;

    @ManyToOne
    @JoinColumn(name = "novel_id")
    private Novel novel;
}
