package practice1_easy;


import java.util.Arrays;

public class SnakeMatrixTraversal {

    public int[] print(int[][] input) {

        int[] result = new int[input.length * input[0].length];

        int top;
        int bottom = input.length - 1;
        int left = 0;
        int right = input[0].length - 1;

        int k = 0;
        boolean topWasOnceTraversed = false;

        snake_loop:
        while (left <= right) {

            if (!topWasOnceTraversed) {
                top = 0;
            } else {
                top = 1;
            }

            for (int i = top; i <= bottom; i++) {
                result[k] = input[i][left];
                topWasOnceTraversed = true;
                if (k == result.length - 1) {
                    break snake_loop;
                }
                k++;
            }
            left++;

            for (int i = left; i <= left; i++) {
                result[k] = input[bottom][i];
                if (k == result.length - 1) {
                    break snake_loop;
                }
                k++;
            }

            for (int i = bottom - 1; i >= top; i--) {
                result[k] = input[i][left];
                if (k == result.length - 1) {
                    break snake_loop;
                }
                k++;
            }
            left++;

            for (int i = left; i <= right; i++) {
                result[k] = input[top][i];
                if (k == result.length - 1) {
                    break snake_loop;
                }
                k++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] input = {
                {1, 2, 3,},
                {4, 5, 6,},
                {7, 8, 9,},
                {10, 11, 12,},
        };

        int[] result = new SnakeMatrixTraversal().print(input);

        System.out.println(Arrays.toString(result));
    }
}
