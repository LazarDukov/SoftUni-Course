package com.example.springsecuritydemo.service;


import com.example.springsecuritydemo.model.entity.User;
import com.example.springsecuritydemo.model.entity.UserRole;
import com.example.springsecuritydemo.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class ApplicationUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public ApplicationUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findUserByEmail(username).map(this::map)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Username with name " + username + " not found!"));
    }

    private UserDetails map(User user) {
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), extractGrantedAuthority(user)) {
        };


    }

    private List<GrantedAuthority> extractGrantedAuthority(User user) {
        return user.getRoles().stream().map(this::mapRole).toList();
    }

    private GrantedAuthority mapRole(UserRole userRole) {
        return new SimpleGrantedAuthority("ROLE_" + userRole.getRole().name());
    }
}
