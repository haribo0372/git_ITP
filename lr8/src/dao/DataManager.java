package dao;

import models.Person;
import models.Processor;
import myAnnotations.DataProcessor;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DataManager {
    private static List<Person> filterData;

    private final static int capacityDP = 10;
    private static final List<File> dataProcessors = new ArrayList<>(capacityDP);

    static {
        for (short i = 0; i < capacityDP; i++) {
            dataProcessors.add(null);
        }
    }

    public static List<Person> getFilterData() {
        return filterData;
    }

    public static List<File> getDataProcessors() {
        return dataProcessors;
    }

    public void registerDataProcessor(Processor processor, int index) {
        if (!processor.getClass().isAnnotationPresent(DataProcessor.class)) {
            System.out.println("The processor does not have a myAnnotations.DataProcessor annotation");
            return;
        }
//        myAnnotations.DataProcessor dataP = (myAnnotations.DataProcessor) processor.getClass().getAnnotation(myAnnotations.DataProcessor.class);
        File file = new File(processor.path());
        dataProcessors.add(index, file);
    }

    @DataProcessor
    public void loadData(File file2, int index) throws FileNotFoundException, IOException {
        File file1 = dataProcessors.get(index);
        if (!file2.exists() || !file1.exists()) {
            throw new FileNotFoundException();
        }
        Scanner readFile2 = new Scanner(file2);
        try (FileWriter fw = new FileWriter(file1)) {
            while (readFile2.hasNext()) {
                fw.write(readFile2.nextLine());
                fw.append('\n');
            }
        }
    }

    @DataProcessor
    private void writePerson(Person person, File file) {
        try (FileWriter fw = new FileWriter(file, true)) {
            String s = String.format("\nPerson {\n\t\"name\": %s,\n\t\"age\": %s\n}",
                    person.getName(), person.getAge());
            fw.write(s);
            fw.append('\n');
            fw.flush();
        } catch (IOException e) {
            System.out.println(e + "in 63 line of dao.DataManager.java");
        }
    }

    public List<Person> processData(List<Person> personList) {
        filterData = personList.parallelStream().filter(person -> person.getAge() >= 18).toList();

        return filterData;
    }

    public String saveData() {
        try {
            Method method = DataManager.class.getDeclaredMethod("writePerson", Person.class, File.class);
            if (!method.isAnnotationPresent(DataProcessor.class)) {
                System.out.println("dao.DataManager::writePerson() is not annotated with @myAnnotations.DataProcessor");
                System.exit(1);
            }
        } catch (NoSuchMethodException e) {
            System.out.println(e + " in 65 line of dao.DataManager.java");
        }
        StringBuilder result = new StringBuilder();
        for (File file : dataProcessors) {
            if (file != null) {
                for (Person person : filterData) {
                    Thread thread = new Thread(() -> {
                        writePerson(person, file);
                    });
                    thread.start();
                }
                result.append(file.getName()).append(" Updated; ");
            }
        }
        return result.toString();
    }

    public Set<Person> personSet = new HashSet<>();

    public void processDataWithExecutor(List<Person> personList, int age) throws IOException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        System.out.println("\n\nExecutorService start\n");
        for (Person person : personList) {
            executorService.submit(() -> {
                System.out.println("Task running in thread: " + Thread.currentThread().getName());
                if (person.getAge() < age) {
                    personSet.add(person);
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }
}
