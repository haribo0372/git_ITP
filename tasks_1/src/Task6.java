import java.util.*;

public class Task6 {
    public static void main(String[] args) {
        System.out.println("1. hiddenAnagram(\"My world evolves in a beautiful space called Tesh.\"," +
                " \"sworn love lived\") = " +
                hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived") +
                "\n2. collect(\"intercontinentalisationalism\", 6) = " +
                collect("intercontinentalisationalism", 6) +
                "\n3. nicoCipher() = " + nicoCipher("mubashirhassan", "crazy") +
                "\n4. twoProduct() = " + twoProduct(new int[]{1, 2, 3, 9, 4, 5, 15}, 45) +
                "\n5. isExact(720) = " + Arrays.toString(isExact(720)) +
                "\n6. fractions(\"0.19(2367)\") = " + fractions("0.19(2367)") +
                "\n7. pilish_string() = " + pilish_string("FORALOOP") + "\n");

//        long[] num = new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        for (int i = 0; i< num.length; i++){
//            for (int j = 0; j< num.length; j++){
//                if (gcd(num[i], num[j]) == 2){
//                    System.out.print("(" + num[i] + ", " + num[j] + "); ");
//                }
//            }
//        }
    }

    public static String hiddenAnagram(String s1, String s2) {
        s1 = s1.toLowerCase().replaceAll("(?U)[\\pP\\s+]", "");
        s2 = s2.toLowerCase().replaceAll("(?U)[\\pP\\s+]", "");
        StringBuilder stringBuilder = new StringBuilder();
        List<Character> chs2 = new ArrayList<>();
        for (char c : s2.toCharArray()) {
            chs2.add(c);
        }
        for (char c1 : s1.toCharArray()) {
            for (int i = 0; i < chs2.size(); i++) {
                if (c1 == chs2.get(i)) {
                    stringBuilder.append(c1);
                    chs2.remove(i);
                }
            }
        }
        return stringBuilder.isEmpty() ? "notfound" : stringBuilder.toString();
    }

    public static ArrayList<String> collect(String s, int n) {
        if (s.length() < n) {
            return new ArrayList<>();
        }
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < s.length(); i += n) {
            if (i + n <= s.length()) arrayList.add(s.substring(i, i + n));
//            else arrayList.add(s.substring(i));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static String nicoCipher(String message, String key) {
        key = key.toLowerCase();
        char[] keyArr = key.toCharArray();
        Arrays.sort(keyArr);
        Set<Integer> dKey = new HashSet<>();
        for (char ch : keyArr) {
            dKey.add(ch - 'a');
        }
        ArrayList<Integer> arr = new ArrayList<>(dKey);
        int nColumn = arr.size();

        HashMap<Integer, String> hm = new HashMap<>();

        for (int j = 0; j < nColumn; j++) {
            Integer k = arr.get(j);
            for (int i = j; i < message.length(); i += nColumn) {
                if (hm.containsKey(k)) {
                    hm.put(k, hm.get(k) + message.charAt(i));
                } else {
                    hm.put(k, String.valueOf(message.charAt(i)));
                }
            }
        }
        List<Map.Entry<Integer, String>> fList = new ArrayList<>(hm.entrySet());
        fList.sort((o1, o2) -> {
            int difference = o1.getKey() - o2.getKey();
            return Integer.compare(difference, 0);
        });
//        System.out.println(fList);
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, String> m : fList) {
            result.append(m.getValue());
        }
        return result.toString();
    }

    public static String twoProduct(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] * arr[j] == n) {
                    return i > j ?
                            Arrays.toString(new int[]{arr[j], arr[i]}) : Arrays.toString(new int[]{arr[i], arr[j]});
                }
            }
        }
        return Arrays.toString(new int[]{});
    }

    public static int[] isExact(int n) {
        return isExact(n, 1, 1);
    }

    public static int[] isExact(int n, int k, int factorial) {
        if (n == factorial) {
            return new int[]{n, k};
        } else if (n < factorial) {
            return new int[]{};
        }
        return isExact(n, k + 1, factorial * (k + 1));
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static String fractions(String decimal) {
        // "0.19(2367)"

        String[] arr = decimal.split("\\."); // [0, 19(2367)]

        // целая часть
        int integerPart = Integer.parseInt(arr[0]); // 0

        // не повтор часть в строковом формате
        String s = arr[1].substring(0, arr[1].indexOf('(')); // "19"

        // повтор часть
        int R = Integer.parseInt(arr[1].substring(arr[1].indexOf('(') + 1, arr[1].indexOf(')'))); //2367
        // есть ли дробная часть ?
        if (s.isEmpty()) {
            StringBuilder strR = new StringBuilder();
            for (char ch : String.valueOf(R).toCharArray()) {
                strR.append(9);
            }
            long n2 = Integer.parseInt(strR.toString());
            long n1 = integerPart * n2 + R;

            long del = gcd(n1, n2);
            System.out.format("ip : %s = n1 = %s ; n2 = %s; del = %s\n", integerPart, n1, n2, del);
            return String.format("%s/%s", n1 / del, n2 / del);
        }
        // всю дробную переносим за запятую
        // 192367.0
        long fractionPart = Long.parseLong(String.format("%s%s", integerPart,
                arr[1].replaceAll("[()]", "")));

        // не повтор часть
        int nonR = Integer.parseInt(s); // 19

        long n1 = fractionPart - nonR; // 192367 - 19 = 192348

        long n2 = (long) ((long) Math.pow(10, String.format("%s%s", nonR, R).length()) -
                Math.pow(10, String.valueOf(nonR).length()));

        long del = gcd(n1, n2);

        return String.format("%s/%s", n1 / del, n2 / del);
    }

    // CAN I MAKE A GUESS NOW
    public static String pilish_string(String str) {
        StringBuilder builder = new StringBuilder();

        int[] pi = new int[]{3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9};

        int sum = 0;
        for (int j = 0; j < pi.length; j++) {
            System.out.println(builder + " : " + j + " : " + builder.length());
            if (sum+pi[j] <= str.length()) {
                builder.append(str.substring(sum, sum + pi[j])).append(' ');
                sum += pi[j];
                continue;
            }
//            builder.deleteCharAt(builder.length()-1);
            while (sum != builder.length()-j){
                builder.append(str.charAt(str.length()-1));
            }
        }
        return builder.toString();
    }

}
