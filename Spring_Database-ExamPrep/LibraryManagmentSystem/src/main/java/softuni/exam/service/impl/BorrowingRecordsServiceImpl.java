package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.BorrowingRecordImportDto;
import softuni.exam.models.dto.BorrowingRecordWrapperDto;
import softuni.exam.models.entity.Book;
import softuni.exam.models.entity.BorrowingRecord;
import softuni.exam.models.entity.Genre;
import softuni.exam.models.entity.LibraryMember;
import softuni.exam.repository.BookRepository;
import softuni.exam.repository.BorrowingRecordRepository;
import softuni.exam.repository.LibraryMemberRepository;
import softuni.exam.service.BorrowingRecordsService;
import softuni.exam.util.Paths;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BorrowingRecordsServiceImpl implements BorrowingRecordsService {

    private final BorrowingRecordRepository borrowingRecordRepository;

    private final Validator validator;
    private final BookRepository bookRepository;
    private final LibraryMemberRepository libraryMemberRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public BorrowingRecordsServiceImpl(BorrowingRecordRepository borrowingRecordRepository, Validator validator, BookRepository bookRepository, LibraryMemberRepository libraryMemberRepository, ModelMapper modelMapper) {
        this.borrowingRecordRepository = borrowingRecordRepository;
        this.validator = validator;
        this.bookRepository = bookRepository;
        this.libraryMemberRepository = libraryMemberRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return borrowingRecordRepository.count() > 0;
    }

    @Override
    public String readBorrowingRecordsFromFile() throws IOException {
        return Files.readString(Path.of(Paths.PATH_BORROWING_RECORDS));
    }

    @Override
    public String importBorrowingRecords() throws IOException, JAXBException {
        FileReader fileReader = new FileReader(Path.of(Paths.PATH_BORROWING_RECORDS).toFile());
        JAXBContext jaxbContext = JAXBContext.newInstance(BorrowingRecordWrapperDto.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        BorrowingRecordWrapperDto borrowingRecordWrapperDto = (BorrowingRecordWrapperDto) unmarshaller.unmarshal(fileReader);


        return borrowingRecordWrapperDto.getBorrowingRecords().
                stream().map(this::importBorrowingRecord).collect(Collectors.joining(System.lineSeparator()));
    }

    private String importBorrowingRecord(BorrowingRecordImportDto borrowingRecordImportDto) {
        Set<ConstraintViolation<BorrowingRecordImportDto>> errors = this.validator.validate(borrowingRecordImportDto);
        if (!errors.isEmpty()) {
            return "Invalid borrowing record";
        }
        Optional<Book> isBookWithGivenTitleExist =
                this.bookRepository.findByTitle(borrowingRecordImportDto.getBook().getTitle());
        if (isBookWithGivenTitleExist.isEmpty()) {
            return "Invalid borrowing record";
        }
        Optional<LibraryMember> isLibraryMemberExist = this.libraryMemberRepository.findById(borrowingRecordImportDto.getMember().getId());
        if (isLibraryMemberExist.isEmpty()) {
            return "Invalid borrowing record";
        }
        BorrowingRecord borrowingRecord = this.modelMapper.map(borrowingRecordImportDto, BorrowingRecord.class);
        borrowingRecord.setBook(isBookWithGivenTitleExist.get());
        borrowingRecord.setLibraryMember(isLibraryMemberExist.get());
        borrowingRecordRepository.save(borrowingRecord);


        return String.format("Successfully imported borrowing record %s - %s", borrowingRecord.getBook().getTitle(), borrowingRecord.getBorrowDate());
    }

    @Override
    public String exportBorrowingRecords() {
        return borrowingRecordRepository.findBookByBook_GenreOrderByBorrowDateDesc(Genre.SCIENCE_FICTION)
                .orElseThrow(NoSuchElementException::new).stream()
                .map(BorrowingRecord::toString).collect(Collectors.joining(System.lineSeparator()));
    }
}
