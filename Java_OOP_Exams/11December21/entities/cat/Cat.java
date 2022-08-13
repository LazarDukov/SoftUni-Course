package catHouse.entities.cat;

public interface Cat {
    String getName();

    void setName(String name);

    void setBreed(String breed);

    int getKilograms();

    double getPrice();

    void setPrice(double price);

    void eating();
}
