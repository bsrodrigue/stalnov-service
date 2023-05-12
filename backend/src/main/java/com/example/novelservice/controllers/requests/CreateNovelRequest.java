package com.example.novelservice.controllers.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateNovelRequest {
    private String title;
    private String description;
    private String genre;
}
