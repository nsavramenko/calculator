package projects.calc_kata;

import java.util.Scanner;


public class Calculator {

    public static void main(String[] args) throws Exception {
        start();
    }

    public static String calc(String userInput) throws Exception {

        String expression = userInput.toUpperCase().replaceAll(" ", "");
        String[] values = expression.split("[+\\-*/]");
        int x;
        int y;
        int arabResult;
        String result;
        boolean isRoman;

        if (values.length != 2)
            throw new Exception("Проверь условие ввода, количество операнд, а также оператор вычисления согласно условию!!");

        if (RomanNumerals.isRoman(values[0]) && RomanNumerals.isRoman(values[1])) {
            isRoman = true;
            x = RomanNumerals.toArabic(values[0]);
            y = RomanNumerals.toArabic(values[1]);
        } else if (!RomanNumerals.isRoman(values[0]) && !RomanNumerals.isRoman(values[1])) {
            isRoman = false;
            x = Integer.parseInt(values[0]);
            y = Integer.parseInt(values[1]);
        } else {
            throw new Exception("Неверный формат значений, ONLY ROMAN-ROMAN / ARABIC-ARABIC!!");
        }

        arabResult = ArabicNumerals.arabicCalculation(expression, x, y);
        // Проверка условия ввода -> выполняем арифметические действия с арабскими числами;
        if (ArabicNumerals.checkArabicInput(x, y)) {
            result = String.valueOf(arabResult);
        } else {
            throw new Exception("Проверь условие ввода!!");
        }

        if (isRoman) {
            // Проверка допустимого диапазона результата вычисления римских чисел;
            if (arabResult <= 0) {
                throw new Exception("Римские числа не могут быть меньше или равны нулю!!");
            } else {
                result = RomanNumerals.toRoman(arabResult);
            }
        }
        return result;
    }

    private static void start() throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                                
                Простая программа по вычислению суммы, разности, деления и умножения двух целых чисел.
                                
                NB!
                * Формат выражения может быть передан ТОЛЬКО в римских числах, либо ТОЛЬКО в арабских;
                * Диапазон вводимых значений может быть от 1 до 10 включительно;
                * Калькулятор может работать только с целыми числами;
                * Помни, что в Римской системе счисления нет и не может быть ни НУЛЯ ни ОТРИЦАТЕЛЬНЫХ значений;
                * Так уж получилось, что при делении будет возвращено только целое число, остаток будет отброшен.
                                
                ВВЕДИ В ОДНУ СТРОКУ МАТЕМАТИЧЕСКОЕ ВЫРАЖЕНИЕ И НАЖМИ КНОПКУ 'ENTER'""");
        String userInput = scanner.nextLine();
        System.out.println(calc(userInput));
    }
}