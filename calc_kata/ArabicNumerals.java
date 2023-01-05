package projects.calc_kata;

class ArabicNumerals {
    public static int arabicCalculation(String expression, int x, int y) throws Exception {

        if (expression.contains("+"))
            return x + y;
        if (expression.contains("-"))
            return x - y;
        if (expression.contains("*"))
            return x * y;
        else if (y == 0) {
            throw new Exception("Деление на ноль!!");
        } else {
            return x / y;
        }
    }

    public static boolean checkArabicInput(int x, int y) {

        if ((x > 0 && x < 11) && (y > 0 && y < 11)) {
            return true;
        } else {
            return false;
        }
    }
}