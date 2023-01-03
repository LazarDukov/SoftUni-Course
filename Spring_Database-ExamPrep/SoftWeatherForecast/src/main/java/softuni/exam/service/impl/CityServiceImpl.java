package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CityImportDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CityService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    private final CountryRepository countryRepository;

    private final ModelMapper modelMapper;

    private final Gson gson;

    private final Validator validator;



    public CityServiceImpl(CityRepository cityRepository, CountryRepository countryRepository, ModelMapper modelMapper, Gson gson, Validator validator) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return cityRepository.count() > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        return Files.readString(Path.of("src", "main", "resources", "files", "json", "cities.json"));
    }

    @Override
    public String importCities() throws IOException {
        String reader = readCitiesFileContent();
        CityImportDto[] cityDtos = this.gson.fromJson(reader, CityImportDto[].class);
        List<String> results = new ArrayList<>();

        for (CityImportDto cityDto : cityDtos) {
            Set<ConstraintViolation<CityImportDto>> errors = this.validator.validate(cityDto);
            if (errors.isEmpty()) {
                Optional<City> isCityExists = this.cityRepository.findByCityName(cityDto.getCityName());
                if (isCityExists.isEmpty()) {
                    City city = this.modelMapper.map(cityDto, City.class);

                    Country country = this.countryRepository.getById(cityDto.getCountry());

                    city.setCountry(country);
                    this.cityRepository.save(city);

                    results.add(String.format("Successfully imported city " + city.toString()));
                } else {
                    results.add("Invalid city");
                }
            } else {
                results.add("Invalid city");
            }


        }
        return String.join(System.lineSeparator(), results);
    }
}
