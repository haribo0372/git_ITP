public class Main {
    public static void main(String[] args) {
        Sedan sedan = new Sedan("BMW", "M4");
        sedan.plusSpeed(40);
        sedan.getValues();

        Truck truck = new Truck(1000);
        truck.setColor("Red");
        truck.getValues();

        Bike bike = new Bike("Babun");
        bike.getValues();

        Sedan first = new Sedan();
        Sedan second = new Sedan();
        Sedan third = new Sedan();
        System.out.println("---------------------------\n" + "Седан имеется в количестве - " + Sedan.getNumOfInstances());
    }
}