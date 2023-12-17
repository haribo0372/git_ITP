import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("1. replace(I sell bananas ... people... I'm not kidding bananas) = \n\t" +
                replaceVovels("I sell bananas ... people... I'm not kidding bananas") +
                "\n2. stringTransform(bookkeeper) = " + stringTransform("bookkeeper") +
                "\n3. doesBlockkFit(3, 2, 3, 6, 1) = " + doesBlockkFit(new int[]{3, 2, 3, 6, 1}) +
                "\n4. numCheck(243) = " + numCheck(243) +
                "\n5. countRoots([1, -3, 2]) = " + countRoots(new int[]{1, -3, 2}) +
                "\n6. salesData = " + salesData(new String[][]{
                {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"},
                {"Pear", "Shop2", "Shop4"}}) +
                "\n7. validSplit(\"apple eagle egg goat\") = " + validSplit("apple eagle egg goat") +
                "\n8. waveForm([3, 1, 4, 2, 7, 5]) = " + waveForm(new int[]{3, 1, 4, 2, 7, 5}) +
                "\n9. commonVovel(Hello World) = " + commonVovel("Hello World") +
                "\n10. dataScience() = " + dataScience(new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {5, 5, 5, 5, 5},
                {7, 4, 3, 14, 2},
                {1, 0, 11, 10, 1}}));
    }

    public static String replaceVovels(String str) {
        char[] vovels = new char[]{'e', 'y', 'u', 'i', 'o', 'a'};
        str = str.toLowerCase();
        for (int i = 0; i < 6; i++) {
            str = str.replaceAll(String.valueOf(vovels[i]), "*");
        }
        return str;
    }

    public static String stringTransform(String str) {
        str += " ";
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                result.append("Double");
                result.append(Character.toUpperCase(str.charAt(i)));
                i++;
                continue;
            }
            result.append(str.charAt(i));
        }
        return result.toString();
    }

    public static String task5(String str) {
        str += " ";
        String result = "";
        int count = 1;
        List<Integer> c = new ArrayList<>();
        for (int i = 0; i < str.length()-1 ; i++){
            if (str.charAt(i) == str.charAt(i+1)){
                count++;
            }
            else{
                result += str.charAt(i);
                result += count;
                c.add(count);
                count = 1;
            }
        }
        Collections.sort(c);
        str = "";
        int j = 0;
        for (int i : c){
            if ((int) result.charAt(j+1) == i){
                str += result.charAt(j) + result.charAt(j+1);
            }
            else{
                j++;
            }
        }
        return str;
    }

    public static boolean doesBlockkFit(int[] array) {
        int[] kub = new int[]{array[0], array[1], array[2]};
        int[] hole = new int[]{array[3], array[4]};
        Arrays.sort(kub);
        Arrays.sort(hole);
        return (kub[0] <= hole[0] && kub[1] <= hole[1]);
    }

    public static boolean numCheck(int number) {
        int copy = number;
        int sum = 0;
        while (copy > 0) {
            sum += (int) Math.pow(copy % 10, 2);
            copy /= 10;
        }
        return number % 2 == sum % 2;
    }

    public static int countRoots(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        double discriminant = Math.pow(b, 2) - (4 * a * c);
        if (discriminant < 0) {
            return 0;
        }
        double x1 = (-1 * b + Math.sqrt(discriminant)) / (2 * a);
        if (discriminant > 0) {
            double x2 = (-1 * b - Math.sqrt(discriminant)) / (2 * a);
            if (x1 % 1 == 0 && x2 % 1 == 0) {
                return 2;
            } else if (x1 % 1 == 0 || x2 % 1 == 0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (x1 % 1 == 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static ArrayList<String> salesData(String[][] array) {
        ArrayList<String> products = new ArrayList<>();
        int max = 0;
        for (String[] strings : array) {
            if (strings.length > max) {
                max = strings.length;
            }
        }
        for (String[] sales : array) {
            if (sales.length >= max && sales.length >= 5) {
                products.add(sales[0]);
            }
        }
        return products;
    }

    public static boolean validSplit(String str) {
        String[] array = str.split("\\s+");
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].charAt(array[i].length() - 1) == array[i + 1].charAt(0)) {
                count++;
            }
        }
        return (count == array.length - 1);
    }

    public static boolean waveForm(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > nums[i + 1] && nums[i + 1] < nums[i + 2]) {
                count++;
            } else if (nums[i] < nums[i + 1] && nums[i + 1] > nums[i + 2]) {
                count++;
            }
        }
        return (count == nums.length - 2);
    }

    public static char commonVovel(String str) {

        int vowelA = 0;
        int vowelO = 0;
        int vowelI = 0;
        int vowelU = 0;
        int vowelY = 0;
        int vowelE = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = Character.toUpperCase(str.charAt(i));
            switch (ch) {
                case 'A' -> vowelA++;
                case 'O' -> vowelO++;
                case 'I' -> vowelI++;
                case 'U' -> vowelU++;
                case 'Y' -> vowelY++;
                case 'E' -> vowelE++;
            }
        }
        int max = Math.max(vowelA, Math.max(vowelO, Math.max(vowelI, Math.max(vowelU, Math.max(vowelY, vowelE)))));
        if (max == vowelA) {
            return 'a';
        } else if (max == vowelO) {
            return 'o';
        } else if (max == vowelI) {
            return 'i';
        } else if (max == vowelU) {
            return 'u';
        } else if (max == vowelY) {
            return 'y';
        } else {
            return 'e';
        }
    }

    public static String dataScience(int[][] matrix) {
        int sum = 0;
        int j = 1;
        for (int i = 0; i < matrix.length; i++) {
            while (j < matrix.length) {
                if (j != i) {
                    sum += matrix[j][i];
                }
                j++;
            }
            matrix[i][i] = Math.round((float) sum / (matrix.length - 1));
            sum = 0;
            j = 0;
        }
        return Arrays.deepToString(matrix);
    }
}
