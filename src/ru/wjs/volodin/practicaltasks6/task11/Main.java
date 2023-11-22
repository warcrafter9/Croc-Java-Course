package ru.wjs.volodin.practicaltasks6.task11;

import java.util.*;

import static ru.wjs.volodin.practicaltasks6.task11.BanquetManager.createMenuWithSpecialRequirements;
import static ru.wjs.volodin.practicaltasks6.task11.BanquetManager.createRequirementStrawberry;
import static ru.wjs.volodin.practicaltasks6.task11.DishCategory.*;

public class Main {
    public static void main(String[] args) {
        Cook cook1 = new Cook("Алексей");
        Cook cook2 = new Cook("Александра");
        Cook cook3 = new Cook("Анатолий");

        Set<String> ingredientsCake = new HashSet<>(Arrays.asList("Орехи", "Коржи", "Клубника"));
        Set<String> ingredientsSteak = new HashSet<>(Arrays.asList("Мясо", "Соль", "Перец"));
        Set<String> ingredientsTartlets = new HashSet<>(Arrays.asList("Яйца", "Майонез", "Колбаса"));
        Set<String> ingredientsChocolate = new HashSet<>(Arrays.asList("Шоколад", "Мука", "Сахар", "Клубника"));
        Set<String> ingredientsMousse = new HashSet<>(Arrays.asList("Сливки", "Вода", "Сахар", "Клубника"));

        Dish dish1 = new Dish("Торт", ingredientsCake, DESSERT, 75, 96);
        Dish dish2 = new Dish("Стейк", ingredientsSteak, MAINDISH, 99, 88);
        Dish dish3 = new Dish("Тарталетки", ingredientsTartlets, SNACK, 75, 94);
        Dish dish4 = new Dish("что-то шоколадное", ingredientsChocolate, DESSERT, 92, 90);
        Dish dish5 = new Dish("Клубничный мусс", ingredientsMousse, DESSERT, 92, 92);


        Set<Dish> cookDishes1 = new HashSet<>();
        cookDishes1.add(dish1);
        cookDishes1.add(dish2);

        Set<Dish> cookDishes2 = new HashSet<>();
        cookDishes2.add(dish2);
        cookDishes2.add(dish3);

        Set<Dish> cookDishes3 = new HashSet<>();
        cookDishes3.add(dish4);
        cookDishes3.add(dish5);

        // Создадим нового повара Алексея
        Cook cookTest = new Cook("Алексей");

        BanquetManager banquetManager = new BanquetManager();
        banquetManager.addCook(cook1, cookDishes1);
        banquetManager.addCook(cookTest, cookDishes1); // проверяем, чтоб не было дублирования Алексеев
        banquetManager.addCook(cook2, cookDishes2);
        banquetManager.addCook(cook3, cookDishes3);

        List<Cook> workingCooks1 = Arrays.asList(cook1, cook2);
        List<Cook> workingCooks2 = Arrays.asList(cook1, cook3);

        List<String> missingIngredients = Arrays.asList("Вода"); // -клубничный мусс
        int numberOfDishes1 = 4;
        int numberOfDishes2 = 3;


        List<Dish> menu = BanquetManager.createSortedMenu(workingCooks1, missingIngredients, numberOfDishes1);
        List<Dish> menuWithSpecialRequirements = createMenuWithSpecialRequirements(createRequirementStrawberry(), workingCooks2, missingIngredients, numberOfDishes2);
        System.out.println("Меню - 1 (без специальных требований): ");
        for (Dish dish : menu) {
            System.out.println("- " + dish.getName()+" ||  "+ dish.getRoyalRating()+" и "+ dish.getCourtRating());
        }
        System.out.println("Меню - 2 (со специальными требованиями): ");
        for (Dish dish : menuWithSpecialRequirements) {
            System.out.println("- " + dish.getName()+" ||  "+ dish.getRoyalRating()+" и "+ dish.getCourtRating());
        }
        System.out.println();

        System.out.println("Повара: " + banquetManager.getCooks());
        banquetManager.removeCook(cookTest); // Увольняем Алексея, который умел делать тортики
        System.out.println("Повара после увольнения Алексея: " + banquetManager.getCooks());
        System.out.println();

        List<Dish> menu2 = BanquetManager.createSortedMenu(workingCooks1, missingIngredients, numberOfDishes1);
        List<Dish> menuWithSpecialRequirements2 = createMenuWithSpecialRequirements(createRequirementStrawberry(), workingCooks2, missingIngredients, numberOfDishes2);

        System.out.println("Меню - 1 (без специальных требований) после увольнения: ");
        for (Dish dish : menu2) {
            System.out.println("- " + dish.getName() +" ||  "+ dish.getRoyalRating()+" и "+ dish.getCourtRating());
        }
        System.out.println("Меню - 2 (со специальными требованиями) после увольнения: ");
        for (Dish dish : menuWithSpecialRequirements2) {
            System.out.println("- " + dish.getName()+" ||  "+ dish.getRoyalRating()+" и "+ dish.getCourtRating());
        }

    }
}
