package ru.wjs.volodin.practicalTasks3.task6.figures;

import ru.wjs.volodin.practicalTasks3.task6.Point;

public class Rectangle extends Figure {
   private Point firstPoint;
    private Point secondPoint;
    public Rectangle(Point firstPoint,Point secondPoint){
        this.firstPoint=firstPoint;
        this.secondPoint=secondPoint;
    }

    @Override
    public String toString() {
        return upgradeToString();
    }
    private String upgradeToString(){
        return String.format("Rectangle %s, %s",firstPoint.coordinatesToString(),secondPoint.coordinatesToString());
    }
    @Override
    public void move(int dx, int dy) {
        firstPoint.setX(getFirstPoint().getX()+dx);
        firstPoint.setY(getFirstPoint().getY()+dy);
        secondPoint.setX(getSecondPoint().getX()+dx);
        secondPoint.setY(getSecondPoint().getY()+dy);
    }

    @Override
    public boolean containsPoint(Point pointToCheck){
        if(pointToCheck.getX() >= getFirstPoint().getX() && pointToCheck.getX()<= getSecondPoint().getX()){
            if(pointToCheck.getY() >= getFirstPoint().getY() && pointToCheck.getY() <= getSecondPoint().getY()){
                return true;
            }
        }
        return false;
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
    }

}
