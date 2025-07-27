package vehicles;

public class car {
    String brand;
    int speed;

    public car(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    public void displayBrand() {
        System.out.println("Brand: " + brand);
    }

    public void getSpeed() {
        System.out.println("Speed is: " + speed);
    }
}
