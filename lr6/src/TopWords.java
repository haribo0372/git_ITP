import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TopWords {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\User\\IdeaProjects\\lr6\\input.txt");
        Map<String, Integer> map = new HashMap<>();
        List<Map.Entry<String, Integer>> list = null;
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                Pattern pattern = Pattern.compile("\\w+");
                for (String str : scanner.nextLine().split("\\s+")) {
                    Matcher matcher = pattern.matcher(str);
                    if (matcher.find()) {
                        str = matcher.group().toLowerCase();
                        if (map.containsKey(str)) {
                            map.replace(str, map.get(str), map.get(str) + 1);
                        } else {
                            map.put(str, 1);
                        }
                    }
                }
            }
            scanner.close();

            list = new ArrayList<>(map.entrySet());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        assert list != null;
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int difference = o1.getValue() - o2.getValue();
                return Integer.compare(difference, 0) * -1;
            }
        });
        for (short i = 0; i < 10; i++) {
            System.out.print(i + 1 + ". " + list.get(i) + "\n");
        }
    }
}
