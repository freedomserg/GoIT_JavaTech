package practice2_medium;

/*Кількість біт

Для даного числа порахувати кількість біт.
Наприклад:
Для числа 13 в бінарному вигляді 1101 повернути 3.
*/

public class CountBits {
    public int count(int num) {
        int count = 0;
        int mask = 1;

        for (int i = 0; i < 32; i++) {
            int currentMask = mask << i;
            if ((num & currentMask) != 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new CountBits().count(1));
    }
}
