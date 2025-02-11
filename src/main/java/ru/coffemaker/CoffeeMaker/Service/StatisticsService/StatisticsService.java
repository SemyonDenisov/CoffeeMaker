package ru.coffemaker.CoffeeMaker.Service.StatisticsService;

import ru.coffemaker.CoffeeMaker.Entity.Statistics;

import java.util.Optional;

public interface StatisticsService {

    void updateStatistics(String name);
    String getMostPopularDrink();
    void updateAllWithDateMoreThan5Years();
}
