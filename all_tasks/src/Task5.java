import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {

    public static void main(String[] args) throws ParseException {
        System.out.println("1. haveSamePattern(\"FFGG\", \"CDCD\") = " + sameLetterPattern("FFGG", "CDCD") +
                "\n2. spiderVsFly(\"H3\", \"E2\") = " + spiderVsFly("A4", "C2") +
                "\n3. digitsCount(255) = " + digitsCount(255) +
                "\n4. totalPoints([\"trance\", \"recant\"], \"recant\") = " + totalPoints(List.of("trance", "recant"), "recant") +
                "\n5. sumsUp([1, 6, 5, 4, 8, 2, 3, 7]) = " + sumsUp(new int[]{1, 6, 5, 4, 8, 2, 3, 7}) +
                "\n6. calculateTestScore([\"53%\", \"79%\"]) = " + takeDownAverage(new String[]{"53%", "79%"}) +
                "\n7. caesarCipher(\"encode\", \"almost last task!\", 4) = " + caesarCipher("encode", "almost last task!", 4) +
                "\n8. setSetup(5, 3) = " + setSetup(5, 3) +
                "\n9. timeDifference(\"New York\", \"December 31, 1970 13:40\", \"Beijing\") = " + timeDifference("New York", "December 31, 1970 13:40", "Beijing") +
                "\n10. isNew(869) = " + isNew(869));
    }

    public static boolean sameLetterPattern(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        char[] pattern1 = new char[26];
        char[] pattern2 = new char[26];

        for (int i = 0; i < str1.length(); i++) {
            int index1 = str1.charAt(i) - 'A';
            int index2 = str2.charAt(i) - 'A';
            if (pattern1[index1] == 0 && pattern2[index2] == 0) {
                pattern1[index1] = str1.charAt(i);
                pattern2[index2] = str2.charAt(i);
            } else if (pattern1[index1] != str1.charAt(i) || pattern2[index2] != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static String spiderVsFly(String n1, String n2) {
        StringBuilder res = new StringBuilder();
        char ch1 = n1.charAt(0);
        char ch2 = n2.charAt(0);
        int num1 = Integer.parseInt(String.valueOf(n1.charAt(1)));
        int num2 = Integer.parseInt(String.valueOf(n2.charAt(1)));
        if (num1 == 0)ch1=ch2;
        res.append(ch1).append(num1);

        if (Objects.equals(n2, "A0")){
            while (num1!=num2 && num1 != 1){
                num1--;
                res.append("-").append(ch1).append(num1);
            }
            res.append("-A0");
            return res.toString();
        }
        while (ch1 != ch2 || num1 != num2){
            if (num1 != num2){
                if (num1>num2)num1--;
                else num1++;
                res.append(String.format("-%s%s", ch1, num1));
            }
            if (ch1!=ch2){
                if (ch1>ch2)ch1--;
                else ch1++;
                res.append(String.format("-%s%s", ch1, num1));
            }
        }
        return res.toString();
    }

    public static int digitsCount(long x) {
        if (x / 10 == 0) {
            return 1;
        }
        return 1 + digitsCount(x / 10);
    }

    public static int totalPoints(List<String> strList, String str) {
        int points = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char ch : str.toCharArray()) {
            if (!hm.containsKey(ch)) {
                hm.put(ch, 1);
            } else {
                hm.put(ch, hm.get(ch) + 1);
            }
        }
        for (String s : strList) {
            HashMap<Character, Integer> hmStr = new HashMap<>();
            for (char ch : s.toCharArray()) {
                if (!hmStr.containsKey(ch)) {
                    hmStr.put(ch, 1);
                } else {
                    hmStr.put(ch, hmStr.get(ch) + 1);
                }
            }
            boolean flag = true;
            int i = 0;
            int countPoints = 0;
            for (char ch : s.toCharArray()) {
                i++;
                if (hm.get(ch) < hmStr.get(ch)) {
                    flag = false;
                }
                if (i >= 3) countPoints++;
            }
            if (flag) points += countPoints;
            if (flag && s.length() == 6) points += 50;
        }
        return points;
    }

    public static String sumsUp(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == 8) {
                    list.add(List.of(nums[i], nums[j]));
                }
            }
        }
        list.sort((o1, o2) -> {
            int difference = Math.abs(o1.get(0) - o1.get(1)) - Math.abs(o2.get(0) - o2.get(1));
            return Integer.compare(difference, 0);
        });
        return list.toString();
    }

    public static String takeDownAverage(String[] arr) {
        int sum = 0;
        Pattern pattern = Pattern.compile("\\d+");
        for (String s : arr) {
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) sum += Integer.parseInt(matcher.group());
        }
        double average = sum / arr.length;
        int num = 0;
        while (((double) (num + sum) / (arr.length + 1) != average - 5)) {
            num++;
        }
        return String.format("%s%s", num, "%");
    }

    public static String caesarCipher(String mode, String str, int dec) {
        str = str.toUpperCase();
        StringBuilder result = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                if (Objects.equals(mode, "encode")) {
                    result.append(Character.valueOf((char) (ch + dec)));
                } else if (Objects.equals(mode, "decode")) {
                    result.append(Character.valueOf((char) (ch - dec)));
                }
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static int factorial(int n) {
        if (n <= 2) {
            return 2;
        }
        return n * factorial(n - 1);
    }

    public static int setSetup(int n, int k) {
        if (n == k || k==0) {
            return 1;
        }
        return factorial(n) / factorial(n - k);
    }

    public static String timeDifference(String city1, String timestamp, String city2) {
        HashMap<String, String> months = new HashMap<>();
        months.put("January", "01");
        months.put("February", "02");
        months.put("March", "03");
        months.put("April", "04");
        months.put("May", "05");
        months.put("June", "06");
        months.put("July", "07");
        months.put("August", "08");
        months.put("September", "09");
        months.put("October", "10");
        months.put("November", "11");
        months.put("December", "12");
        HashMap<String, String> timeZones = new HashMap<>();
        timeZones.put("Los Angeles", "America/Los_Angeles");
        timeZones.put("New York", "America/New_York");
        timeZones.put("Caracas", "America/Caracas");
        timeZones.put("Buenos Aires", "America/Buenos_Aires");
        timeZones.put("London", "Europe/London");
        timeZones.put("Rome", "Europe/Rome");
        timeZones.put("Moscow", "Europe/Moscow");
        timeZones.put("Tehran", "Asia/Tehran");
        timeZones.put("New Delhi", "GMT");
        timeZones.put("Beijing", "Asia/Shanghai");
        timeZones.put("Canberra", "Australia/Canberra");

        String[] date = timestamp.split("(\\s+)|(,\\s)");
        String monthN = months.get(date[0]);

        if (date[1].length() == 1) {
            date[1] = String.format("%s%s", 0, date[1]);
        }
        String[] time = date[date.length - 1].split(":");
        DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        dfm.setTimeZone(TimeZone.getTimeZone(timeZones.get(city1)));
        try {
            Date d = dfm.parse(String.format("%s-%s-%s %s:%s:00", date[2], monthN, date[1], time[0], time[1]));

            DateFormat iso = new SimpleDateFormat("yyyy-MM-dd HH:mm");

            iso.setTimeZone(TimeZone.getTimeZone(timeZones.get(city2)));
            return iso.format(d);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    public static String time(String city1, String timestamp, String city2) {

        HashMap<String, List<Integer>> monthes = new HashMap<>();
        monthes.put("January", List.of(1, 31));
        monthes.put("February", List.of(2, 28));
        monthes.put("March", List.of(3, 31));
        monthes.put("April", List.of(4, 30));
        monthes.put("May", List.of(5, 31));
        monthes.put("June", List.of(6, 30));
        monthes.put("July", List.of(7, 31));
        monthes.put("August", List.of(8, 31));
        monthes.put("September", List.of(9, 30));
        monthes.put("October", List.of(10, 31));
        monthes.put("November", List.of(11, 30));
        monthes.put("December", List.of(12, 31));

        String[] date = timestamp.split("(\\s+)|(,\\s)");
        int days = monthes.get(date[0]).get(1);
        int day = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);

        String[] time = date[date.length - 1].split(":");

        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);

        int[] utc = new int[2];
        switch (city1) {
            case "Los Angeles":
                utc[0] = hour + 8;
                utc[1] = minute;
                break;
            case "New York":
                utc[0] = hour + 5;
                utc[1] = minute;
                break;
            case "Caracas":
                utc[0] = hour + 4;
                utc[1] = minute + 30;
                break;
            case "Buenos Aires":
                utc[0] = hour + 3;
                utc[1] = minute;
                break;
            case "London":
                utc[0] = hour;
                utc[1] = minute;
                break;
            case "Rome":
                utc[0] = hour - 1;
                utc[1] = minute;
                break;
            case "Moscow":
                utc[0] = hour - 3;
                utc[1] = minute;
                break;
            case "Tehran":
                utc[0] = hour - 3;
                utc[1] = minute - 30;
                break;
            case "New Delhi":
                utc[0] = hour - 5;
                utc[1] = minute - 30;
                break;
            case "Beijing":
                utc[0] = hour - 8;
                utc[1] = minute;
                break;
            case "Canberra":
                utc[0] = hour - 10;
                utc[1] = minute;
            default:
                return "The city was not found in the table";
        }
        HashMap<String, String> cities = new HashMap<>();
        cities.put("Los Angeles", "-8 00");
        cities.put("New York", "-5 00");
        cities.put("Caracas", "-4 30");
        cities.put("Buenos Aires", "-3 00");
        cities.put("London", "+0 00");
        cities.put("Rome", "+1 00");
        cities.put("Moscow", "+3 00");
        cities.put("Tehran", "+3 30");
        cities.put("New Delhi", "+5 30");
        cities.put("Beijing", "+8 00");
        cities.put("Canberra", "+10 00");
        return "";
    }

    public static boolean isNew(int num) {
        String sN = String.valueOf(num);
        if (sN.length() == 1) return true;
        char[] lN = sN.toCharArray();
        Arrays.sort(lN);
        sN = new String(lN);
        for (int i = num - 1; String.valueOf(i).length() == String.valueOf(num).length(); i--) {
            char[] cs = String.valueOf(i).toCharArray();
            Arrays.sort(cs);
            String s2 = new String(cs);
            if (Objects.equals(sN, s2)) {
                return false;
            }
        }
        return true;
    }
}
