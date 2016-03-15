package practice4_adv;

/*Бінарний Пошук

Дано відсортований масив унікальних чисел.
Необхідно реалізувати функцію пошуку target числа,
що працює за час O( log(N) ).
Якщо число існує в масиві - повернути індекс, в іншому випадку -1 - (insertionIndex).
Де insertionIndex це індекс куди можна було б вставити target.
*/

public class BinarySearch {
    public int find(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        int mid = 0;

        if (array.length == 0) return -1;

        while (start <= end) {
            mid = (start + end) >>> 1;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1 - start;
    }
}
