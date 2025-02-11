package ru.coffemaker.CoffeeMaker.Service.RecipeService;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.coffemaker.CoffeeMaker.Entity.Recipe;
import ru.coffemaker.CoffeeMaker.Repository.RecipeRepository;

import java.util.List;


@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    public Recipe getRecipe(String name) {
        return recipeRepository.findByName(name).orElse(null);
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAllByOrderByIdDesc().orElse(null);
    }

    public void addRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    public Recipe findByName(String name){
        return recipeRepository.findByName(name).orElse(null);
    }
}
