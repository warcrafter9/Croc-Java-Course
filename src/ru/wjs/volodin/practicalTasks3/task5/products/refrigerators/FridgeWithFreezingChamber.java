package ru.wjs.volodin.practicalTasks3.task5.products.refrigerators;

public class FridgeWithFreezingChamber extends Fridge {
 private int temperatureFreezingChamberMin;

    public FridgeWithFreezingChamber(int price, String description, int length, int width, int height, String color,
                                     String countryOfOrigin, boolean hasWarranty,
                                     int tempOfRefrigeratingChamberMin, int tempOfRefrigeratingChamberMax,
                                     int temperatureFreezingChamber) {
        super(price, description, length, width, height, color, countryOfOrigin, hasWarranty, tempOfRefrigeratingChamberMin, tempOfRefrigeratingChamberMax);
        this.temperatureFreezingChamberMin =temperatureFreezingChamber;
    }

    @Override
    public String toString() {
        return upgradeToString();
    }
    private String upgradeToString(){
        return super.toString() + String.format("Температура морозильной камеры min: %d;\n",getTemperatureFreezingChamberMin());
    }

    public int getTemperatureFreezingChamberMin() {
        return temperatureFreezingChamberMin;
    }

    public void setTemperatureFreezingChamberMin(int temperatureFreezingChamberMin) {
        this.temperatureFreezingChamberMin = temperatureFreezingChamberMin;
    }
}
