package com.example.novelservice.auth.services;

import com.example.novelservice.auth.entities.User;
import com.example.novelservice.auth.repositories.UserRepository;
import com.example.novelservice.auth.requests.AuthenticationRequest;
import com.example.novelservice.auth.requests.CreateUserRequest;
import com.example.novelservice.auth.responses.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    private AuthenticationResponse generateAuthResponseFromUser(User user, String message) {
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse
                .builder()
                .status(HttpStatus.OK.toString())
                .message(message)
                .token(jwtToken)
                .build();

    }

    public AuthenticationResponse register(CreateUserRequest request) {
        var user = userService.createUserFromRequest(request);
        return generateAuthResponseFromUser(user, "User created.");
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));
        var user = userRepository.findByEmail(request.email()).orElseThrow();
        return generateAuthResponseFromUser(user, "User authenticated.");
    }
}
