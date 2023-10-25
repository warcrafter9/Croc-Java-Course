package ru.wjs.volodin.practicalTasks3.task6;

import ru.wjs.volodin.practicalTasks3.task6.annotations.Annotation;
import ru.wjs.volodin.practicalTasks3.task6.figures.Circle;
import ru.wjs.volodin.practicalTasks3.task6.figures.Rectangle;

public class Main {
    public static void main(String[] args) {
        Point rectangleP1=new Point(1,1);
        Point rectangleP2=new Point(4,3);
        Point circleCenter1=new Point(5,5);
        Rectangle rectangle=new Rectangle(rectangleP1,rectangleP2);
        Circle circle=new Circle(circleCenter1,5);
        Annotation annotation1=new Annotation(rectangle,"Car");
        Annotation annotation2=new Annotation(circle,"Cat");
        System.out.println(annotation1);
        System.out.println(annotation2);
        rectangle.move(5,5);
        circle.move(4,2);
        System.out.println(annotation1);
        System.out.println(annotation2);
    }
}
