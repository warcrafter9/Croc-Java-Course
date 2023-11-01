package ru.wjs.volodin.practicalTasks2.task4;

import java.util.Scanner;

public class ArithmeticProgression {
    public static void main(String[] args) {
        ArithmeticProgression arithmeticProgression = new ArithmeticProgression();
        arithmeticProgression.setArguments();  //установили значения
        arithmeticProgression.sumProgression(); //посчитали сумму
        System.out.println(arithmeticProgression.getSum()); // вывели сумму из инстанса класса
        arithmeticProgression.setArguments();   //установили классу новые значения
        System.out.println(arithmeticProgression.getSum()); //вывели сумму из инстанса класса 🥲

    }

    private int firstElement;
    private int difference;
    private int n;
    private long sum;

    public void setArguments() {
        Scanner console = new Scanner(System.in);
        String error ="Введите целые числа из [-10000;10000]";
        try {
            int inputFirstElement = console.nextInt();
            int inputDifference = console.nextInt();
            int inputN = console.nextInt();
            if (checkInterval(inputFirstElement, inputDifference, inputN)) {
                firstElement = inputFirstElement;
                difference = inputDifference;
                n = inputN;
            } else {
                System.out.println(error);
            }
        } catch (java.util.InputMismatchException exception) {
            System.out.println(error);
        }
    }


    public long sumProgression() {
        sum = this.firstElement;
        int tempElement = firstElement;
        for (int i = 1; i < n; i++) {
            tempElement += difference;
            sum += tempElement;
        }
        return sum;
    }

    public boolean checkInterval(int inputFirstElement, int inputDifference, int inputN) {
        if (inputFirstElement <= 10000 & inputFirstElement >= -10000) {
            if (inputDifference <= 10000 & inputDifference >= -10000) {
                if (inputN <= 10000 & inputN >= -10000) {
                    return true;
                }
            }
        }
        return false;
    }

    public long getSum() {
        return sum;
    }
}
