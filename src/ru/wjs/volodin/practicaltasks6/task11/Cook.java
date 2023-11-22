package ru.wjs.volodin.practicaltasks6.task11;

import java.util.Objects;

public class Cook {
    String name;
    public Cook(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Повар:" + name;
    }

   @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if(!(obj instanceof Cook cook)) {
            return false;
        }
        return name!=null && (name.equals(cook.getName()));

    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
