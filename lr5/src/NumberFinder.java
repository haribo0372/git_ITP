import java.util.regex.*;
public class NumberFinder {
    public static void main(String[] args) {
        String text = "52 The 3.99 p3rice 10 of the pr4oduct is $19.99\nThis is the second ( 2 ) ";
        Pattern pattern = Pattern.compile("(\\d+(.|,)\\d+|\\s\\d+\\s)");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}