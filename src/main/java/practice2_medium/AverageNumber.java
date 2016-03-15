package practice2_medium;

/*Середнє Арифметичне

Знайти середнє значення двох цілих чисел.
Приклади:
average( 4, 6 ) = 5
average( -4, -7 ) = -5
average( -4, 7 ) = 1
*/

public class AverageNumber {
    public int average(int a, int b) {
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        if (a == Integer.MIN_VALUE && b < 0) {
            a += 1;
            b -= 1;
            return -((Math.abs(a) & Math.abs(b)) + ((Math.abs(a) ^ Math.abs(b)) >> 1));
        }

        if (a < 0 && b == Integer.MIN_VALUE) {
            a -= 1;
            b += 1;
            return -((Math.abs(a) & Math.abs(b)) + ((Math.abs(a) ^ Math.abs(b)) >> 1));
        }

        if (a < 0 && b < 0) {
            return -((Math.abs(a) & Math.abs(b)) + ((Math.abs(a) ^ Math.abs(b)) >> 1));
        }

        if (a < 0 || b < 0) {
            return (a + b) / 2;
        }

        return (a & b) + ((a ^ b) >> 1);
    }

    public static void main(String[] args) {
        System.out.println(new AverageNumber().average(-2147483648, -2));
    }
}
