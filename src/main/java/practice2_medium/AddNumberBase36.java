package practice2_medium;

/*Додавання за основою 36

Дано 2 числа в системі числення з основою 36. Будь-яка цифра може бути в межах [0-9a-z].
Повернути суму чисел, також в системі 36.
Наприклад:
"9" + "1" = "a"
"z" + "1" = "10"
*/

import java.util.HashMap;
import java.util.Map;

public class AddNumberBase36 {
    public String add(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        StringBuilder result = new StringBuilder();

        Map<Character, Integer> numbers = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            numbers.put((char)(i + '0'), i);
        }
        for (int i = 0; i < 26; i++) {
            numbers.put((char)(i + 'a'), i + 10);
            numbers.put((char)(i + 'A'), i + 10);
        }

        int counter = 0;
        int memory = 0;
        while ((aLength - 1 - counter) >= 0 || (bLength - 1 - counter) >= 0) {
            char aDigit = (aLength - 1 - counter) >= 0 ? a.charAt(aLength - 1 - counter) : '0';
            char bDigit = (bLength - 1 - counter) >= 0 ? b.charAt(bLength - 1 - counter) : '0';
            int sum = numbers.get(aDigit) + numbers.get(bDigit) + memory;

            if (sum < 36) {
                result.append(convertToChar(sum));
                memory = 0;
            }
            else {
                result.append(convertToChar(sum % 36));
                memory = sum / 36;
            }
            counter++;
        }

        if (memory == 1) {
            result.append('1');
        }

        result.reverse();
        return result.toString();
    }

    private char convertToChar(int number) {
        return (number < 10) ? (char)('0' + number) : (char)('a' + number - 10);
    }

    public static void main(String[] args) {
        System.out.println(new AddNumberBase36().add("zjfghfhdsdfathjjhgjhghjfjfjhjhdsrreqqklhu456hfz5",
                "wsfgsgds56346263fgfhghfghfhgfsrr5476hjfgdhdhg3N"));
    }


}
