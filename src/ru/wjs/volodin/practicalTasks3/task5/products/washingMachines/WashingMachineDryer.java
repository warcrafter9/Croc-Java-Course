package ru.wjs.volodin.practicalTasks3.task5.products.washingMachines;

public class WashingMachineDryer extends WashingMachine{
    private int capacityForDrying; // загрузка для сушки(кг)

    public WashingMachineDryer(int price, String description, int length, int width, int height, String color,
                               String countryOfOrigin, boolean hasWarranty, int capacityForWashing,int capacityForDrying) {
        super(price, description, length, width, height, color, countryOfOrigin, hasWarranty, capacityForWashing);
        this.setCapacityForDrying(capacityForDrying);
    }

    @Override
    public String toString() {
        return upgradeToString();
    }
    private String upgradeToString(){
        return super.toString()+String.format("Загрузка белья для сушки: %d кг",getCapacityForDrying());
    }

    public int getCapacityForDrying() {
        return capacityForDrying;
    }

    public void setCapacityForDrying(int capacityForDrying) {
        this.capacityForDrying = capacityForDrying;
    }
}
