package practice1_easy;

/*Алфавіт
Дано рядок. Перевірити чи містить він всі букви англійського алфавіту a-zA-Z.
*/

public class Alphabet {
    public boolean check(String input) {
        for (int i = 0; i < 26; i++) {
            if (!input.contains(String.valueOf((char)(i + 'a'))) && !input.contains(String.valueOf((char)(i + 'A')))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        System.out.println(new Alphabet().check(input));
    }
}
