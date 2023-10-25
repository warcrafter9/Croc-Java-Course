package ru.wjs.volodin.praticalTasks3.task6;

public class Point {
    private int x;
    private int y;
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }
    public String coordinatesToString(){
        return String.format("(%d,%d)",getX(),getY());
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj==null || obj.getClass() !=this.getClass()){
            return false;
        }else{
            Point point = (Point) obj;
            if(this.x==point.x &&this.y == point.y){
                return true;
            }
        }
       return false;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
