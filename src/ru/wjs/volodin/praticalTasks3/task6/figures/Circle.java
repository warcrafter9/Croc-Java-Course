package ru.wjs.volodin.praticalTasks3.task6.figures;

import ru.wjs.volodin.praticalTasks3.task6.Point;

public class Circle extends Figure {
    private Point center;
    private int radius;


    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public void move(int dx, int dy) {
        this.center.setX(center.getX()+dx);// Не знаю, возможно ли это читать, но лучше вызывать через метод getCenter() или переменной?
        this.center.setY(getCenter().getY()+dy); // Вот такой. В целом, мы же все равно в этом классе, т.е. без разницы?
    }

    @Override
    public boolean containsPoint(Point pointToCheck) {
        if (calculateOfCircle(pointToCheck) < Math.pow(radius, 2)) {
            return true;
        }
        return false;
    }

    private double calculateOfCircle(Point pointToCheck) {
        return Math.pow(pointToCheck.getX() - center.getX(), 2) + Math.pow(pointToCheck.getY() - center.getY(), 2);
    }

    public String toString() {
        return upgradeToString();
    }


    private String upgradeToString() {
        return String.format("Circle %s, r = %d", center.coordinatesToString(), radius);
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

}
