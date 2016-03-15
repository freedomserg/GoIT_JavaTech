package practice2_medium;

/*Самотнє Число

Дано масив цілих чисел. Всі числа в масиві повторюються рівно 5 разів і лише одне число не має дублікатів.
Знайти число, що неповторюється.
*/

import java.util.Arrays;

public class LonelyNumber_secondWay {

    public int find(int[] input) {
        Arrays.sort(input);
        for (int i = 0; i < input.length - 5; i += 5) {
            for (int j = i; j < i + 4; j++) {
                int firstComparison = input[j] ^ input[j + 1];
                if (firstComparison != 0) {
                    if (j == i + 3) {
                        return input[j + 1];
                    }
                    int secondComparison = input[j] ^ input[j + 2];
                    if (secondComparison != 0) {
                        return input[j];
                    } else {
                        return input[j + 1];
                    }
                }
            }
        }
        return input[input.length - 1];
    }

    public static void main(String[] args) {
        int[] data = {1, 3, 3, 1, 3, 0, 2, 1, 2, 3, 2, 1, 2, 1, 2, 3};

        System.out.println(new LonelyNumber_secondWay().find(data));
    }
}