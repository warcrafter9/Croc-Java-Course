package ru.wjs.volodin.practicaltasks6.task11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ru.wjs.volodin.practicaltasks6.task11.DishCategory.DESSERT;
import static ru.wjs.volodin.practicaltasks6.task11.DishCategory.MAINDISH;

public class Main {
    public static void main(String[] args) {
        Cook cook1 = new Cook("Алексей");
        Cook cook2 = new Cook("Александра");

        Dish dish1 = new Dish("Торт", Arrays.asList("Орехи", "Коржи"), DESSERT, 92, 95);
        Dish dish2 = new Dish("Стейк", Arrays.asList("Мясо", "Соль", "Перец"), MAINDISH, 95, 88);
        Dish dish3 = new Dish("что-то шоколадное", Arrays.asList("Шоколад", "Коржи", "Сахар"), DESSERT, 92, 90);

      //  ArrayList dishesCook1= new ArrayList<>();  -> Arrays.asList("")
       // dishesCook1.add(dish1);

        BanquetManager banquetManager = new BanquetManager();
        banquetManager.addCook(cook1, Arrays.asList(dish1, dish2));
        banquetManager.addCook(cook2, Arrays.asList(dish2, dish3));

        List<Cook> workingCooks = Arrays.asList(cook1, cook2);
        List<String> missingIngredients = Arrays.asList("Соль","Перец");
        int numberOfDishes = 2;

        List<Dish> menu = BanquetManager.createMenu(workingCooks,missingIngredients,numberOfDishes);
        System.out.println("Меню: ");
        for (Dish dish : menu) {
            System.out.println("- " + dish.getName());
        }

    }
}
