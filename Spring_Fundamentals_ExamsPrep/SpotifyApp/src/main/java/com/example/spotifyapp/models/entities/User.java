package com.example.spotifyapp.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.List;

@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column
    @Email
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_songs",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id"))
    private List<Song> playlist;

    public User() {
    }

    public User(Long id, String username, String password, String email, List<Song> playlist) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.playlist = playlist;
    }

    public List<Song> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<Song> playlist) {
        this.playlist = playlist;
    }

    public Long getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void removeAllSongsFromPlaylist() {
        this.playlist.clear();
    }
}

