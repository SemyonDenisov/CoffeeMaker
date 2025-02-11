package ru.coffemaker.CoffeeMaker.Service.RecipeService;

import ru.coffemaker.CoffeeMaker.Entity.Recipe;

import java.util.List;

public interface RecipeService {
    Recipe getRecipe(String name);
    List<Recipe> getAllRecipes();
    void addRecipe(Recipe recipe);
    Recipe findByName(String name);
}
