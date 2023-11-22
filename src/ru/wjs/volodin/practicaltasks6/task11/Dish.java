package ru.wjs.volodin.practicaltasks6.task11;


import java.util.Objects;
import java.util.Set;

/**
 * Блюдо
 */
public class Dish implements Comparable<Dish> {
    private final String name;
    private final Set<String> ingredients;
    private final DishCategory category;
    private int royalRating;
    /**
     * Рейтинг блюда от придворных
     */
    private int courtRating;

    public String getName() {
        return name;
    }

    public Set<String> getIngredients() {
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


    public Dish(String name, Set<String> ingredients, DishCategory category, int royalRating, int courtRating) {
        this.name = name;
        this.ingredients = ingredients;
        this.category = category;
        if (royalRating <= 100) {
            this.royalRating = royalRating;
        } else {
            throw new IllegalRatingException(royalRating);
        }
        if (courtRating <= 100) {
            this.courtRating = courtRating;
        } else {
            throw new IllegalRatingException(courtRating);
        }
    }


    @Override
    public int compareTo(Dish dish2) {
        int result = Integer.compare(royalRating, dish2.royalRating);
        if (result == 0) {
            return Integer.compare(courtRating, dish2.courtRating);
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if(!(obj instanceof Dish dish)) {
            return false;
        }
        return ingredients!=null && (ingredients.equals(dish.getIngredients()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredients,getIngredients());
    }
}
