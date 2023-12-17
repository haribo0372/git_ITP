import java.util.Scanner;
import java.util.regex.*;

//  Необходимо написать программу, которая будет проверять корректность
//  ввода пароля. Пароль должен состоять из латинских букв и цифр, быть
//  длиной от 8 до 16 символов и содержать хотя бы одну заглавную букву и
//  одну цифру. При этом программа должна использовать регулярные
//  выражения для проверки пароля и обрабатывать возможные ошибки.

public class PasswordIsCorrection {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String password = in.nextLine();
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[A-Z])[a-zA-Z0-9]{8,16}$");
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) {
            System.out.println("The password is correct! : " + matcher.group());
        }
        else{
            System.out.println("The password IS NOT correct");
        }
    }
}
