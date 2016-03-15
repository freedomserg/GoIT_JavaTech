package practice1_easy;

/*Злиття Цифр
З'єднати масив символів в число.
Приклад:
Для [ '1', '2', '3'] повернути 123
*/
public class JoinCharacters {
    public int join(char[] input) {
        return Integer.valueOf(new String(input));
    }

    public static void main(String[] args) {
        char[] chars = {'1', '2', '3'};
        int number = new JoinCharacters().join(chars);
        System.out.println(number);
    }
}
