package task3;

import models.Person;
import myAnnotations.DataProcessor;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@DataProcessor
public class SortedData {
    public static List<Person> filterByAge(List<Person> personList, int age) {
        return personList.stream().filter(person -> person.getAge() >= age).toList();
    }

    public static List<Person> sortPersonListByName(List<Person> personList){
        return personList.stream().sorted(Comparator.comparingInt(o -> o.getName().toLowerCase().charAt(0)))
                .collect(Collectors.toList());
    }

    public static List<Person> sortPersonListByAge(List<Person> personList){
        return personList.stream().sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toList());
    }
}
