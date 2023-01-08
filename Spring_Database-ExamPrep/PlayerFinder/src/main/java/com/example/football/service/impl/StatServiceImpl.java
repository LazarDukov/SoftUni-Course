package com.example.football.service.impl;

import com.example.football.models.dto.StatImportDto;
import com.example.football.models.dto.StatWrapperDto;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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

import static com.example.football.util.Paths.STATS_PATH;

@Service
public class StatServiceImpl implements StatService {

    private final StatRepository statRepository;

    private final ModelMapper modelMapper;

    private final Validator validator;

    public StatServiceImpl(StatRepository statRepository, ModelMapper modelMapper, Validator validator) {
        this.statRepository = statRepository;
        this.modelMapper = modelMapper;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(Path.of(STATS_PATH));
    }

    @Override
    public String importStats() throws IOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(StatWrapperDto.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        StatWrapperDto stats = (StatWrapperDto) unmarshaller.unmarshal(Path.of(STATS_PATH).toFile());

        List<StatImportDto> getStats = stats.getStats();

        List<String> result = new ArrayList<>();

        for (StatImportDto stat : getStats) {
            Set<ConstraintViolation<StatImportDto>> errors = this.validator.validate(stat);
            if (errors.isEmpty()) {
                Optional<Stat> optionalStat = this.statRepository.findByEnduranceAndPassingAndShooting(stat.getEndurance(), stat.getPassing(), stat.getShooting());
                if (optionalStat.isEmpty()) {
                    Stat stat1 = this.modelMapper.map(stat, Stat.class);

                    this.statRepository.save(stat1);
                    result.add(String.format("Successfully imported Stat %.2f - %.2f - %.2f", stat.getPassing(), stat.getShooting(), stat.getEndurance()));
                } else {
                    result.add("Invalid stat");
                }
            } else {
                result.add("Invalid stat");
            }

        }
        return String.join(System.lineSeparator(), result);
    }
}
