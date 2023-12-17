package task3;

import dao.DataManager;
import models.Person;
import myAnnotations.DataProcessor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

@DataProcessor
public class ReadData {

    public static String readOneFile(File file) {
        StringBuilder result = new StringBuilder();
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNext()){
                result.append(reader.nextLine());
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e + " in 22 line in task3/ReadData.readOneFile");
        }
        return result.toString();
    }

    public static String readFilterData(List<Person> list){
        StringBuilder result = new StringBuilder();
        for (Person person : list){
            String s = String.format("\nPerson {\n\t\"name\": %s,\n\t\"age\": %s\n}",
                    person.getName(), person.getAge());
            result.append(s);
        }
        return result.toString();
    }

    public static String readFullData(){
        StringBuilder result = new StringBuilder();

        for (File file : DataManager.getDataProcessors()){
            if (file != null){
                result.append('\n').append(file.getName()).append(" :\n");
                try{
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNext()){
                        result.append(scanner.nextLine()).append('\n');
                    }
                }
                catch (FileNotFoundException e){
                    System.out.println(e + " in 46 line in task3/ReadData.readFullData");
                }
            }
        }
        return result.isEmpty() ? "No data" : result.toString();
    }
}
