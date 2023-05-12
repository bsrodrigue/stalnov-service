package com.example.novelservice.controllers.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String bio;
}
