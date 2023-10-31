package ru.wjs.volodin.practicalTasks3.task6.annotations;

import ru.wjs.volodin.practicalTasks3.task6.figures.Figure;

public class Annotation {
    private String label;
    private Figure figure;

    public Annotation(Figure figure, String label) {
        this.figure = figure;
        this.label = label;
    }

    @Override
    public String toString() {
        return getFigure().toString() + ": " + getLabel();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

}


