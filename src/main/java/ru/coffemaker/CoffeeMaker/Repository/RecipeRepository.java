package ru.coffemaker.CoffeeMaker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.coffemaker.CoffeeMaker.Entity.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    Optional<Recipe> findByName(String name);
    Optional<List<Recipe>> findAllByOrderByIdDesc();
}
