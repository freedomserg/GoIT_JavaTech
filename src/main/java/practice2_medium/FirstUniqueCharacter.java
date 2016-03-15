package practice2_medium;

/*Перший Унікальний Символ

Знайти і повернути перший унікальний символ в рядку.
Якщо всі символи повторюються, повернути null
*/

public class FirstUniqueCharacter {
    public Character find(String s) {
        Character target = null;

        if (s.length() < 2) {
            return s.charAt(0);
        }

        while (s != null && !s.equals("")) {
            char ch = s.charAt(0);
            String postSubString = s.substring(1, s.length());
            if (!postSubString.contains(String.valueOf(ch))) {
                target = ch;
                break;
            }
            s = s.replaceAll(String.valueOf(ch), "");
        }
        return target;
    }

    public static void main(String[] args) {
        System.out.println(new FirstUniqueCharacter().find("bbbtbhhhh"));
    }
}