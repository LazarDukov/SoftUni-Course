package journeyseekerhub.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
    @Column
    private String username;

    @Column
    private String firstName;
    @Column
    private String lastName;

    @Column
    private String country;

    @Column
    private int age;

    @Column
    private String password;

    @OneToOne
    private UserRoleEntity role;

    @OneToMany
    private List<OfferEntity> usersOffers;

}
