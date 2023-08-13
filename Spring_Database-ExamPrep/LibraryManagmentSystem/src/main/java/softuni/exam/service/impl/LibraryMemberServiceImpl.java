package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.BookImportDto;
import softuni.exam.models.dto.LibraryMemberImportDto;
import softuni.exam.models.entity.Book;
import softuni.exam.models.entity.LibraryMember;
import softuni.exam.repository.BookRepository;
import softuni.exam.repository.LibraryMemberRepository;
import softuni.exam.service.LibraryMemberService;
import softuni.exam.util.Paths;
import softuni.exam.util.ValidationUtils;

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
public class LibraryMemberServiceImpl implements LibraryMemberService {
    private final LibraryMemberRepository libraryMemberRepository;


    private final Gson gson;

    private final Validator validator;

    private final ModelMapper modelMapper;

    private final ValidationUtils validationUtils;

    @Autowired
    public LibraryMemberServiceImpl(LibraryMemberRepository libraryMemberRepository, Gson gson, Validator validator, ModelMapper modelMapper, ValidationUtils validationUtils) {
        this.libraryMemberRepository = libraryMemberRepository;
        this.gson = gson;
        this.validator = validator;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return libraryMemberRepository.count() > 0;
    }

    @Override
    public String readLibraryMembersFileContent() throws IOException {
        return Files.readString(Path.of(Paths.PATH_LIBRARY_MEMBERS));
    }

    @Override
    public String importLibraryMembers() throws IOException {
        String json = this.readLibraryMembersFileContent();
        LibraryMemberImportDto[] libraryMemberImportDtos = this.gson.fromJson(json, LibraryMemberImportDto[].class);
        List<String> result = new ArrayList<>();

        for (LibraryMemberImportDto memberDto : libraryMemberImportDtos) {
            Set<ConstraintViolation<LibraryMemberImportDto>> errors = this.validator.validate(memberDto);
            if (errors.isEmpty()) {
                Optional<LibraryMember> isMemberExistsByPhone = libraryMemberRepository.findByPhoneNumber(memberDto.getPhoneNumber());
                if (isMemberExistsByPhone.isEmpty()) {
                    LibraryMember newMember = this.modelMapper.map(memberDto, LibraryMember.class);
                    libraryMemberRepository.save(newMember);
                    result.add(String.format("Successfully imported library member %s - %s", memberDto.getFirstName(), memberDto.getLastName()));
                } else {
                    result.add("Invalid library member");
                }
            } else {
                result.add("Invalid library member");
            }

        }

        return String.join(System.lineSeparator(), result);
    }
}
