package practice1_easy;

/*Обхід матриці по спіралі

Обійти матрицю по спіралі і записати всі числа в одмірний масив.
Для матриці
[[1,   2,  3,  4],
 [5,   6,  7,  8]
 [9,  10, 11, 12]
 [13, 14, 15, 16]]
вивести [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
*/

import java.util.Arrays;

public class SpiralMatrixTraversal {
    public int[] print(int[][] input) {

        int[] result = new int[input.length*input[0].length];

        int left = 0;
        int right = input[0].length - 1;
        int top = 0;
        int bottom = input.length - 1;

        int k = 0;

        spiral_loop:
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result[k] = input[top][i];
                if (k == result.length - 1) break spiral_loop;
                k++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result[k] = input[i][right];
                if (k == result.length - 1) break spiral_loop;
                k++;
            }
            right--;

            for (int i = right; i >= left; i--) {
                result[k] = input[bottom][i];
                if (k == result.length - 1) break spiral_loop;
                k++;
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                result[k] = input[i][left];
                if (k == result.length - 1) break spiral_loop;
                k++;
            }
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] input = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
        };

        int[] result = new SpiralMatrixTraversal().print(input);

        System.out.println(Arrays.toString(result));
    }
}
