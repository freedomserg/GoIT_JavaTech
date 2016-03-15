package practice4_adv;

/*Парсер Числа

Дано рядок, що представляє певне чило. Необхідно повернути число.
Якщо це неможливо, повернути null
Наприклад:
"-2.e10"
"+.3"
".e2" повертає null
*/

public class DoublesParser {
    public Double parse(String s) {
        StateMachine automat = new StateMachine();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            automat.next(c);
        }

        return automat.getResult();
    }

    private static class StateMachine {
        State currentState = State.INIT;
        ParseData data = new ParseData();

        public void next(char c) {
            currentState = currentState.next(c, data);

        }

        public Double getResult() {
            if (currentState == State.NUMBER) {

                if (data.isDoubleNumber()) {

                    if (data.isExponentialNumber()) {

                        if (data.ifContainsAtLeastOneDigit()) {

                            if (data.isExponentialOrderNegative()) {

                                if (data.isNegativeNumber()) {
                                        return (data.getNumber() + data.getFractionalPart()) * Math.pow(10, (-1) * data.getExponentialPart()) * (-1);
                                } else {
                                    return (data.getNumber() + data.getFractionalPart()) * Math.pow(10, (-1) * data.getExponentialPart());
                                }

                            } else {

                                if (data.isNegativeNumber()) {
                                    return (data.getNumber() + data.getFractionalPart()) * Math.pow(10, data.getExponentialPart()) * (-1);
                                } else {
                                    return (data.getNumber() + data.getFractionalPart()) * Math.pow(10, data.getExponentialPart());
                                }
                            }

                        } else {
                            return null;
                        }

                    } else if (data.ifContainsAtLeastOneDigit()) {

                        if (data.isNegativeNumber()) {
                            double result = data.getNumber() + data.getFractionalPart();
                            if (result == 0) return result;
                            return result * (-1);
                        } else {
                            return data.getNumber() + data.getFractionalPart();
                        }

                    } else {
                        return null;
                    }
                }


                if (data.isNegativeNumber()) {
                    return (double)(data.getNumber() * (-1));
                } else {
                    return (double)(data.getNumber());
                }

            }
            return null;
        }

        public enum State {
            INIT {
                @Override
                public State next(char c, ParseData data) {
                    if ((c - '0') > 0 && (c - '0') <= 9) {
                        data.addDigit(c - '0');
                        return NUMBER;
                    } else if (c == '-') {
                        data.setAsNegative();
                        return NUMBER;
                    } else if (c == '+') {
                        return NUMBER;
                    } else if (c == '.') {
                        data.setAsDouble();
                        return NUMBER;
                    } else if (c == '0') {
                        data.addDigit(c - '0');
                        data.setFirstDigitInNumberIsZero(true);
                        return NUMBER;
                    }

                    return INVALID_END;
                }
            }, NUMBER {
                @Override
                public State next(char c, ParseData data) {

                    if (data.isFirstDigitInNumberIsZero() && c != '.') {
                        return INVALID_END;
                    } else {
                        data.setFirstDigitInNumberIsZero(false);
                    }

                    if ((c - '0') >= 0 && (c - '0') <= 9) {

                        if (data.isExponentialNumber()) {

                            if (!data.isExponentialOrderSignAdjusted()) {

                                data.setExponentialOrderSignAdjusted();
                            }

                            data.addExponentialPart(c - '0');
                            return NUMBER;
                        }

                        if (data.isDoubleNumber()) {
                            data.addFractionalPart(c - '0');
                        } else {
                            data.addDigit(c - '0');
                        }
                        return NUMBER;
                    } else if (c == '.') {
                        if (!data.isDoubleNumber()) {
                            data.setAsDouble();
                            return NUMBER;
                        }
                        return INVALID_END;
                    } else if (c == 'e') {

                        if (data.isDoubleNumber()) {
                            data.setAsExponential();
                            return NUMBER;
                        }

                        return INVALID_END;
                    } else if (c == '-') {

                        if (data.isExponentialNumber() && !data.isExponentialOrderSignAdjusted()) {
                            data.setExponentialOrderNegative();
                            data.setExponentialOrderSignAdjusted();
                            return NUMBER;
                        }

                        return INVALID_END;
                    }

                    return INVALID_END;
                }
            }, VALID_END {
                @Override
                public State next(char c, ParseData data) {
                    if (c == ' ') return VALID_END;
                    return INVALID_END;
                }
            }, INVALID_END {
                @Override
                public State next(char c, ParseData data) {
                    return INVALID_END;
                }
            };

            public abstract State next(char c, ParseData data);
        }
    }

    private static class ParseData {
        private int number;
        private double fractionalPart;
        private double exponentialPart;
        private int orderOfFractionalPart;
        private boolean firstDigitInNumberIsZero;
        private boolean isNegative;
        private boolean isDouble;
        private boolean containsAtLeastOneDigit;
        private boolean isExponential;
        private boolean isExponentialOrderNegative;
        private boolean isExponentialOrderSignAdjusted;

        public void addDigit(int i) {
            number = number * 10 + i;
            containsAtLeastOneDigit = true;
        }

        public int getNumber() {
            return number;
        }

        public void setAsNegative() {
            isNegative = true;
        }

        public boolean isNegativeNumber() {
            return isNegative;
        }

        public void setAsDouble() {
            isDouble = true;
        }

        public boolean isDoubleNumber() {
            return isDouble;
        }

        public void addFractionalPart(int i) {
            fractionalPart = fractionalPart + (double) i / (Math.pow(10, ++orderOfFractionalPart));
            containsAtLeastOneDigit = true;
        }

        public double getFractionalPart() {
            return fractionalPart;
        }

        public boolean ifContainsAtLeastOneDigit() {
            return containsAtLeastOneDigit;
        }

        public void setAsExponential() {
            isExponential = true;
        }

        public boolean isExponentialNumber() {
            return isExponential;
        }

        public void addExponentialPart(int i) {
            exponentialPart = exponentialPart * 10 + i;
        }

        public double getExponentialPart() {
            return exponentialPart;
        }

        public void setExponentialOrderNegative() {
            isExponentialOrderNegative = true;
        }

        public boolean isExponentialOrderNegative() {
            return isExponentialOrderNegative;
        }

        public void setExponentialOrderSignAdjusted() {
            isExponentialOrderSignAdjusted = true;
        }

        public boolean isExponentialOrderSignAdjusted() {
            return isExponentialOrderSignAdjusted;
        }

        public void setFirstDigitInNumberIsZero(boolean firstDigitInNumberIsZero) {
            this.firstDigitInNumberIsZero = firstDigitInNumberIsZero;
        }

        public boolean isFirstDigitInNumberIsZero() {
            return firstDigitInNumberIsZero;
        }
    }

    public static void main(String[] args) {

        DoublesParser ddd = new DoublesParser();
        double result = ddd.parse("-0.1e2");
        System.out.println(result);
    }
}
