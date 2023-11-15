package ru.wjs.volodin.practicaltasks6.task12;

import java.util.function.Function;
import java.util.function.Predicate;

public class TernaryOperator {
    public static <T, R> R ternaryOperator(Predicate<T> predicate, T input, Function<T, R> trueFunc, Function<T, R> falseFunc) {
        return predicate.test(input) ? trueFunc.apply(input) : falseFunc.apply(input);
    }
}
