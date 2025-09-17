import java.util.*;

class FoodRatings {
    // Maps each food to its cuisine
    private Map<String, String> foodToCuisine;
    // Maps each food to its current rating
    private Map<String, Integer> foodToRating;
    // Maps each cuisine to an ordered set of foods (sorted by rating + name)
    private Map<String, TreeSet<String>> cuisineToFoods;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineToFoods = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodToCuisine.put(food, cuisine);
            foodToRating.put(food, rating);

            cuisineToFoods.putIfAbsent(cuisine, new TreeSet<>(
                (a, b) -> {
                    int r1 = foodToRating.get(a);
                    int r2 = foodToRating.get(b);
                    if (r1 != r2) return r2 - r1;  // higher rating first
                    return a.compareTo(b);        // lexicographically smaller first
                }
            ));

            cuisineToFoods.get(cuisine).add(food);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        TreeSet<String> foods = cuisineToFoods.get(cuisine);

        // Remove and reinsert to update order
        foods.remove(food);
        foodToRating.put(food, newRating);
        foods.add(food);
    }

    public String highestRated(String cuisine) {
        return cuisineToFoods.get(cuisine).first();
    }
}
