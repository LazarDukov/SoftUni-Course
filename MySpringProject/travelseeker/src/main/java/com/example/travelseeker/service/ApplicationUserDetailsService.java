package com.example.travelseeker.service;

import com.example.travelseeker.model.entities.UserEntity;
import com.example.travelseeker.model.entities.UserRoleEntity;
import com.example.travelseeker.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class ApplicationUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public ApplicationUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserEntityByUsername(username).map(this::map).orElseThrow(() -> new UsernameNotFoundException("User with name " + username + " not found!"));
    }

    private UserDetails map(UserEntity userEntity) {
      return   new User(userEntity.getUsername(),
                userEntity.getPassword(),
                extractGrantedAuthority(userEntity)
        );
    }

    private List<GrantedAuthority> extractGrantedAuthority(UserEntity userEntity) {
      return   userEntity.getRoles().stream().map(this::mapRole).toList();
    }

    private GrantedAuthority mapRole(UserRoleEntity userRoleEntity) {
        return new SimpleGrantedAuthority("ROLE_" + userRoleEntity.getRole().name());

    }
}