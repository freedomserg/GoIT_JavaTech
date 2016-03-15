package practice2_medium;

/*Біт Реверс

Для даного числа поміняти всі біти місцями відносно центра.
Наприклад:
Для 2 (10) повернути 1073741824 (01000000000000000000000000000000).
*/

public class ReverseBits {
    public int reverse(int input) {

        int[] units = new int[32];
        int result = 0;

        int mask = 1;
        for (int i = 0; i < 16; i++) {
            units[i] = ((input & (mask << i)) == 0) ? 0 : 1;
        }
        for (int i = 31; i >= 16; i--) {
            units[i] = ((input & (mask << i)) == 0) ? 0 : 1;
        }

        for (int unit : units) {
            result = (result << 1) + unit;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseBits().reverse(1));
    }
}
