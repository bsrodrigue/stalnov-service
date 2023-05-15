package com.example.novelservice.auth.services;

import com.example.novelservice.auth.entities.Role;
import com.example.novelservice.auth.entities.User;
import com.example.novelservice.auth.exceptions.UserNotFoundException;
import com.example.novelservice.auth.repositories.UserRepository;
import com.example.novelservice.auth.requests.CreateUserRequest;
import com.example.novelservice.auth.requests.DeleteAccountRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Role defaultUserRole;

    public User createUserFromRequest(CreateUserRequest request) {

        var user = User.builder()
                .bio(request.bio())
                .avatarUrl(request.avatarUrl())
                .birthdate(request.birthdate())
                .email(request.email())
                .role(defaultUserRole)
                .gender(request.gender())
                .pseudo(request.pseudo())
                .lastName(request.lastName())
                .firstName(request.firstName())
                .password(passwordEncoder.encode(request.password()))
                .build();

        userRepository.save(user);

        return user;
    }

    public void deleteUserAccountFromRequest(DeleteAccountRequest request) throws UserNotFoundException {
        Optional<User> result = userRepository.findByEmail(request.email());
        if (result.isEmpty()) throw new UserNotFoundException();
        userRepository.delete(result.get());
    }

    public User loadUserByUsername(String username) throws UserNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(UserNotFoundException::new);
    }

}
