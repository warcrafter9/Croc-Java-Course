package ru.wjs.volodin.practicalTasks2.task3;

public class PrimeNumbers {
    public static void main(String[] args) {
        checkForPrime(30);
        checkForTwin(5);

    }

    public static boolean checkForPrime(long numberForCheck) {
        if (numberForCheck >= 2 && numberForCheck <= 10_000_000_000L) {
            for (int i = 2; i <= Math.sqrt(numberForCheck); i++) {
                if (numberForCheck % i == 0) {
                    System.out.println("Это число составное");
                    return false;
                }
            }
            System.out.println("Это простое число");
            return true;

        }
        return false;
    }

    public static boolean checkForPrimeWithoutSout(long numberForCheck) { // я просто не хотел лишнего в аутпуте
        if (numberForCheck >= 2 && numberForCheck <= 10_000_000_000L) {// в проверке на близнеца
            for (int i = 2; i <= Math.sqrt(numberForCheck); i++) {
                if (numberForCheck % i == 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean checkForTwin(long numberForCheck) {
        if (checkForPrime(numberForCheck)) {
            if (checkForPrimeWithoutSout(numberForCheck + 2) && checkForPrimeWithoutSout(numberForCheck - 2)) {
                System.out.println("Число является близнецом для чисел " + (numberForCheck + 2) + " и " + (numberForCheck - 2));
                return true;
            } else if (checkForPrimeWithoutSout(numberForCheck + 2)) {
                System.out.println("Число является близнецом числа " + (numberForCheck + 2));
                return true;

            } else if (checkForPrimeWithoutSout(numberForCheck - 2)) {
                System.out.println("Число является близнецом числа " + (numberForCheck - 2));
                return true;
            }
        }
        return false;
    }
}

