package ru.wjs.volodin.practicalTasks3.task5;
import ru.wjs.volodin.practicalTasks3.task5.baseclasses.DefaultAndImportProduct;
import ru.wjs.volodin.practicalTasks3.task5.baseclasses.DefaultProduct;
import ru.wjs.volodin.practicalTasks3.task5.refrigerators.Fridge;
import ru.wjs.volodin.practicalTasks3.task5.refrigerators.FridgeWithFreezingChamber;
import ru.wjs.volodin.practicalTasks3.task5.refrigerators.MiniFridge;
import ru.wjs.volodin.practicalTasks3.task5.stoves.ElectricStove;
import ru.wjs.volodin.practicalTasks3.task5.stoves.GasStove;
import ru.wjs.volodin.practicalTasks3.task5.washingMachines.WashingMachine;
import ru.wjs.volodin.practicalTasks3.task5.washingMachines.WashingMachineDryer;


public class Main {
    public static void main(String[] args) {
        DefaultAndImportProduct[] newCatalog;

        Fridge fridge=new Fridge(80_000,"Холодильник...",65,32,70,"Черный",
                "Russia", true, 0, 8);

        FridgeWithFreezingChamber fridgeWithFreezingChamber = new FridgeWithFreezingChamber(100_000,
                "Холодильник с морозилкой", 65,32,80, "Белый","Франция",true,
                0,8,-10);

         MiniFridge miniFridge=new MiniFridge(15_000,"Мини-холодильник",15,20,20,"Белый",
                 "США",false, -15,0,8);

        WashingMachine washingMachine=new WashingMachine(50_000,"Стиральная машина",50,30,50,
                "Белый", "Russia",true,8);

        WashingMachineDryer washingMachineDryer = new WashingMachineDryer(60_000,"Стиральная машина с сушкой",
                50,30,60,"Белый","Россия",false,8,5);

        ElectricStove electricStove=new ElectricStove(40_000,"Эл.плита",50,60,70,"Черный",
                "Китай",true,4,true,"индукционный");
        GasStove gasStove=new GasStove(30_000,"Газ.плита",50,60,70,"Черный",
                "Россия",true,4,true,true);

        newCatalog = Catalog.productToCatalog(fridge,fridgeWithFreezingChamber,miniFridge,washingMachine,washingMachineDryer,electricStove,gasStove);
        Catalog.printCatalog(newCatalog);
    }
}
