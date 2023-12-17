import dao.DataManager;
import models.Person;
import models.Processor;
import myAnnotations.DataProcessor;
import task3.ReadData;
import task3.SortedData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static DataManager dataManager = new DataManager();

    private final static List<Person> personList = new ArrayList<>();

    static {
        personList.add(new Person("Vitek", 23));
        personList.add(new Person("Vasya", 21));
        personList.add(new Person("Serega", 12));
        personList.add(new Person("BabushkaVKedah", 90));
        personList.add(new Person("Dimon", 52));
        personList.add(new Person("Boy", 9));
    }

    public static void main(String[] args) {
        File input = new File("C:\\Users\\User\\IdeaProjects\\lr8\\input.txt");

        @DataProcessor(path = "C:\\Users\\User\\IdeaProjects\\lr8\\files\\file1.txt")
        Processor processor1 = new Processor("C:\\Users\\User\\IdeaProjects\\lr8\\files\\file1.txt");

        @DataProcessor
        Processor processor2 = new Processor("C:\\Users\\User\\IdeaProjects\\lr8\\files\\file2.txt");

        @DataProcessor
        Processor processor3 = new Processor("C:\\Users\\User\\IdeaProjects\\lr8\\files\\file3.txt");

        dataManager.registerDataProcessor(processor1, 1);
        dataManager.registerDataProcessor(processor2, 2);
        dataManager.registerDataProcessor(processor3, 3);
        System.out.println("Status 2.1 : Completed");
        try {
            dataManager.loadData(input, 1);
            System.out.println("Status 2.2 : Completed");
        }
        catch (IOException e){
            System.out.println(e + " in 41 line of Main.java");
        }
        System.out.println("\nStatus 2.3 : Completed\n\tResult : " + dataManager.processData(personList));

        System.out.println("\nStatus 2.4 : Completed\n\tResult : " + dataManager.saveData());


//        System.out.println(ReadData.readFullData());
//
//        List<Person> list = SortedData.sortPersonListByAge(DataManager.getFilterData());
//        System.out.println(ReadData.readFilterData(list));
//
//        try {
//            dataManager.processDataWithExecutor(personList, 30);
//        }
//        catch (IOException | InterruptedException e){
//            System.out.println(e + " in 60 line of Main.java");
//        }
//        System.out.println();
//        for (Person person : dataManager.personSet){
//            System.out.format("%s, %s\n", person.getName(), person.getAge());
//        }
    }
}
