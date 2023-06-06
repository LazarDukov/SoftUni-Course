package journeyseekerhub.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import journeyseekerhub.model.enums.HotelRoomEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class HotelEntity extends BaseEntity {
    @Column
    private String name;

    @Column
    private String country;

    @Column
    private String city;

    @Column
    private String address;

    @Column
    private int stars;

    @Column
    private String description;

    @Column
    private BigDecimal priceByNight;

    @Column
    private HotelRoomEnum roomType;

    @Column
    private BigDecimal priceBreakfast;

    @Column
    private BigDecimal priceDinner;

    @Column
    private BigDecimal allInclusive;
}
