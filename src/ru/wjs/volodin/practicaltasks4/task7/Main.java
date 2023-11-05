package ru.wjs.volodin.practicaltasks4.task7;

import ru.wjs.volodin.practicalTasks3.task5.importedproducts.importedwashingmachines.ImportWashingMachine;
import ru.wjs.volodin.practicalTasks3.task5.products.refrigerators.Fridge;

public class Main {
    public static void main(String[] args) {
        Fridge fridge = new Fridge(80_000, "Холодильник...", 65, 32, 70, "Черный",
                "Россия", true, 0, 8);
        ImportWashingMachine washingMachineImport=new ImportWashingMachine(50_000,"Стиральная машина",
                50,30,50, "Белый", "Китай",false,9);
        Order testOrder = new Order("Valery", "89193412871", fridge,washingMachineImport);
        System.out.println( testOrder.generateMessage());
    }
}
