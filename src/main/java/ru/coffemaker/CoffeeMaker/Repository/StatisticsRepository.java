package ru.coffemaker.CoffeeMaker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.coffemaker.CoffeeMaker.Entity.Statistics;

import java.sql.Date;
import java.util.Optional;

public interface StatisticsRepository extends JpaRepository<Statistics, Integer> {
    Optional<Statistics> findStatisticsByName(String name);

    Optional<Statistics> findFirstByOrderByCountDesc();

    @Transactional
    @Modifying
    @Query(value = "update test.statistics set count = 0, date = CURRENT_TIMESTAMP where date < CURRENT_TIMESTAMP - interval '5 year'\n", nativeQuery = true)
    void updateAllWithDateMoreThan5Years();
}
