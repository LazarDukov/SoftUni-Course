package journeyseekerhub.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {
    @OneToOne
    private CategoryEntity category;

    @Column(nullable = false)
    private BigDecimal price;

    @Column
    private int count;

    @ManyToOne
    private UserEntity client;

    @OneToMany
    private List<HotelEntity> hotelOffers;




}
