package ru.coffemaker.CoffeeMaker.Service.StatisticsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.coffemaker.CoffeeMaker.Entity.Statistics;
import ru.coffemaker.CoffeeMaker.Repository.StatisticsRepository;

import java.sql.Date;
import java.util.Optional;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private StatisticsRepository statisticsRepository;


    public void updateStatistics(String name) {
        Optional<Statistics> statistics = statisticsRepository.findStatisticsByName(name);
        Date currentDate = new Date(System.currentTimeMillis());

        if (statistics.isPresent()) {
            statistics.get().setCount(statistics.get().getCount() + 1);
            statisticsRepository.save(statistics.get());
        }
        else {
            Statistics statistics1 = new Statistics();
            statistics1.setName(name);
            statistics1.setCount(1);
            statistics1.setDate(currentDate);
            statisticsRepository.save(statistics1);
        }
    }

    public String getMostPopularDrink() {
        Optional<Statistics> statistics = statisticsRepository.findFirstByOrderByCountDesc();
        return statistics.map(Statistics::getName).orElse(null);
    }

    public void updateAllWithDateMoreThan5Years(){
        statisticsRepository.updateAllWithDateMoreThan5Years();
    }
}
