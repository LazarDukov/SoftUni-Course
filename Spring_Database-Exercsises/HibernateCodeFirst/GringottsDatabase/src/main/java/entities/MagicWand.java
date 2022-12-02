package entities;


import javax.persistence.*;

@Entity
@Table(name = "magic_wand")
public class MagicWand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(length = 100, name = "creator")
    private String name;

    @Column(name = "size")
    private Long Size;

    public MagicWand() {
    }

    public MagicWand(Long id, String name, Long size) {
        this.id = id;
        this.name = name;
        Size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSize() {
        return Size;
    }

    public void setSize(Long size) {
        Size = size;
    }
}
