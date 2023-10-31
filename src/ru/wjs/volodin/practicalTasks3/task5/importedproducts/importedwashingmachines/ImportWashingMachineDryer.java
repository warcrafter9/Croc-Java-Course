package ru.wjs.volodin.practicalTasks3.task5.importedproducts.importedwashingmachines;

import ru.wjs.volodin.practicalTasks3.task5.importedproducts.Importable;
import ru.wjs.volodin.practicalTasks3.task5.products.washingMachines.WashingMachineDryer;

public class ImportWashingMachineDryer extends WashingMachineDryer implements Importable {
    public ImportWashingMachineDryer(int price, String description, int length, int width, int height, String color, String countryOfOrigin, boolean hasWarranty, int capacityForWashing, int capacityForDrying) {
        super(price, description, length, width, height, color, countryOfOrigin, hasWarranty, capacityForWashing, capacityForDrying);
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
