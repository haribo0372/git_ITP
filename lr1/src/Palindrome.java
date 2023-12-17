public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            System.out.println(isPalindrome(s));
        }
    }
    public static String reverseString(String str){
        char[] chars = str.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i=0;i<chars.length;i++){
            result.append(chars[Math.abs(i - (chars.length - 1))]);
        }
        return result.toString();
    }
    public static boolean isPalindrome(String s){
        return s.equals(reverseString(s));
    }
}