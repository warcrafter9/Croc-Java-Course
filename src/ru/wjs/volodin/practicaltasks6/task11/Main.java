package ru.wjs.volodin.practicaltasks6.task11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ru.wjs.volodin.practicaltasks6.task11.BanquetManager.createMenuWithSpecialRequirements;
import static ru.wjs.volodin.practicaltasks6.task11.BanquetManager.createRequirementStrawberry;
import static ru.wjs.volodin.practicaltasks6.task11.DishCategory.*;

public class Main {
    public static void main(String[] args) {
        Cook cook1 = new Cook("Алексей");
        Cook cook2 = new Cook("Александра");
        Cook cook3 = new Cook("Анатолий");

        Dish dish1 = new Dish("Торт", Arrays.asList("Орехи", "Коржи","Клубника"), DESSERT, 75, 95);
        Dish dish2 = new Dish("Стейк", Arrays.asList("Мясо", "Соль", "Перец"), MAINDISH, 99, 88);
        Dish dish3 = new Dish("Тарталетки", Arrays.asList("Яйца", "Майонез","Колбаса"), SNACK, 75, 95);
        Dish dish4 = new Dish("что-то шоколадное", Arrays.asList("Шоколад", "Мука", "Сахар","Клубника"), DESSERT, 92, 90);
        Dish dish5 = new Dish("Клубничный мусс", Arrays.asList("Сливки", "Вода", "Сахар","Клубника"), DESSERT, 92, 92);

      //  ArrayList dishesCook1= new ArrayList<>();  -> Arrays.asList("")
       // dishesCook1.add(dish1);

        BanquetManager banquetManager = new BanquetManager();
        banquetManager.addCook(cook1, Arrays.asList(dish1, dish2));
        banquetManager.addCook(cook2, Arrays.asList(dish2, dish3));
        banquetManager.addCook(cook3,Arrays.asList(dish4,dish5));

        List<Cook> workingCooks1 = Arrays.asList(cook1, cook2);
        List<Cook> workingCooks2 = Arrays.asList(cook1, cook3);

        List<String> missingIngredients1 = Arrays.asList("Соль","Перец");// -стейк
        List<String> missingIngredients2 = Arrays.asList("Вода"); // -клубничный мусс
        int numberOfDishes1=4;
        int numberOfDishes2=3;


        List<Dish> menu = BanquetManager.createMenu(workingCooks1,missingIngredients1,numberOfDishes1);
        List<Dish> menuWithSpecialRequirements = createMenuWithSpecialRequirements(createRequirementStrawberry(),workingCooks2,missingIngredients2,numberOfDishes2);
        System.out.println("Меню - 1 (без специальных требований): ");
        for (Dish dish : menu) {
            System.out.println("- " + dish.getName());
        }
        System.out.println("Меню - 2 (со специальными требованиями): ");
        for (Dish dish : menuWithSpecialRequirements) {
            System.out.println("- " + dish.getName());
        }

    }
}
