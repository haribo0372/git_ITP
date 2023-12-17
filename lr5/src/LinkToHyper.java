import java.util.regex.*;
//Необходимо написать программу, которая будет заменять все ссылки в
//заданном тексте на гиперссылки. При этом программа должна
//использовать регулярные выражения для поиска ссылок и замены и
//обрабатывать возможные ошибки

//Если хотите попасть в переводчик то жмите https://translate.yandex.ru/
public class LinkToHyper {
    public static void main(String[] args) {
        String text = "lalalalala https://www.example.com pepepe https://translate.com";
        String convertedText = convertLinks(text);
        System.out.println(convertedText);
    }

    public static String convertLinks(String text) {
        Pattern pattern = Pattern.compile("\\b((https?)://[A-Za-z0-9./]*)");
        Matcher matcher = pattern.matcher(text);

        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            String link = matcher.group();
            String hyperlink = "<a href=\"" + link + "\">" + link + "</a>";
            matcher.appendReplacement(result, hyperlink);
        }
        matcher.appendTail(result);

        return result.toString();
    }
}
