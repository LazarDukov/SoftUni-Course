package entities;

import javax.persistence.*;

@Entity
@Table(name = "store_location")
public class StoreLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //•	store_location (id, location_name)
    @Column(name = "location_name")
    private String locationName;

    public StoreLocation() {
    }

    public StoreLocation(int id, String locationName) {
        this.id = id;
        this.locationName = locationName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
