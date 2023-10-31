package ru.wjs.volodin.practicalTasks3.task5.products.washingMachines;

import ru.wjs.volodin.practicalTasks3.task5.baseclasses.Product;

public class WashingMachine extends Product {

     private int capacityForWashing; // загрузка для стирки(кг)

    public WashingMachine(int price, String description, int length, int width, int height, String color,
                          String countryOfOrigin, boolean hasWarranty,int capacityForWashing) {
        super(price, description, length, width, height, color, countryOfOrigin, hasWarranty);
        this.setCapacityForWashing(capacityForWashing);
    }

    @Override
    public String toString() {
        return upgradeToString();
    }
    private String upgradeToString(){
        return super.toString() + String.format("Загрузка белья для стирки: %d кг;\n",getCapacityForWashing());
    }

    public int getCapacityForWashing() {
        return capacityForWashing;
    }

    public void setCapacityForWashing(int capacityForWashing) {
        this.capacityForWashing = capacityForWashing;
    }
}
