package ru.wjs.volodin.practicaltasks6.task11;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


public class BanquetManager {
    static HashMap<Cook, List<Dish>> cookListHashMap;
   public BanquetManager(){
       cookListHashMap = new HashMap<>();
    }
   public void addCook(Cook cook, List<Dish> dishes){
       cookListHashMap.put(cook,dishes);
    }
    public void removeCook(Cook cook){
       cookListHashMap.remove(cook);
    }
    public static List<Dish> createMenu(List<Cook> workingCooks, List<String> missingIngredients, int numberDishes){
        List<Dish> menu = new ArrayList<>();
        for(Cook cook:workingCooks){
            List<Dish> dishes = cookListHashMap.get(cook);
            for(Dish dish:dishes){
                if(canCook(dish,missingIngredients)){
                    menu.add(dish);
                }
            }
        }
        menu.sort(Comparator.reverseOrder());

        return menu.subList(0,Math.min(menu.size(), numberDishes)); // чтоб не оставлять полупустой список, если вдруг блюд не хватит
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
    }


