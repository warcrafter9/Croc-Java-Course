package ru.wjs.volodin.practicalTasks3.task6.figures;

import ru.wjs.volodin.practicalTasks3.task6.Movable;
import ru.wjs.volodin.practicalTasks3.task6.Point;

public abstract class Figure implements Movable {
    public abstract boolean containsPoint(Point pointToCheck);
}
