package practice3_adv;

/*Їжа для гномів

В країні гномів прийнято, що більша порція їжі дістається вищому гному.
Дано два мисиви int[] довжиною N, з висотами гномів в першому і кілограмами їжі в другому.
Для кожного i-го гнома треба знайти j-ту порцію їжі і записати в результат j-індекси.
Приклад:
[5, 7, 6, 9, 4] - гноми
[8, 5, 6, 2, 3] - порції
Найвищому гному з висотою 9 дістається найбільша порція 8 з індексом 0.
Другий за висотою гном (7), отримує другу завбільшки порцію (6) з індексом 2, і т.д.
Найнищий (4) отримує найменшу порцію 2 (індекс 3)
Резульнат
[4, 2, 1, 0, 3]
*/

import java.util.*;

public class GnomeFood {
    public int[] find(int[] gnomes, int[] portions) {
        Map<Integer, Integer> gnomesHeight = new TreeMap<>();
        Map<Integer, Integer> portionsSize = new TreeMap<>();
        int[] result = new int[gnomes.length];

        for (int i = 0; i < gnomes.length; i++) {
            gnomesHeight.put(gnomes[i], i);
            portionsSize.put(portions[i], i);
        }

        Iterator<Integer> iteratorHeight = gnomesHeight.keySet().iterator();
        Iterator<Integer> iteratorSize = portionsSize.keySet().iterator();

        while (iteratorHeight.hasNext()) {
            int index = gnomesHeight.get(iteratorHeight.next());
            result[index] = portionsSize.get(iteratorSize.next());
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new GnomeFood().find(new int[]{3}, new int[]{9})));
    }
}
