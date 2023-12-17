package models;

public class Person {
    private static long counter = 0;
    private String name;
    private int age;

    public Person() {
        counter++;
    }

    public Person(int age) {
        this.age = age;
        counter++;
    }

    public Person(String name) {
        this.name = name;
        counter++;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
