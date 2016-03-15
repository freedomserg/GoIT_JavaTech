package practice4_adv;

/*Злічити Слова

Дано рядок. Порахувати кількість слів.
Словом вважається послідовність символів англійського алфавіту [a-zA-Z].

Алгоритм повинен працювати за O(N) часу, тому RegExp використовувати не можна.
*/

import java.util.HashSet;
import java.util.Set;

public class WordNumber {
    public int count(String input) {
        int result = 0;

        Set<Character> engLetters = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            engLetters.add((char)(i + 'a'));
            engLetters.add((char)(i + 'A'));
        }

        boolean inWord = false;
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (engLetters.contains(symbol)) {
                inWord = true;
            }
            else if (!engLetters.contains(symbol) && inWord) {
                result++;
                inWord = false;
            }
            else {
                inWord = false;
            }
        }

        if (inWord) {
            result++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new WordNumber().count("\"... ... !\""));
    }
}
