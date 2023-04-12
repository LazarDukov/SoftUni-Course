package softuni.likebookapp.session;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import softuni.likebookapp.models.entities.User;

@Getter
@Setter
@Component
@SessionScope
public class LoggedUser {
    private Long id;
    private String username;

    public void login(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }

    public boolean isLoggedIn() {
        if (this.id > 0) {
            return true;
        }
        if (this.id == null) {
            return false;
        }
        return false;
    }

    public void logout() {
        this.id = 0L;
        this.username = null;
    }
}
