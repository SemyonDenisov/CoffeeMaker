package ru.coffemaker.CoffeeMaker.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.coffemaker.CoffeeMaker.DAO.RecipeDAO;

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


    public Recipe(RecipeDAO recipeDAO){
        this.coffee = recipeDAO.getCoffee();
        this.milk =recipeDAO.getMilk();
        this.water = recipeDAO.getWater();
        this.name = recipeDAO.getName();
    }

}
