import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Objects;

public class Task2 {
    public static void main(String[] args){
        System.out.println("\n\n<---------------------Tasks 2/6--------------------->\n" +
                "\nTask 1/10 : dublicateChars(\"Tigr govorit rrrrr\") = " + dublicateChars("Tigr govorit rrrrr") +
                "\nTask 2/10 : getInitials(\"Ryan Gosling\") = " + getInitials("Ryan Gosling") +
                "\nTask 3/10 : differenceEvenOdd([44, 32, 86, 19]) = " + differenceEvenOdd(new int[]{44, 32, 86, 19}) +
                "\nTask 4/10 : equalToAvg([1, 2, 3, 4, 6]) = " + equalToAvg(new int[]{1, 2, 3, 4, 6}) +
                "\nTask 5/10 : indexMult([1, 2, 3]) = " + indexMult(new int[]{1, 2, 3}) +
                "\nTask 6/10 : reverse(\"Hello World\") = " + reverse("Hello World") +
                "\nTask 7/10 : Tribonacci(11) = " + Tribonacci(11) +
                "\nTask 8/10 : pseudoHash(7) = " + pseudoHash(7) +
                "\nTask 9/10 : botHelper(\"Please ::::;;;'''',,...()help me\") = " +
                botHelper("Please ::::;;;'''',,...()help me") +
                "\nTask 10/10 : isAnagram(\"listen\", \"silent\") = " + isAnagram("a b c d e f g", "f g e d c b a"));
    }
    public static boolean dublicateChars(String str){
        str = str.toLowerCase();
        char[] chars = str.toCharArray();
        for (int i=0; i < chars.length; i++){
            for (int j=i+1; j < chars.length; j++){
                if (chars[i] == chars[j]){
                    return true;
                }
            }
        }
        return false;
    }
    public static StringBuilder getInitials(String str){
        String[] words = str.split(" ");
        StringBuilder initials = new StringBuilder();
        for (String word : words){
            initials.append(word.charAt(0));
        }
        return initials;
    }
    public static int differenceEvenOdd(int[] array){
        int chet = 0;
        int nechet = 0;
        for (int i : array){
            if (i%2==0){
                chet += i;
            }
            else {
                nechet+=i;
            }
        }
        return Math.max(chet, nechet) - Math.min(chet, nechet);
    }
    public static boolean equalToAvg(int[] array){
        float srAr = (float) Arrays.stream(array).sum() / array.length;
        for (int i : array){
            if (srAr == i){
                return true;
            }
        }
        return false;
    }
    public static String indexMult(int[] array){
        for (int i = 0; i<array.length; i++){
            array[i] *= i;
        }
        return Arrays.toString(array);
    }
    public static String reverse(String str){
        char[] chars = str.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i=0;i<chars.length;i++){
            result.append(chars[Math.abs(i - (chars.length - 1))]);
        }        return result.toString();
    }
    public static int Tribonacci(int x){
        int[] f = new int [x];
        f[0] = 0;
        f[1] = 0;
        f[2] = 1;
        for (int i = 3; i < x; i++) {
            f[i] = f[i - 3] + f[i - 2] + f[i - 1];
        }
        return f[x-1];
    }
    public static StringBuilder pseudoHash(int len){
        final String chars = "abcdef0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder hash = new StringBuilder();

        for (int i = 0; i < len; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            hash.append(chars.charAt(randomIndex));
        }
        return hash;
    }
    public static String botHelper(String message){
        String key = "help";

        String[] array = message.split(" ");

//        boolean find = Arrays.asList(message.split(" ")).contains(key);

        for (String word: array){
            word = word.replaceAll("(?U)[\\pP\\s]", "");
            System.out.println(word);
            if (Objects.equals(word, key)){
                return "Calling for a staff member";
            }
        }

        return "Keep waiting";
    }
    public static boolean isAnagram(String str1, String str2){
        str1 = str1.replaceAll("(?U)[\\pP\\s]", "");
        str2 = str2.replaceAll("(?U)[\\pP\\s]", "");
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }
}
