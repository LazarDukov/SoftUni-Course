package softuni.exam.service.impl;


import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ForecastImportDto;
import softuni.exam.models.dto.ForecastsWrapperDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Forecast;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.ForecastService;
import softuni.exam.util.WeekDays;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ForecastServiceImpl implements ForecastService {

    private final ForecastRepository forecastRepository;

    private final CityRepository cityRepository;


    private final ModelMapper modelMapper;

    private final Validator validator;
@Autowired
    public ForecastServiceImpl(ForecastRepository forecastRepository, CityRepository cityRepository, ModelMapper modelMapper, Validator validator) {
        this.forecastRepository = forecastRepository;
        this.cityRepository = cityRepository;
        this.modelMapper = modelMapper;
        this.validator = validator;
    }


    @Override
    public boolean areImported() {
        return forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return Files.readString(Path.of("src", "main", "resources", "files", "xml", "forecasts.xml"));
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(ForecastsWrapperDto.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        ForecastsWrapperDto fwd = (ForecastsWrapperDto) unmarshaller.unmarshal(Path.of("src", "main", "resources", "files", "xml", "forecasts.xml").toFile());

        List<ForecastImportDto> forecasts = fwd.getForecasts();

        List<String> results = new ArrayList<>();

        for (ForecastImportDto forecast : forecasts) {
            Set<ConstraintViolation<ForecastImportDto>> errors = this.validator.validate(forecast);

            if (errors.isEmpty()) {
                Optional<Forecast> ifForecastExists = this.forecastRepository.findByCity_IdAndWeekDays(forecast.getCity(), forecast.getWeekDay());
                if (ifForecastExists.isEmpty()) {
                    Forecast forecastMap = this.modelMapper.map(forecast, Forecast.class);

                    City city = this.cityRepository.getById(forecast.getCity());

                    forecastMap.setCity(city);
                    this.forecastRepository.save(forecastMap);
                    results.add(String.format("Successfully import forecast" + forecastMap.toString()));
                } else {
                    results.add("Invalid forecast");
                }
            } else {
                results.add("Invalid forecast");
            }

        }
        return String.format(System.lineSeparator(), results);
    }

    @Override
    public String exportForecasts() {

        Long populationA = 150000L;
        List<Forecast> selectedForecasts = this.forecastRepository.
                findAllByWeekDaysAndCityPopulationLessThanOrderByMaxTemperatureDescIdAsc(WeekDays.SUNDAY, populationA);
        return selectedForecasts.stream().map(Forecast::toString).collect(Collectors.joining("\n"));
    }
}
