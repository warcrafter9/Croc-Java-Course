package ru.wjs.volodin.practicalTasks3.task5.stoves;

import ru.wjs.volodin.practicalTasks3.task5.baseclasses.DefaultAndImportProduct;

public abstract class Stove extends DefaultAndImportProduct {
    private int numberOfBurners;//количество конфорок
    private boolean hasOven; // наличие духовки

    public Stove(int price, String description, int length, int width, int height, String color,
                 String countryOfOrigin, boolean hasWarranty,int numberOfBurners,boolean hasOven) {
        super(price, description, length, width, height, color, countryOfOrigin, hasWarranty);
        this.numberOfBurners=numberOfBurners;
        this.hasOven=hasOven;
    }

    @Override
    public String toString() {
        return upgradeToString();
    }
    private String upgradeToString(){
        return super.toString() + String.format("Количество конфорок: %d; Наличие духовки: %s\n",getNumberOfBurners(),printHasOven());
    }
    private String printHasOven(){
        return isHasOven()? "есть": "нет";
    }

    public int getNumberOfBurners() {
        return numberOfBurners;
    }

    public void setNumberOfBurners(int numberOfBurners) {
        this.numberOfBurners = numberOfBurners;
    }

    public boolean isHasOven() {
        return hasOven;
    }

    public void setHasOven(boolean hasOven) {
        this.hasOven = hasOven;
    }
}
