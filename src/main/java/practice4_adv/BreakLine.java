package practice4_adv;

public class BreakLine {
    StringBuilder result = new StringBuilder();
    StringBuilder currentString = new StringBuilder();
    int currentPos = 0;

    public String format(String input, int width) {

        if (input.length() - 2 <= width) return input;

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (symbol == '\"') {
                currentString.append(symbol);
            } else if (symbol == ' ') {

                if (currentPos < width) {
                    currentString.append(symbol);
                    currentPos++;

                } else {
                    currentString.append('\n');
                    result.append(currentString.toString());
                    currentPos = 0;
                    currentString = new StringBuilder();
                }

            } else {
                int lengthOfCurrentWord = getCurrentWordLength(input, i);

                if (lengthOfCurrentWord <= width) {

                    if ((lengthOfCurrentWord + currentPos) <= width) {

                        while (lengthOfCurrentWord > 0) {
                            currentString.append(symbol);
                            currentPos++;
                            lengthOfCurrentWord--;
                            i++;

                            if (lengthOfCurrentWord == 0) {
                                break;
                            }

                            symbol = input.charAt(i);

                        }
                        i--;

                    } else {
                        i--;
                        currentString.deleteCharAt(currentString.length() - 1);
                        currentString.append('\n');
                        result.append(currentString.toString());
                        currentPos = 0;
                        currentString = new StringBuilder();
                    }

                } else {
                    int residualLengthInCurrentLine = separateWord(currentString, width);

                    while (residualLengthInCurrentLine > 0) {
                        currentString.append(symbol);
                        currentPos++;
                        residualLengthInCurrentLine--;
                        i++;

                        if (residualLengthInCurrentLine == 0) {
                            break;
                        }

                        symbol = input.charAt(i);

                    }

                    currentString.append('\n');
                    result.append(currentString.toString());
                    currentPos = 0;
                    currentString = new StringBuilder();
                    i--;
                }
            }
        }

        result.append(currentString.toString());

        return result.toString();
    }

    private int separateWord(StringBuilder currentLine, int width) {
        return width - currentLine.length();
    }


    private int getCurrentWordLength(String input, int currentPosInInput) {
        int wordLength = 0;
        for (int i = currentPosInInput; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar != ' ') {
                wordLength++;
            } else {
                return wordLength;
            }
        }

        return wordLength;
    }

    public static void main(String[] args) {
        System.out.println(new BreakLine().format("\"a a b cdc w w q\"", 4));
    }
}
