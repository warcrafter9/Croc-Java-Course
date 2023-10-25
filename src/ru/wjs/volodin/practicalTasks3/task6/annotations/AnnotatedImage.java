package ru.wjs.volodin.practicalTasks3.task6.annotations;

import ru.wjs.volodin.practicalTasks3.task6.Point;
import ru.wjs.volodin.practicalTasks3.task6.figures.Circle;
import ru.wjs.volodin.practicalTasks3.task6.figures.Rectangle;

public class AnnotatedImage {
    private final String imagePath;

    private final Annotation[] annotations;

    public AnnotatedImage(String imagePath, Annotation... annotations) {
        this.imagePath = imagePath;
        this.annotations = annotations;
    }

    public Annotation findByPoint(Point point) {
        Annotation[] tempArray = this.getAnnotations();
        for (Annotation annotation : tempArray) {
            if (annotation.getFigure() instanceof Rectangle rectangle) {
                if (rectangle.containsPoint(point)) {
                    return annotation;
                }
            } else if (annotation.getFigure() instanceof Circle circle) {
                if (circle.containsPoint(point)) {
                    return annotation;
                }
            }
        }
        return null;
    }
    public Annotation findByLabel(String labelToCheck){
        Annotation[] tempArray =this.getAnnotations();
        for(Annotation annotation: tempArray){
            if(labelToCheck.contains(annotation.getLabel())){
                return annotation;
            }
        }
        return null;
    }


    public String getImagePath() {
        return this.imagePath;
    }

    public Annotation[] getAnnotations() {
        return this.annotations;
    }


}


