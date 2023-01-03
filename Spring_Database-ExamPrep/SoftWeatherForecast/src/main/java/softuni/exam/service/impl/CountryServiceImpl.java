package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountryImportDto;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;

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
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    private final ModelMapper modelMapper;

    private final Gson gson;

    private final Validator validator;


    public CountryServiceImpl(CountryRepository countryRepository, ModelMapper modelMapper, Gson gson, Validator validator) {
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return Files.readString(Path.of("src", "main", "resources", "files", "json", "countries.json"));
    }

    @Override
    public String importCountries() throws IOException {
        String countriesReader = readCountriesFromFile();
        CountryImportDto[] countryDtos = this.gson.fromJson(countriesReader, CountryImportDto[].class);
        List<String> results = new ArrayList<>();
        for (CountryImportDto countryDto : countryDtos) {
            Set<ConstraintViolation<CountryImportDto>> errors = this.validator.validate(countryDto);
            if (errors.isEmpty()) {
                Optional<Country> isCountryExists = this.countryRepository.findCountryByName(countryDto.getCountryName());
                if (isCountryExists.isEmpty()) {
                    Country country = this.modelMapper.map(countryDto, Country.class);
                    this.countryRepository.save(country);
                    results.add(String.format("Successfully imported country " + country.toString()));
                } else {
                    results.add("Invalid country");
                }
            } else {
                results.add("Invalid country");
            }

        }


        return String.join(System.lineSeparator(), results);
    }
}
