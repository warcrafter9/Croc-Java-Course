package ru.wjs.volodin.practicalTasks3.task5.importedproducts.importedwashingmachines;

import ru.wjs.volodin.practicalTasks3.task5.importedproducts.Importable;
import ru.wjs.volodin.practicalTasks3.task5.products.washingMachines.WashingMachine;

public class ImportWashingMachine extends WashingMachine implements Importable {
    public ImportWashingMachine(int price, String description, int length, int width, int height, String color, String countryOfOrigin, boolean hasWarranty, int capacityForWashing) {
        super(price, description, length, width, height, color, countryOfOrigin, hasWarranty, capacityForWashing);
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
