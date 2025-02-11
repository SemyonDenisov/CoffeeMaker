package ru.coffemaker.CoffeeMaker.Service.IngredientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.coffemaker.CoffeeMaker.Entity.Ingredient;
import ru.coffemaker.CoffeeMaker.Repository.IngredientRepository;

public interface IngredientService {
    Ingredient getIngredient(String name);
    void updateIngredient(Ingredient ingredient);
}
