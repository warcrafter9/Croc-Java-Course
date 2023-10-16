package ru.wjs.volodin.practicalTasks2.task4;

public class ArithmeticProgression {
    public static void main(String[] args) {
        ArithmeticProgression arithmeticProgression = new ArithmeticProgression(3, 4, 5);
        arithmeticProgression.sumProgression(arithmeticProgression);
        System.out.println(arithmeticProgression.getSum());
    }

    private int firstElement;
    private int difference;
    private int n;
    private int sum;

    public ArithmeticProgression(int firstElement, int difference, int n) {
        this.firstElement = firstElement;
        this.difference = difference;
        this.n = n;
    }

    public int sumProgression(ArithmeticProgression arithmeticProgression) {
        if (arithmeticProgression.checkInterval()) { // здесь происходит проверка на вхождение аргументов в интервал
            sum = this.firstElement;
            for (int i = 1; i < n; i++) {
                firstElement += difference;
                sum += firstElement;
            }
            return sum;
        } else {
            System.out.println("Аргументы прогрессии должны входить в [-10000;10000]");
        }
        return sum;
    }

    public boolean checkInterval() {
        if (this.firstElement <= 10000 & this.firstElement >= -10000) {
            if (this.difference <= 10000 & this.difference >= -10000) {
                if (this.n <= 10000 & this.n >= -10000) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getSum() {
        return sum;
    }
}
