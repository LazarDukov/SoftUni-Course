package com.example.football.service.impl;

import com.example.football.models.dto.TownImportDto;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.example.football.util.Paths.TOWNS_PATH;


@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;

    private final Gson gson;

    private final Validator validator;

    private final ModelMapper modelMapper;

    public TownServiceImpl(TownRepository townRepository, Gson gson, Validator validator, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.validator = validator;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWNS_PATH));
    }

    @Override
    public String importTowns() throws IOException {
        final String fileReader = readTownsFileContent();
        TownImportDto[] townImportDtos = this.gson.fromJson(fileReader, TownImportDto[].class);

        List<String> result = new ArrayList<>();

        for (TownImportDto townImportDto : townImportDtos) {
            Set<ConstraintViolation<TownImportDto>> errors = this.validator.validate(townImportDto);
            if (errors.isEmpty()) {
                Optional<Town> isTownExist = this.townRepository.findTownByName(townImportDto.getName());
                if (isTownExist.isEmpty()) {
                    Town town = this.modelMapper.map(townImportDto, Town.class);
                    this.townRepository.save(town);
                    result.add(String.format("Successfully imported " + town.toString()));
                } else {
                    result.add("Invalid town");
                }
            } else {
                result.add("Invalid town");
            }

        }
        return String.join(System.lineSeparator(), result);
    }
}