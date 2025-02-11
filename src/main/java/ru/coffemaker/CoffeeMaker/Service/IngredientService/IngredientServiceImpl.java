package ru.coffemaker.CoffeeMaker.Service.IngredientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.coffemaker.CoffeeMaker.Entity.Ingredient;
import ru.coffemaker.CoffeeMaker.Repository.IngredientRepository;


@Service
public class IngredientServiceImpl implements IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    public Ingredient getIngredient(String name) {
        return ingredientRepository.findByName(name).orElse(null);
    }
    public void updateIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }
}
