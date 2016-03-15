package practice3_adv;

/*Площа прямокутників

Знайти площу яку займають N прямокутників на площині.
У всіх прямокутників одна зі сторін лежить на осі абсцис (X).
Дано три масива довжиною N.
В першому масиві Х координата нижньої-лівої вершини і-го прямокутника ,
висота в другому, ширина в третьому. Всі значення невід'ємні.
Приклад:
X - [0, 0]
H - [20, 10]
W - [10, 20]
Відповідь - 300.
*/

import java.util.HashSet;
import java.util.Set;

public class RectangleSquare {
    public int measure(int[] x, int[] h, int[] w) {
        Set<String> unitsSet = new HashSet<>();

        for (int i = 0; i < x.length; i++) {
            int[][][] matrix = new int[h[i]][w[i]][2];
            for (int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix[j].length; k++) {
                    matrix[j][k][0] = k + x[i];
                    matrix[j][k][1] = matrix.length - 1 - j;
                    String unit =  "[" + matrix[j][k][0] + "; " + matrix[j][k][1] + "]";
                    if (!unitsSet.contains(unit)) {
                        unitsSet.add(unit);
                    }
                }
            }
        }

        return unitsSet.size();
    }

    public static void main(String[] args) {
        System.out.println(new RectangleSquare().measure(new int[]{0, 0}, new int[]{20, 10}, new int[]{10, 20}));
    }
}
