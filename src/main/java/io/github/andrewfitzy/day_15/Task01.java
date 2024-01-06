/* (C)2023 */
package io.github.andrewfitzy.day_15;

import java.util.*;

public final class Task01 {
    private record Ingredient(String name, int capacity, int durability, int flavor, int texture, int calories) {}

    private final List<String> fileContent;

    private static final int AVAILABLE_CAPACITY = 100;

    public Task01(final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();
    }

    public int solve() {
        List<Ingredient> ingredients = new ArrayList<>();
        for (String input : fileContent) {
            String[] parts = input.split(" ");

            String name = parts[0];
            int capacity = Integer.parseInt(parts[2].replace(",", ""));
            int durability = Integer.parseInt(parts[4].replace(",", ""));
            int flavor = Integer.parseInt(parts[6].replace(",", ""));
            int texture = Integer.parseInt(parts[8].replace(",", ""));
            int calories = Integer.parseInt(parts[10].replace(",", ""));

            Ingredient ingredient = new Ingredient(name, capacity, durability, flavor, texture, calories);
            ingredients.add(ingredient);
        }

        List<Map<Ingredient, Integer>> recipeList = new ArrayList<>();
        if (ingredients.size() == 2) {
            recipeList.addAll(getRecipesTwoIngredients(ingredients));
        } else {
            recipeList.addAll(getRecipesFourIngredients(ingredients));
        }

        int bestRecipeScore = 0;
        for (Map<Ingredient, Integer> recipe : recipeList) {
            int recipeScore = getRecipeScore(recipe);
            if (bestRecipeScore < recipeScore) {
                bestRecipeScore = recipeScore;
            }
        }
        return bestRecipeScore;
    }

    private int getRecipeScore(Map<Ingredient, Integer> recipe) {
        int recipeCapacity = 0;
        int recipeDurability = 0;
        int recipeFlavor = 0;
        int recipeTexture = 0;

        for (Map.Entry<Ingredient, Integer> entry : recipe.entrySet()) {
            recipeCapacity = recipeCapacity + (entry.getKey().capacity * entry.getValue());
            recipeDurability = recipeDurability + (entry.getKey().durability * entry.getValue());
            recipeFlavor = recipeFlavor + (entry.getKey().flavor * entry.getValue());
            recipeTexture = recipeTexture + (entry.getKey().texture * entry.getValue());
        }
        if (recipeCapacity < 0) {
            recipeCapacity = 0;
        }
        if (recipeDurability < 0) {
            recipeDurability = 0;
        }
        if (recipeFlavor < 0) {
            recipeFlavor = 0;
        }
        if (recipeTexture < 0) {
            recipeTexture = 0;
        }
        return recipeCapacity * recipeDurability * recipeFlavor * recipeTexture;
    }

    private List<Map<Ingredient, Integer>> getRecipesTwoIngredients(List<Ingredient> ingredients) {
        if (ingredients.size() != 2) {
            throw new IllegalArgumentException("Ingredients should be 2 items long");
        }
        List<Map<Ingredient, Integer>> recipeList = new ArrayList<>();

        for (int ingredient01 = 0; ingredient01 <= AVAILABLE_CAPACITY; ingredient01++) {
            int ingredient02 = AVAILABLE_CAPACITY - ingredient01;
            Map<Ingredient, Integer> recipe = new HashMap<>();
            recipe.put(ingredients.get(0), ingredient01);
            recipe.put(ingredients.get(1), ingredient02);
            recipeList.add(recipe);
        }
        return recipeList;
    }

    private List<Map<Ingredient, Integer>> getRecipesFourIngredients(List<Ingredient> ingredients) {
        if (ingredients.size() != 4) {
            throw new IllegalArgumentException("Ingredients should be 4 items long");
        }
        List<Map<Ingredient, Integer>> recipeList = new ArrayList<>();

        for (int ingredient01 = 0; ingredient01 <= AVAILABLE_CAPACITY; ingredient01++) {
            for (int ingredient02 = 0; ingredient02 <= AVAILABLE_CAPACITY - ingredient01; ingredient02++) {
                for (int ingredient03 = 0;
                        ingredient03 <= AVAILABLE_CAPACITY - ingredient01 - ingredient02;
                        ingredient03++) {
                    int ingredient04 = AVAILABLE_CAPACITY - ingredient01 - ingredient02 - ingredient03;
                    Map<Ingredient, Integer> recipe = new HashMap<>();
                    recipe.put(ingredients.get(0), ingredient01);
                    recipe.put(ingredients.get(1), ingredient02);
                    recipe.put(ingredients.get(2), ingredient03);
                    recipe.put(ingredients.get(3), ingredient04);
                    recipeList.add(recipe);
                }
            }
        }
        return recipeList;
    }

    // tried recursion and couldn't quite get there, keeping here for future use, in case I want it.
    //    private List<Map<Ingredient, Integer>> getRecipes(List<Ingredient> ingredients) {
    //        List<Map<Ingredient, Integer>> recipeList = new ArrayList<>();
    //
    //        for(int i = 0;i <= AVAILABLE_CAPACITY;i++) {
    //            generateRecipes(0,  ingredients, recipeList, i);
    //        }
    //        return recipeList;
    //    }
    //
    //    private void generateRecipes(int depth, List<Ingredient> ingredients, List<Map<Ingredient, Integer>>
    // recipeList, int ... quantities) {
    //        if(depth == ingredients.size()-1 && ingredients.size() == quantities.length) {
    //            Map<Ingredient, Integer> recipe = new HashMap<>();
    //            for(int i = 0 ; i < ingredients.size();i++) {
    //                recipe.put(ingredients.get(i), quantities[i]);
    //            }
    //            recipeList.add(recipe);
    //            return;
    //        }
    //        int remaining = AVAILABLE_CAPACITY;
    //        for(int i = 0;i < quantities.length;i++) {
    //            remaining = remaining - quantities[i];
    //        }
    //        for(int i = 0;i < remaining;i++) {
    //            int[] tmpQuantities = IntStream.concat(Arrays.stream(quantities), IntStream.of(i)).toArray();
    //            generateRecipes(depth+1, ingredients, recipeList, tmpQuantities);
    //        }
    //    }

}
