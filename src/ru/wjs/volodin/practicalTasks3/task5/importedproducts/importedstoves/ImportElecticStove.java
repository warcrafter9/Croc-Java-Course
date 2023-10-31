package ru.wjs.volodin.practicalTasks3.task5.importedproducts.importedstoves;

import ru.wjs.volodin.practicalTasks3.task5.importedproducts.Importable;
import ru.wjs.volodin.practicalTasks3.task5.products.stoves.ElectricStove;

public class ImportElecticStove extends ElectricStove implements Importable {
    public ImportElecticStove(int price, String description, int length, int width, int height, String color, String countryOfOrigin, boolean hasWarranty, int numberOfBurners, boolean hasOven, String typeOfHeatingElement) {
        super(price, description, length, width, height, color, countryOfOrigin, hasWarranty, numberOfBurners, hasOven, typeOfHeatingElement);
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
