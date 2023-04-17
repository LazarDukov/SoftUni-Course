package com.example.spotifyapp.session;

import com.example.spotifyapp.models.entities.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
public class LoggedUser {
    private Long id;
    private String username;

    public void logIn(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }

    public boolean isUserLoggedIn() {
        if (this.id != null) {
            return true;
        }
        return false;
    }

    public void logOut() {
        this.id = null;
        this.username = null;
    }
}
