import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAdress {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        Pattern pattern = Pattern.compile("^" +
                "(25[0-5]|[1-2][0-4][0-9]|[0-9][0-9]|[0-9])." +
                "(25[0-5]|[1-2][0-4][0-9]|[0-9][0-9]|[0-9])." +
                "(25[0-5]|[1-2][0-4][0-9]|[0-9][0-9]|[0-9])." +
                "(25[0-5]|[1-2][0-4][0-9]|[0-9][0-9]|[0-9])$");

        Matcher m = pattern.matcher(text);
        if (m.find()){
            System.out.println(m.group() + " - is OK");
        }
        else {
            System.out.println("BAD BAD BAD");
        }
    }
}
