package practice3_adv;

/*Польський Інверсний Запис

Дано арифметичний вираз у вигляді Польського Інверсного запису.
Необхідно обчислити значення виразу і повернути його.

Вираз складається лише з цілих чисел і операцій +, -, *, /. Гарантується, що результат також ціне число.
*/

import java.util.*;

public class ReversePolishNotation {
    public int evaluate(String expression) {
        Map<String, Integer> operators = new HashMap<>();
        operators.put("+", 0);
        operators.put("-", 0);
        operators.put("*", 1);
        operators.put("/", 1);

        Deque<String> expressionStack = new ArrayDeque<>();
        String[] unitsOfExpression = expression.split(" ");
        List<String> convertedExpression = new ArrayList<>();
        for (String unit : unitsOfExpression) {
            if (!operators.keySet().contains(unit)) {
                convertedExpression.add(unit);
            } else if (expressionStack.size() > 0) {
                if (operators.get(unit) <= operators.get(expressionStack.peek())) {
                    while (expressionStack.size() > 0 && operators.get(unit) <= operators.get(expressionStack.peek())) {
                        convertedExpression.add(expressionStack.pop());
                    }
                    expressionStack.push(unit);
                } else {
                    expressionStack.push(unit);
                }
            } else {
                expressionStack.push(unit);
            }
        }
        while (expressionStack.size() > 0) {
            convertedExpression.add(expressionStack.pop());
        }

        Deque<Integer> processingStack = new ArrayDeque<>();
        for (String unit : convertedExpression) {
            if (!operators.keySet().contains(unit)) {
                processingStack.push(Integer.valueOf(unit));
            } else {
                int operandFirst;
                int operandSecond;
                switch (unit) {
                    case "+":
                        operandSecond = processingStack.pop();
                        operandFirst = processingStack.pop();
                        processingStack.push(operandFirst + operandSecond);
                        break;
                    case "-":
                        operandSecond = processingStack.pop();
                        operandFirst = processingStack.pop();
                        processingStack.push(operandFirst - operandSecond);
                        break;
                    case "*":
                        operandSecond = processingStack.pop();
                        operandFirst = processingStack.pop();
                        processingStack.push(operandFirst * operandSecond);
                        break;
                    case "/":
                        operandSecond = processingStack.pop();
                        operandFirst = processingStack.pop();
                        processingStack.push(operandFirst / operandSecond);
                        break;
                }
            }
        }
        return processingStack.pop();
    }

    public static void main(String[] args) {
        System.out.println(new ReversePolishNotation().evaluate("15 - 2 * 71 / 11 + 36 - 45 / 5 - 33 * 3"));
    }
}