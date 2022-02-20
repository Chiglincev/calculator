package ru.chpetr;

import java.util.function.*;

public class Calculator {
    static Supplier<Calculator> instance = Calculator::new;

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;

    //BinaryOperator<Integer> devide = (x, y) -> x / y;       //нет проверки деления на ноль

    BinaryOperator<Integer> devide = (x, y) -> {            //завершение программы с сообщением об ошибке деления на ноль
        if (y == 0) {
            System.out.println("Деление на ноль");
            throw new ArithmeticException("Деление на ноль");
        } else return x / y;
    };
    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;
    Predicate<Integer> isPositive = x -> x > 0;
    Consumer<Integer> println = System.out::println;
}
