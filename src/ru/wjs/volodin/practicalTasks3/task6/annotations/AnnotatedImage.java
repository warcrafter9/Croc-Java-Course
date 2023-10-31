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
            if (annotation.getFigure().containsPoint(point)) {
                return annotation;
            }
        }
        return null;
    }

    public Annotation findByLabel(String labelToCheck) {
        Annotation[] tempArray = this.getAnnotations();
        for (Annotation annotation : tempArray) {
            if (annotation.getLabel().contains(labelToCheck)) {
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


