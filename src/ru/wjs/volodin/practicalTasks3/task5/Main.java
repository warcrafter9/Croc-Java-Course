package ru.wjs.volodin.practicalTasks3.task5;
import ru.wjs.volodin.practicalTasks3.task5.baseclasses.Product;
import ru.wjs.volodin.practicalTasks3.task5.importedproducts.importedrefrigerators.ImportFridge;
import ru.wjs.volodin.practicalTasks3.task5.importedproducts.importedrefrigerators.ImportFridgeWithFreezingChamber;
import ru.wjs.volodin.practicalTasks3.task5.importedproducts.importedstoves.ImportElecticStove;
import ru.wjs.volodin.practicalTasks3.task5.importedproducts.importedwashingmachines.ImportWashingMachine;
import ru.wjs.volodin.practicalTasks3.task5.products.refrigerators.Fridge;
import ru.wjs.volodin.practicalTasks3.task5.products.refrigerators.MiniFridge;
import ru.wjs.volodin.practicalTasks3.task5.products.stoves.ElectricStove;
import ru.wjs.volodin.practicalTasks3.task5.products.stoves.GasStove;
import ru.wjs.volodin.practicalTasks3.task5.products.washingMachines.WashingMachine;
import ru.wjs.volodin.practicalTasks3.task5.products.washingMachines.WashingMachineDryer;


public class Main {
    public static void main(String[] args) {
        Product[] newCatalog;

       Fridge fridge=new Fridge(80_000,"Холодильник...",65,32,70,"Черный",
                "Россия", true, 0, 8);
        ImportFridge fridgeImport=new ImportFridge(80_000,"Холодильник...",65,32,70,"Черный",
                "США", true, 0, 8);

        ImportFridgeWithFreezingChamber fridgeWithFreezingChamber = new ImportFridgeWithFreezingChamber(100_000,
                "Холодильник с морозилкой", 65,32,80, "Белый","Франция",true,
                0,8,-10);

         MiniFridge miniFridge=new MiniFridge(15_000,"Мини-холодильник",15,20,20,"Белый",
                 "Россия",false, -15,0,8);

        WashingMachine washingMachine=new WashingMachine(50_000,"Стиральная машина",50,30,50,
                "Белый", "Россия",true,8);
        ImportWashingMachine washingMachineImport=new ImportWashingMachine(50_000,"Стиральная машина",50,30,50,
                "Белый", "Китай",false,9);

        WashingMachineDryer washingMachineDryer = new WashingMachineDryer(60_000,"Стиральная машина с сушкой",
                50,30,60,"Белый","Россия",false,8,5);

        ElectricStove electricStove=new ElectricStove(40_000,"Эл.плита",50,60,70,"Черный",
                "Россия",true,4,true,"индукционный");
        ImportElecticStove electricStoveImport=new ImportElecticStove(40_000,"Эл.плита",50,60,70,"Черный",
                "Китай",true,4,true,"индукционный");
        GasStove gasStove=new GasStove(30_000,"Газ.плита",50,60,70,"Черный",
                "Россия",true,4,true,true);

        newCatalog = Catalog.productToCatalog(fridge,fridgeImport,fridgeWithFreezingChamber,miniFridge,washingMachine,washingMachineImport,
                washingMachineDryer,electricStove,electricStoveImport,gasStove);

        Catalog.printCatalog(newCatalog);
    }
}
