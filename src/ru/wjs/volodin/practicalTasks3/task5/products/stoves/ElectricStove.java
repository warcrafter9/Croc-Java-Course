package ru.wjs.volodin.practicalTasks3.task5.products.stoves;

public class ElectricStove extends Stove{
 private String typeOfHeatingElement;

    public ElectricStove(int price, String description, int length, int width, int height, String color,
                         String countryOfOrigin, boolean hasWarranty, int numberOfBurners, boolean hasOven,String typeOfHeatingElement) {
        super(price, description, length, width, height, color, countryOfOrigin, hasWarranty, numberOfBurners, hasOven);
        this.typeOfHeatingElement=typeOfHeatingElement;
    }

    @Override
    public String toString() {
        return upgradeToString();
    }
    private String upgradeToString(){
        return super.toString() + String.format("Тип нагревательного элемента: %s \n",getTypeOfHeatingElement());
    }

    public String getTypeOfHeatingElement() {
        return typeOfHeatingElement;
    }

    public void setTypeOfHeatingElement(String typeOfHeatingElement) {
        this.typeOfHeatingElement = typeOfHeatingElement;
    }
}
