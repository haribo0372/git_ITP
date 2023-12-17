import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindWords {
    public static void main(String[] args) {
        Scanner in1 = new Scanner(System.in);
        System.out.println("Input the text : ");
        String text = in1.nextLine();
        System.out.println("Input char : ");
        char ch = in1.nextLine().charAt(0);
        System.out.println(findWords(text, ch));
    }

    public static String findWords(String text, char ch){
        Pattern pattern = Pattern.compile("\\b" + ch + "\\w+\\b");
        Matcher matcher = pattern.matcher(text);
        StringBuilder builder = new StringBuilder();
        while (matcher.find()){
            builder.append(matcher.group());
            builder.append(" ");
        }
        return builder.toString();
    }
}
