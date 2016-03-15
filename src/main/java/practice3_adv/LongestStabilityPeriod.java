package practice3_adv;

/*Найдовший Період Стабільності

Дано масив чисел в якому знаходяться значення ВВП за кожен місяць в мільярдах доларів США.
Необхідно знайти найдовший період стабільності.
Період стабільності - період часу де всі значення ВВП попарно відрізняються один від одного максимум на 1.
Повернути кількість місяців.
*/

public class LongestStabilityPeriod {
    public int count(int[] gdp) {
        int result = 0;
        int gdpLength = gdp.length;

        for (int i = 0; i < gdpLength; i++) {
            int currentPos = i + 1;
            int difference = 0;

            if (Math.abs(difference) > 1) {
                continue;
            }

            while (currentPos < gdpLength && Math.abs(gdp[currentPos] - gdp[i]) <= 1) {

                if (difference == 0 && gdp[currentPos] - gdp[i] != 0) {
                    difference = gdp[currentPos] - gdp[i] > 0 ? 1 : -1;
                } else if (Math.abs(gdp[currentPos] - gdp[i] - difference) > 1) {
                    break;
                }
                currentPos++;
            }

            if (result < currentPos - i) {
                result = currentPos - i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] gdp = {901, 901, 901, 902, 902, 903, 903, 902, 902, 901,};
        System.out.println(new LongestStabilityPeriod().count(gdp));
    }
}
