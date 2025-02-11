package ru.coffemaker.CoffeeMaker.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.coffemaker.CoffeeMaker.DAO.RecipeDAO;
import ru.coffemaker.CoffeeMaker.Entity.Ingredient;
import ru.coffemaker.CoffeeMaker.Entity.Recipe;
import ru.coffemaker.CoffeeMaker.Entity.Statistics;
import ru.coffemaker.CoffeeMaker.Service.IngredientService.IngredientService;
import ru.coffemaker.CoffeeMaker.Service.RecipeService.RecipeService;
import ru.coffemaker.CoffeeMaker.Service.StatisticsService.StatisticsService;

@RestController
public class MakeCoffeeController {

    @Autowired
    RecipeService recipeService;

    @Autowired
    IngredientService ingredientService;

    @Autowired
    StatisticsService statisticsService;

    @GetMapping(value = "/make")
    public ResponseEntity<?> make(String name) {
        Recipe recipe = recipeService.getRecipe(name);
        if (recipe != null) {
            Ingredient coffee = ingredientService.getIngredient("coffee");
            Ingredient water = ingredientService.getIngredient("water");
            Ingredient milk = ingredientService.getIngredient("milk");
            statisticsService.updateAllWithDateMoreThan5Years();
            statisticsService.updateStatistics(name);
            if (coffee == null || coffee.getCount() < recipe.getCoffee()) {
                return new ResponseEntity<>("Not enough coffee to make your drink", HttpStatus.BAD_REQUEST);
            }
            if (water == null || (recipe.getWater() != 0 && water.getCount() < recipe.getWater())) {
                return new ResponseEntity<>("Not enough water to make your drink", HttpStatus.BAD_REQUEST);
            }
            if (milk == null || (recipe.getMilk() != 0 && milk.getCount() < recipe.getMilk())) {
                return new ResponseEntity<>("Not enough milk to make your drink", HttpStatus.BAD_REQUEST);
            }
            coffee.setCount(coffee.getCount() - recipe.getCoffee());
            water.setCount(water.getCount() - recipe.getWater());
            milk.setCount(milk.getCount() - recipe.getMilk());
            ingredientService.updateIngredient(coffee);
            ingredientService.updateIngredient(water);
            ingredientService.updateIngredient(milk);
            return new ResponseEntity<>("Coffee is made: " + name, HttpStatus.OK);
        }
        return new ResponseEntity<>("Recipe does not exist", HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/most_popular")
    public ResponseEntity<?> getMostPopularDrink() {
        String name = statisticsService.getMostPopularDrink();
        if (name == null) {
            return new ResponseEntity<>("No one buy drink in this coffeeMaker yet", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Most popular: " + name, HttpStatus.OK);
    }

    @PostMapping(value = "/recipe")
    public ResponseEntity<?> addRecipe(@RequestBody RecipeDAO recipe) {
        if (recipe.getName() == null || recipe.getCoffee() < 1) {
            return new ResponseEntity<>("Necessary fields are no provided", HttpStatus.BAD_REQUEST);
        }
        if (recipeService.findByName(recipe.getName()) != null) {
            return new ResponseEntity<>("Recipe already exists", HttpStatus.CONFLICT);
        }
        Recipe recipe1 = new Recipe(recipe);
        recipeService.addRecipe(recipe1);
        return new ResponseEntity<>("Recipe added", HttpStatus.OK);
    }

    @GetMapping(value = "/state")
    public ResponseEntity<?> getState() {
        Ingredient coffee = ingredientService.getIngredient("coffee");
        Ingredient water = ingredientService.getIngredient("water");
        Ingredient milk = ingredientService.getIngredient("milk");
        return new ResponseEntity<>("Coffee: " + coffee.getCount()
                + "\nMilk: " + milk.getCount()
                + "\nWater: " + water.getCount(), HttpStatus.OK);
    }

    @PostMapping(value = "/ingredient")
    public ResponseEntity<?> addIngredient(String name, int count) {
        if (count <= 0) {
            return new ResponseEntity<>("Not valid count", HttpStatus.BAD_REQUEST);
        }
        Ingredient ingredient = ingredientService.getIngredient(name);
        if (ingredient == null) {
            return new ResponseEntity<>("Not valid ingredient", HttpStatus.BAD_REQUEST);
        }
        ingredient.setCount(count + ingredient.getCount());
        ingredientService.updateIngredient(ingredient);
        return new ResponseEntity<>(name + " added", HttpStatus.OK);
    }

}
