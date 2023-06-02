package journeyseekerhub.model.entities;

import jakarta.persistence.*;
import journeyseekerhub.model.enums.UserRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class UserRoleEntity extends BaseEntity {
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;

}
