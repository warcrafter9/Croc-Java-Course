package ru.wjs.volodin.practicalTasks3.task5.importedproducts.importedstoves;

import ru.wjs.volodin.practicalTasks3.task5.importedproducts.Importable;
import ru.wjs.volodin.practicalTasks3.task5.products.stoves.GasStove;

public class ImportGasStove extends GasStove implements Importable {
    public ImportGasStove(int price, String description, int length, int width, int height, String color, String countryOfOrigin, boolean hasWarranty, int numberOfBurners, boolean hasOven, boolean hasGasControlOfBurners) {
        super(price, description, length, width, height, color, countryOfOrigin, hasWarranty, numberOfBurners, hasOven, hasGasControlOfBurners);
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
