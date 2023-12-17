import java.lang.reflect.Array;
import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        System.out.println(
                "\n1. nonRepeatable(\"abracadabra\") = " + nonRepeatable("abracadabra") +
                        "\n2. generateBrackets(3) = " + generateBrackets(3));

        System.out.println("\n3. binarySystem(4) = " + binarySystem(4)
                + "\n4. alphabeticRow(\"klmabzyxw\") = " + alphabeticRow("adababa") +
                "\n5. task5(\"vvvvaajaaaaa\") = " + task5("vvvvaajaaaaa") +
                "\n6. convertToNum(\"five hundred sixty seven\") = " + convertToNum("five hundred sixty seven") +
                "\n7. uniqueSubstring(\"1234523\") = " + uniqueSubstring("11111111") +
                "\n8. shortestWay() = " + shortestWay(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}}) +
                "\n9. numericOrder(\"t3o the5m 1One all6 r4ule ri2ng\") = " + numericOrder("t3o the5m 1One all6 r4ule ri2ng") +
                "\n10. switchNums(6274, 717259) = " + switchNums(6274, 717259));

    }

    public static String nonRepeatable(String str) {
        if (str.isEmpty()) {
            return "";
        }
        char first = str.charAt(0);
        String reset = nonRepeatable(str.substring(1));
        if (reset.indexOf(first) >= 0) {
            return reset;
        }
        return first + reset;
    }

    public static List<String> generateBrackets(int n) {
        if (n == 1) {
            return List.of("()");
        } else {
            List<String> result = new ArrayList<>();
            for (String comb : generateBrackets(n - 1)) {
                result.add("(" + comb + ")");
                if (!result.contains(comb + "()")) {
                    result.add(comb + "()");
                }
                if (!result.contains("()" + comb)) {
                    result.add("()" + comb);
                }
            }
            return result;
        }
    }

    private static List<String> binarySystem(int n) {
        if (n == 1) {
            return List.of("0", "1");
        } else {
            List<String> result = new ArrayList<>();
            for (String comb : binarySystem(n - 1)) {
                if (comb.charAt(comb.length() - 1) == '0') {
                    result.add(comb + "1");
                } else {
                    result.add(comb + "0");
                    result.add(comb + "1");
                }
            }
            return result;
        }
    }

    public static String alphabeticRow(String str) {
        str = str.toLowerCase();
        String result = "";
        result += str.charAt(0);
        HashSet<Character> hm = new HashSet<>();
        List<String> combs = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            if (((int) str.charAt(i) + 1 == (int) str.charAt(i + 1) || (int) str.charAt(i) - 1 == (int) str.charAt(i + 1)) && !hm.contains(str.charAt(i))) {
                hm.add(str.charAt(i));
                if (!hm.contains(str.charAt(i+1))) result+=str.charAt(i+1);
            } else {
                hm = new HashSet<>();
                combs.add(result);
                result = "" + str.charAt(i + 1);
                continue;
            }
            combs.add(result);
        }
        result = combs.get(0);
        for (int i = 1; i < combs.size(); i++) {
            if (result.length() <= combs.get(i).length()) {
                result = combs.get(i);
            }
        }
        return result;
    }

    public static String task5(String str) {
        str += " ";
        int count = 1;
        String result = "";
        List<Integer> cos = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                result += (str.charAt(i));
                result += (count);
                cos.add(count);
                count = 1;
            }
        }
        Collections.sort(cos);
        String sortedResult = "";
        int j = 0;
        for (short i = 1; i < result.length();) {
            while (j < cos.size() && cos.get(j) != Character.getNumericValue(result.charAt(i))) {
                i += 2;
            }
            sortedResult += result.charAt(i - 1);
            sortedResult += result.charAt(i);
            i = 1;
            j++;
            if (j >= cos.size()){
                break;
            }
        }
        return sortedResult;
    }

    public static int convertToNum(String str) {
        str = str.replaceAll("three", "thir");
        str = str.replaceAll("five", "fif");
        str = str.replaceAll("two", "twen");
        str = str.replaceAll("four", "for");
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("one", 1);
        hm.put("twen", 2);
        hm.put("thir", 3);
        hm.put("for", 4);
        hm.put("fif", 5);
        hm.put("six", 6);
        hm.put("seven", 7);
        hm.put("eigh", 8);
        hm.put("eight", 8);
        hm.put("nine", 9);
        hm.put("ten", 10);
        hm.put("hundred", 100);
        hm.put("thousand", 1000);

        if (str.split("\\s+").length > 1) {
            boolean flag = false;
            if (str.split("\\s+").length % 2 != 0){
                str += " one";
                flag = true;
            }
            int num = 0;

            String[] str_nums = str.split("\\s+");
            for (int i = 0; i < str_nums.length - 1; i += 2) {
                if (str_nums[i].contains("ty")) {
                    hm.put(str_nums[i], hm.get(str_nums[i].substring(0, str_nums[i].length() - 2)) * 10);
                }
                num += hm.get(str_nums[i]);
                if (hm.get(str_nums[i]) < hm.get(str_nums[i + 1])) {
                    num *= hm.get(str_nums[i + 1]);
                } else if (hm.get(str_nums[i]) > hm.get(str_nums[i + 1])) {
                    num += hm.get(str_nums[i + 1]);
                }
            }
            if (flag){
                num--;
            }
            return num;
        }
        return hm.get(str);
    }

    public static String uniqueSubstring(String str) {
        char[] chars = str.toCharArray();

        HashSet<Character> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        String result = "";
        int max = 0;
        int count = 0;
        int i = 0;
        for (int j = 0; j < chars.length; j++) {
            if (!set.contains(chars[j])) {
                count++;
                set.add(chars[j]);
                result += chars[j];
            } else {
                list.add(result);
                while (chars[i] != chars[j]) {
                    count--;
                    list.add(result);
                    result = "";
                    set.remove(chars[i]);
                    i++;
                }
            }
            max = Math.max(max, count);
        }
        for (String s : list) {
            if (s.length() == max) {
                return s;
            }
        }
        return "";
    }

    public static int shortestWay(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            matrix[0][i] += matrix[0][i - 1];
            matrix[i][0] += matrix[i - 1][0];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i][j - 1]);
            }
        }
//        System.out.println(Arrays.toString(matrix[0]));
//        System.out.println(Arrays.toString(matrix[1]));
//        System.out.println(Arrays.toString(matrix[2]));
        return matrix[matrix.length - 1][matrix.length - 1];
    }

    static String numericOrder(String str) {
        String[] list = str.split("\\s+");
        ArrayList<String> array = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        for (short i = 0; i < list.length; i++) {
            array.add(null);
        }
        for (String s : list) {
            for (char ch : s.toCharArray()) {
                if (Character.isDigit(ch)) {
                    array.set(Character.getNumericValue(ch) - 1, s.replaceAll(String.valueOf(ch), ""));
                    break;
                }
            }
        }
        for (String s : array) {
            result.append(s);
            result.append(" ");
        }
        return result.toString();
    }

    static String switchNums(int num1, int num2) {
        String str_num1 = String.valueOf(num1);
        String str_num2 = String.valueOf(num2);

        StringBuilder result = new StringBuilder();

        Integer[] nums = new Integer[str_num1.length()];

        for (int i = 0; i < str_num1.length(); i++) {
            nums[i] = num1 % 10;
            num1 /= 10;
        }

        Arrays.sort(nums, Comparator.reverseOrder());

        int i = 0;
        for (char ch : str_num2.toCharArray()) {
            if (Character.getNumericValue(ch) >= nums[i]) {
                result.append(ch);
                continue;
            }
            result.append(nums[i]);
            i++;
        }

        return result.toString();
    }
}
