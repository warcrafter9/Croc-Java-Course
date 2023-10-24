package ru.wjs.volodin.practicalTasks3.task5.refrigerators;

import ru.wjs.volodin.practicalTasks3.task5.baseclasses.DefaultAndImportProduct;


public class Fridge extends DefaultAndImportProduct {

    private int tempOfRefrigeratingChamberMin;
    private int tempOfRefrigeratingChamberMax;

    public Fridge(int price, String description, int length, int width, int height, String color, String countryOfOrigin,
                  boolean hasWarranty, int tempOfRefrigeratingChamberMin, int tempOfRefrigeratingChamberMax) {
        super(price, description, length, width, height, color, countryOfOrigin, hasWarranty);
        this.tempOfRefrigeratingChamberMin = tempOfRefrigeratingChamberMin;
        this.tempOfRefrigeratingChamberMax = tempOfRefrigeratingChamberMax;
    }


    @Override
    public String toString() {
        return upgradeToString();
    }

    private String upgradeToString() { // с этим методом вроде более читаемо, но в правильности такого подхода не уверен
        return super.toString() + String.format("Температура холодильной камеры min: %d °С; Температура холодильной камеры max: %d °С;\n",
                getTempOfRefrigeratingChamberMin(), getTempOfRefrigeratingChamberMax());
    }

    public void setTempOfRefrigeratingChamberMin(int tempOfRefrigeratingChamberMin) {
        this.tempOfRefrigeratingChamberMin = tempOfRefrigeratingChamberMin;
    }

    public int getTempOfRefrigeratingChamberMin() {
        return tempOfRefrigeratingChamberMin;
    }

    public void setTempOfRefrigeratingChamberMax(int tempOfRefrigeratingChamberMax) {
        this.tempOfRefrigeratingChamberMax = tempOfRefrigeratingChamberMax;
    }

    public int getTempOfRefrigeratingChamberMax() {
        return tempOfRefrigeratingChamberMax;
    }

}
