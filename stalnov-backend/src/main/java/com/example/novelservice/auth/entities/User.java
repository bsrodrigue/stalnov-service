package com.example.novelservice.auth.entities;

import com.example.novelservice.common.entities.BaseEntity;
import com.example.novelservice.common.entities.Novel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity implements UserDetails {
    @OneToMany(mappedBy = "author")
    private final List<Novel> creations = new ArrayList<>();

    @Column(unique = true)
    @NotNull
    private String pseudo;

    private String firstName;
    private String lastName;
    private String bio;

    @Email
    @Column(unique = true)
    private String email;
    private String avatarUrl;

    @NotNull
    private String password;

    @NotNull
    private LocalDate birthdate;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
