package ru.wjs.volodin.practicalTasks3.task5.stoves;

public class GasStove extends Stove {
    private boolean hasGasControlOfBurners; //наличие газ-контроля конфорок

    public GasStove(int price, String description, int length, int width, int height, String color,
                    String countryOfOrigin, boolean hasWarranty, int numberOfBurners, boolean hasOven,boolean hasGasControlOfBurners) {
        super(price, description, length, width, height, color, countryOfOrigin, hasWarranty, numberOfBurners, hasOven);
        this.setHasGasControlOfBurners(hasGasControlOfBurners);
    }

    @Override
    public String toString() {
        return upgradeToString();
    }
    private String upgradeToString(){
        return super.toString() + String.format("Наличие газ-контроля конфорок: %s", printHasGasControlOfBurners());
    }

    public boolean isHasGasControlOfBurners() {
        return hasGasControlOfBurners;
    }
    public String printHasGasControlOfBurners(){
        return isHasGasControlOfBurners()? "есть": "нет";
    }

    public void setHasGasControlOfBurners(boolean hasGasControlOfBurners) {
        this.hasGasControlOfBurners = hasGasControlOfBurners;
    }
}
