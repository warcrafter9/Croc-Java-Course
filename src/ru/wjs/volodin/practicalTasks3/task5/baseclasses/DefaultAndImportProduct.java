package ru.wjs.volodin.practicalTasks3.task5.baseclasses;

import ru.wjs.volodin.practicalTasks3.task5.baseclasses.DefaultProduct;

public abstract class DefaultAndImportProduct extends DefaultProduct {
    private String countryOfOrigin;
    private boolean hasWarranty;
     private static int count;


    public DefaultAndImportProduct(int price, String description, int length, int width, int height, String color, String countryOfOrigin, boolean hasWarranty) {
        super(price, description, length, width, height, color);
        this.countryOfOrigin=countryOfOrigin;
        this.hasWarranty=hasWarranty;
        count++;
    }
    public static int getCount(){
        return count;
    }

    @Override
    public String toString() {
        if (getCountryOfOrigin().equalsIgnoreCase("Россия") ||getCountryOfOrigin().equalsIgnoreCase("Russia")) {
            return super.toString();
        } else {
            return upgradeToString();
        }
    }
    private String upgradeToString(){
        return super.toString() + String.format("Страна производства: %s; Гарантия производителя: %s;\n",countryOfOrigin,
                printHasWarranty());
    }
    private String printHasWarranty(){
        return (isHasWarranty())? "Имеется гарантия":"Нет гарантии";
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
