import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Camry", 2016);
        Car car2 = new Car("Subaru", "Forest", 2012);
        Car car3 = new Car("BMW", "M4", 2022);
        Car car4 = new Car("Mazda", "Demio", 2014);

        HashTable<String, Car> cars = new HashTable<>();
        System.out.println("\nis_empty() до добавления : " + cars.is_empty());
        cars.put("k66og", car1); // Toyota Camry
        cars.put("j892fg", car2); // Subaru Forest
        cars.put("j891fg", car3); // BMW M4
        cars.put("s798iu", car4); // Mazda Demio

        System.out.print("-----------------------------------\n" +
                "All cars (size: " + cars.size() + "):\n");
        for (String key : cars.keySet()){
            cars.get(key).printCar();
        }

//        System.out.print("\n");
//
//        for (LinkedList<HashNode<String, Car>> node : cars.nodes){
//            for (HashNode<String, Car> car: node) {
//                System.out.println(cars.nodes.indexOf(node) + ":" + node.indexOf(car) + " - " + car.value.model);
//            }
//        }
        System.out.println("\n---------------------------------\n" +
                "Поиск машины \"BMW M4\": ");
        cars.get("j891fg").printCar();

        System.out.println("\n-------------------------------\n" +
                "Вывод после удаления \"Mazda Demio\": ");
        cars.remote("s798iu");

        for (String key : cars.keySet()){
            cars.get(key).printCar();
        }
    }
}