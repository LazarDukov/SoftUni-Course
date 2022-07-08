package ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }


    private double getLength() {
        return length;
    }

    private void setLength(double length) {
        exception(length, "Lenght");
        this.length = length;

    }

    private double getWidth() {
        return width;
    }

    private void setWidth(double width) {

        exception(width, "Width");

        this.width = width;

    }

    private double getHeight() {
        return height;
    }

    private void setHeight(double height) {

        exception(height, "Height");

        this.height = height;

    }

    private void exception(double line, String argument) {
        if (line <= 0) {
            throw new IllegalArgumentException(argument + " cannot be zero or negative.");
        }
    }

    public double calculateSurfaceArea() {
        return 2 * length * width + 2 * length * height + 2 * width * height;

    }

    public double calculateLateralSurfaceArea() {
        return 2 * length * height + 2 * width * height;
    }

    public double calculateVolume() {
        return length * width * height;
    }

}
