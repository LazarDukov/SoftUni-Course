package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.BorrowingRecord;
import softuni.exam.models.entity.Genre;

import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Long> {
    Optional<List<BorrowingRecord>> findBookByBook_GenreOrderByBorrowDateDesc(Genre genre);
}

//•	Extract from the database the book title, book author, date borrowed and the full name(first name and last name) of the library member.
//•	Filter only books which are SCIENCE_FICTION
// and order them by the borrow date in descending order.
//•	Return the information in this format:
