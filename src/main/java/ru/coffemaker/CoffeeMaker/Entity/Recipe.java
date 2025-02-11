package ru.coffemaker.CoffeeMaker.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.coffemaker.CoffeeMaker.DTO.RecipeDTO;

@Table(name = "recipe")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    private int id;

    @Column
    @Setter
    private String name;

    @Column
    @Setter
    private int coffee;

    @Column
    @Setter
    private int water;

    @Column
    @Setter
    private int milk;


    public Recipe(RecipeDTO recipeDTO){
        this.coffee = recipeDTO.getCoffee();
        this.milk = recipeDTO.getMilk();
        this.water = recipeDTO.getWater();
        this.name = recipeDTO.getName();
    }

}
