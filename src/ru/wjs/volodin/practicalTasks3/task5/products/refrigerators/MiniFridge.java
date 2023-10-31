package ru.wjs.volodin.practicalTasks3.task5.products.refrigerators;

public class MiniFridge extends Fridge{

private int batteryLife;

    public MiniFridge(int price, String description, int length, int width, int height, String color,
                      String countryOfOrigin, boolean hasWarranty, int tempOfRefrigeratingChamberMin,
                      int tempOfRefrigeratingChamberMax,int batteryLife) {
        super(price, description, length, width, height, color, countryOfOrigin, hasWarranty,
                tempOfRefrigeratingChamberMin, tempOfRefrigeratingChamberMax);
        this.batteryLife=batteryLife;
    }

    @Override
    public String toString() {
        return upgradeToString();
    }
    private String upgradeToString(){
        return super.toString()+ String.format("Время работы от аккумулятора: %d\n", getBatteryLife());
    }

    public void setBatteryLife(int batteryLife){
        this.batteryLife=batteryLife;
    }
    public int getBatteryLife(){return batteryLife;}

}
