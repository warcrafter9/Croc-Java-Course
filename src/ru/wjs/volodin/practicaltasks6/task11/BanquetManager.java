package ru.wjs.volodin.practicaltasks6.task11;


import java.util.*;
import java.util.function.Predicate;


public class BanquetManager {
    public static HashMap<Cook, Set<Dish>> cookListHashMap = new HashMap<>();

    public void addCook(Cook cook, Set<Dish> dishes) {
        cookListHashMap.put(cook, dishes);
    }

    public void removeCook(Cook cook) {
        cookListHashMap.remove(cook);
    }

    public List<Cook> getCooks() {
        return new ArrayList<>(cookListHashMap.keySet());
    }

    private static List<Dish> createMenu(List<Cook> workingCooks, List<String> missingIngredients) {
        Set<Dish> menuWithoutRepeat = new HashSet<>();
        for (Cook cook : workingCooks) {
            if (cookListHashMap.containsKey(cook)) {
                List<Dish> dishes = new ArrayList<>(cookListHashMap.get(cook));
                for (Dish dish : dishes) {
                    if (canCook(dish, missingIngredients)) {
                        menuWithoutRepeat.add(dish);
                    }
                }
            }
        }
        List<Dish> menu = new ArrayList<>(menuWithoutRepeat);
        menu.sort(Comparator.reverseOrder());
        return menu;
    }

    public static List<Dish> createSortedMenu(List<Cook> workingCooks, List<String> missingIngredients, int numberDishes) {
        List<Dish> menu = createMenu(workingCooks, missingIngredients);
        return menu.size() < numberDishes ? menu.subList(0, menu.size()) : menu.subList(0, numberDishes);
    }

    /**
     * @param requirement        особые требования к блюду.
     * @param workingCooks       рабочие повара сегодня
     * @param missingIngredients недостающие ингредиенты
     * @param numberDishes       необходимое количество блюд
     * @return меню с учетом капризов его высочества
     */
    public static List<Dish> createMenuWithSpecialRequirements(Predicate<Dish> requirement, List<Cook> workingCooks, List<String> missingIngredients, int numberDishes) {
        List<Dish> menu = createMenu(workingCooks, missingIngredients);
        List<Dish> menuWithRequirements = new ArrayList<>();
        for (Dish dish : menu) {
            if (requirement.test(dish)) {
                menuWithRequirements.add(dish);
            }
        }
        return  menuWithRequirements.size() < numberDishes ? menuWithRequirements.subList(0, menuWithRequirements.size()) : menuWithRequirements.subList(0, numberDishes);
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
            return dish.getIngredients().contains("Клубника");// то есть, если оно совпадет, то моим дефолтным методом не будет добавлено в отфильтрованные коммент.
        };
    }
}


