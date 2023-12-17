public class Car {
    private final String brand;
    private final String model;
    private final int year;

    public Car(String br, String mod, int year) {
        brand = br;
        model = mod;
        this.year = year;
    }

    public void printCar() {
        System.out.printf("Brand : %s\n" +
                "Model : %s\n" +
                "Year of release : %s%n\n", this.brand, this.model, this.year);
    }
}
