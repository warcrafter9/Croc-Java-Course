package ru.wjs.volodin.practicaltasks6.task12;

import java.util.function.Predicate;

import static ru.wjs.volodin.practicaltasks6.task12.TernaryOperator.ternaryOperator;

public class Main {
    public static Predicate<Integer> isEven() {
        return n -> n % 2 == 0;
    }

    public static void main(String[] args) {
        Integer number1 = 8;
        String result1 = ternaryOperator(isEven(), number1, n -> "Четное: ", n -> "Нечетное: " );
        System.out.println(result1);
    }
}
