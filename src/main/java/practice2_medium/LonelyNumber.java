package practice2_medium;

/*Самотнє Число

Дано масив цілих чисел. Всі числа в масиві повторюються рівно 5 разів і лише одне число не має дублікатів.
Знайти число, що неповторюється.
*/

public class LonelyNumber {
    public int find(int[] input) {
        int[] units = new int[32];
        int result = 0;

        for (int number : input) {
            int mask = 1;
            for (int j = 0; j < 32; j++) {
                int currentMask = mask << j;
                if ((number & currentMask) != 0) {
                    units[31 - j]++;
                }
            }
        }

        for (int unit : units) {
            result = result << 1;
            result += ((unit % 5) & 1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = {3, 3, 3, 3, 1, 5, 5, 5, 5, 5, 3};
        System.out.println(new LonelyNumber().find(input));
    }
}
