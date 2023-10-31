package ru.wjs.volodin.practicalTasks3.task5.baseclasses;

public abstract class Product { // Бытовые товары
    private int price;
    private String description;
    private int length;
    private int width;
    private int height;
    private String color;
    private String countryOfOrigin;
    private boolean hasWarranty;


    public Product(int price, String description, int length, int width,
                   int height, String color, String countryOfOrigin, boolean hasWarranty) {
        this.price = price;
        this.description = description;
        this.length = length;
        this.width = width;
        this.height = height;
        this.color = color;
        this.countryOfOrigin =countryOfOrigin;
        this.hasWarranty=hasWarranty;
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
    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public boolean isHasWarranty() {
        return hasWarranty;
    }
    public void setHasWarranty(boolean hasWarranty) {
        this.hasWarranty = hasWarranty;
    }
}

