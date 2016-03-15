package practice2_medium;

/*Бінарне Додавання

Додайте два беззнакових числа, що передаються як рядки.
"101" + "100" = "1001"
*/

public class AddBinary {
    String add(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        StringBuilder result = new StringBuilder();

        int memory = 0;
        int counter = 0;
        while ((aLength - 1 - counter) >= 0 || (bLength - 1 - counter) >= 0) {
            char aBit = (aLength - 1 - counter >= 0) ? a.charAt(aLength - 1 - counter) : '0';
            char bBit = (bLength - 1 - counter >= 0) ? b.charAt(bLength - 1 - counter) : '0';
            int sum = (aBit - '0') + (bBit - '0') + memory;

            if (sum == 0 || sum == 1) {
                result.append(sum);
                memory = 0;
            }
            else if (sum == 2) {
                result.append('0');
                memory = 1;
            }
            else {
                result.append('1');
                memory = 1;
            }
            counter++;
        }

        if (memory == 1) {
            result.append('1');
        }

        result.reverse();
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().add("0", "0"));
    }
}
