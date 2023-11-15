package ru.wjs.volodin.practicaltasks6.task11;

import java.util.List;

/**
 * Блюдо
 */
public class Dish implements Comparable<Dish> {
    private final String name;
    private List<String> ingredients;
    private DishCategory category;
    private int royalRating;
    private int courtRating;

    public String getName() {
        return name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public DishCategory getCategory() {
        return category;
    }

    public int getRoyalRating() {
        return royalRating;
    }

    public int getCourtRating() {
        return courtRating;
    }

    /**
     * Рейтинг блюда от придворных
     */

    public Dish(String name, List<String> ingredients, DishCategory category, int royalRating, int courtRating) {
        this.name = name;
        this.ingredients = ingredients;
        this.category = category;
        this.royalRating = royalRating;
        this.courtRating = courtRating;

    }


    @Override
    public int compareTo(Dish dish2) {
        int result = Integer.compare(royalRating,dish2.royalRating);
        if(result==0){
            return Integer.compare(courtRating,dish2.courtRating);
        }
        return result;
    }


}
