package ru.coffemaker.CoffeeMaker.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Table(name = "statistics")
@Entity
@Getter
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @Setter
    private String name;

    @Column
    @Setter
    private int count;

   @Column
   @Setter
   private Date date;

}
