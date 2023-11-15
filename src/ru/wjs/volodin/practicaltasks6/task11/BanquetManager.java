package ru.wjs.volodin.practicaltasks6.task11;


import java.util.*;
import java.util.function.Predicate;


public class BanquetManager {
   public static HashMap<Cook, List<Dish>> cookListHashMap;

    public BanquetManager() {
        cookListHashMap = new HashMap<>();
    }

    public void addCook(Cook cook, List<Dish> dishes) {
        cookListHashMap.put(cook, dishes);
    }

    public void removeCook(Cook cook) {
        cookListHashMap.remove(cook);
    }

    public static List<Dish> createMenu(List<Cook> workingCooks, List<String> missingIngredients, int numberDishes) {
        List<Dish> menu = new ArrayList<>();
        for (Cook cook : workingCooks) {
            List<Dish> dishes = cookListHashMap.get(cook);
            for (Dish dish : dishes) {
                if (canCook(dish, missingIngredients)) {
                    menu.add(dish);
                }
            }
        }
        menu.sort(Comparator.reverseOrder());

        return menu.subList(0, menu.size());
    }

    /**
     * @param requirement        особые требования к блюду.
     * @param workingCooks       рабочие повара сегодня
     * @param missingIngredients недостающие ингредиенты
     * @param numberDishes       необходимое количество блюд
     * @return меню с учетом капризов его высочества
     */
    public static List<Dish> createMenuWithSpecialRequirements(Predicate<Dish> requirement, List<Cook> workingCooks, List<String> missingIngredients, int numberDishes) {
        List<Dish> menu = createMenu(workingCooks, missingIngredients, numberDishes);
        List<Dish> menuWithRequirements = new ArrayList<>();
        for (Dish dish : menu) {
            if (requirement.test(dish)) {
                menuWithRequirements.add(dish);
            }
        }
        return menuWithRequirements;
    }

    private static boolean canCook(Dish dish, List<String> missingIngredients) {
        for (String ingredient : dish.getIngredients()) {
            for (String missingIngredient : missingIngredients) {
                if (ingredient.equalsIgnoreCase(missingIngredient)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Predicate<Dish> createRequirementStrawberry() {
        return dish -> {
            if (dish.getIngredients().contains("Клубника")) {
                return true;
            }
            return false; // то есть, если оно совпадет, то моим дефолтным методом не будет добавлено в отфильтрованные коммент.
        };
    }
}


