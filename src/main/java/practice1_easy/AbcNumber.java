package practice1_easy;

/*Буквенні Числа

Дано рядок отриманий шляхом заміни цифр 0,1,2,...,9 певного числа на букви a,b,c,..,j.
Необхідно повернути початкове число маючи конвертований рядок.
Наприклад:
Для "bcd" повернути 123
*/

public class AbcNumber {
    public int convert(String num) {
        int number = 0;
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            int digit = ch - 'a';
            number = number * 10 + digit;
        }
        return number;
    }

    public static void main(String[] args) {
        int result = new AbcNumber().convert("d");
        System.out.println(result);
    }
}
