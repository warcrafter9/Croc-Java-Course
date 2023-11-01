package ru.wjs.volodin.practicaltasks4.task7;

public class Main {
    public static void main(String[] args) {
        Order myOrder = new Order("Valery","89194231891","товар1","товар2","товар3");
        System.out.println(myOrder.generateMessage());
    }
}
