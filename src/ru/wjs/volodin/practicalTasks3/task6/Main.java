package ru.wjs.volodin.practicalTasks3.task6;

import ru.wjs.volodin.practicalTasks3.task6.annotations.AnnotatedImage;
import ru.wjs.volodin.practicalTasks3.task6.annotations.Annotation;
import ru.wjs.volodin.practicalTasks3.task6.figures.Circle;
import ru.wjs.volodin.practicalTasks3.task6.figures.Rectangle;

public class Main {
    public static void main(String[] args) {
        Point rectangleP1=new Point(1,1); // создание точек для аннотаций.
        Point rectangleP2=new Point(4,3);
        Point circleCenter1=new Point(5,5);
        Point checkPoint=new Point(9,8); // точки для проверки на вхождение.
        Point checkPoint1=new Point(5,6);
        Rectangle rectangle=new Rectangle(rectangleP1,rectangleP2);
        Circle circle=new Circle(circleCenter1,5);
        Annotation annotation1=new Annotation(rectangle,"Car");
        Annotation annotation2=new Annotation(circle,"Black cat");
        AnnotatedImage image=new AnnotatedImage("/task6",annotation1,annotation2);
        System.out.println("Найдено по подписи:"+image.findByLabel("Ca"));
        System.out.println("Найдено по подписи:"+image.findByLabel("cat"));
        rectangle.move(3,3);
        circle.move(2,2);
        System.out.println("Проверяем вывод после смещения:");
        System.out.println("Найдено по точке: " + image.findByPoint(checkPoint)); // checkPoint = (9,8);
        System.out.println("Найдено по точке: " + image.findByPoint(checkPoint1)); // checkPoint1 = (5,6);
    }
}
