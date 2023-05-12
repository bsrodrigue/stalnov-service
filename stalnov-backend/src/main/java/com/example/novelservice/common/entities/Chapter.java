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
    @NotNull
    private String body;

    @ManyToOne
    @JoinColumn(name = "novel_id")
    private Novel novel;
}
