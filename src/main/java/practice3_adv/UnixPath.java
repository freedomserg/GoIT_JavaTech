package practice3_adv;

/*Unix Шлях

Дано повний шлях до файла в Unix системі.
Наприклад /home/../var/./lib//file.txt
Необхідно повернути спрощений варіант. (/var/lib/file.txt)
*/

import java.util.LinkedList;

public class UnixPath {
    public String simplify(String input) {
        LinkedList<String> stack = new LinkedList<>();
        StringBuilder wordBuffer = new StringBuilder();
        for(int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (symbol == '/') {
                String word = wordBuffer.toString();

                if ("..".equals(word)) {

                    if (!stack.isEmpty()) {
                        stack.pop();
                    }

                } else if (".".equals(word) || word.length() == 0) {

                } else {
                    stack.push(word);
                }
                wordBuffer = new StringBuilder();

            } else {
                wordBuffer.append(symbol);
            }
        }
        String word = wordBuffer.toString();

        if (word.length() > 0 && !".".equals(word) && !"..".equals(word)) {
            stack.push(word);
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append("/");
            result.append(stack.removeLast());
        }

        if (result.length() == 0) {
            result.append("/");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new UnixPath().simplify("//"));
    }
}