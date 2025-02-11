package ru.coffemaker.CoffeeMaker.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ingredient")
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Setter
    @Column
    private String name;

    @Column(name="count")
    @Setter
    @Getter
    private int count;

//    public int getCount(){
//        return count;
//    }

//    public void setCount(int count){
//        count = count;
//    }
}
