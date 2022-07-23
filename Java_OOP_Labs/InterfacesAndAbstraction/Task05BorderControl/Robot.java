package InterfacesAndAbstraciton.Task05;

public class Robot implements Identifiable {

    private String model;
    private String id;

    public Robot(String model,String id) {
        this.id = id;
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }
}
