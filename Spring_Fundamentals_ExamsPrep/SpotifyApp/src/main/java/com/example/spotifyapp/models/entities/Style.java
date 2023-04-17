package com.example.spotifyapp.models.entities;

import com.example.spotifyapp.models.enums.StyleName;
import jakarta.persistence.*;

@Entity
@Table(name = "styles")
public class Style {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StyleName name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Style() {
    }

    public Style(StyleName styleName) {
        this.name = styleName;
    }

    public Long getId() {
        return id;
    }

    public Style(Long id, StyleName name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StyleName getName() {
        return name;
    }

    public void setName(StyleName name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
