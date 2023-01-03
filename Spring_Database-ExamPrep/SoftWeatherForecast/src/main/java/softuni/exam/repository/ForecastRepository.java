package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Forecast;
import softuni.exam.util.WeekDays;

import java.util.List;
import java.util.Optional;

@Repository
public interface ForecastRepository extends JpaRepository<Forecast, Long> {

    Optional<Forecast> findByCity_IdAndWeekDays(Long id, WeekDays weekDay);

    List<Forecast> findAllByWeekDaysAndCityPopulationLessThanOrderByMaxTemperatureDescIdAsc(WeekDays days, Long populationA);

}
