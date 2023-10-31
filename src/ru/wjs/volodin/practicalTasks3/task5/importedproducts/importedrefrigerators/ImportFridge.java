package ru.wjs.volodin.practicalTasks3.task5.importedproducts.importedrefrigerators;

import ru.wjs.volodin.practicalTasks3.task5.importedproducts.Importable;
import ru.wjs.volodin.practicalTasks3.task5.products.refrigerators.Fridge;

public class ImportFridge extends Fridge implements Importable {

    public ImportFridge(int price, String description, int length, int width, int height, String color, String countryOfOrigin, boolean hasWarranty, int tempOfRefrigeratingChamberMin, int tempOfRefrigeratingChamberMax) {
        super(price, description, length, width, height, color, countryOfOrigin, hasWarranty, tempOfRefrigeratingChamberMin, tempOfRefrigeratingChamberMax);
    }

    @Override
    public String toString() {
        return super.toString() + printForImport();
    }

    @Override
    public String printForImport() {
        return Importable.super.printForImport();
    }
}


