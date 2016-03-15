package practice2_medium;

/*Бітовий Поліндром

Перевірити чи являється бінарне представлення числа поліндромом.
*/

public class BitsPalindrome {
    public boolean isPalindrome(int input) {
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((input & (mask << i)) == 0 && (input & (mask << 31 - i)) != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new BitsPalindrome().isPalindrome(25));
    }
}
