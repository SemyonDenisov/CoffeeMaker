package ru.coffemaker.CoffeeMaker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.coffemaker.CoffeeMaker.Entity.Ingredient;

import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient,Integer> {
    Optional<Ingredient> findByName(String name);
}
