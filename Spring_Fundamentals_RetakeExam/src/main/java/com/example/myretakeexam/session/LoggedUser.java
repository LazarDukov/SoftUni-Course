package com.example.myretakeexam.session;

import com.example.myretakeexam.models.entities.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Getter
@Setter
@Component
@SessionScope
public class LoggedUser {
    private long id;
    private String username;

    public void login(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }

    public boolean isLoggedIn() {
        if (this.id > 0) {
            return true;
        }
        return false;
    }

    public void logout() {
        this.id = 0;
        this.username = null;
    }
}
