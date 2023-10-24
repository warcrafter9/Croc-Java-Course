package ru.wjs.volodin.practicalTasks3.task5.baseclasses;

public abstract class DefaultProduct { // Бытовые товары
    private int price;
    private String description;
    private int length;
    private int width;
    private int height;
    private String color;


    public DefaultProduct(int price, String description, int length, int width,
                          int height, String color) {
        this.price = price;
        this.description = description;
        this.length = length;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("Цена: %d; Описание товара:%s; Размеры (ШхВхГ): %d x %d x %d; Цвет: %s; \n",
                getPrice(), getDescription(),
                getLength(), getWidth(),
                getHeight(), getColor());
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}

