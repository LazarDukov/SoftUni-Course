package com.example.shoppinglist.sessions;

import com.example.shoppinglist.models.entities.User;
import com.example.shoppinglist.repositories.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
@Getter
@Setter
public class LoggedUser {
    private Long id;

    private String username;

    public void login(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }

    public void logout() {
        this.id = null;
        this.username = null;
    }
}
