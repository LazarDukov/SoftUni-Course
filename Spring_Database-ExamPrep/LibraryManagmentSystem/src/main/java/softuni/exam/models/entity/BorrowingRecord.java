package softuni.exam.models.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "borrowing_records")
public class BorrowingRecord extends BaseEntity {
    //•	borrow date - a date in the "yyyy-MM-dd" format.
    //•	return date - a date in the "yyyy-MM-dd" format.
    //•	remarks - can be used to store any relevant information and might be helpful for tracking and managing the borrowing records. Accepts char sequence (between 3 to 100 inclusive). Can be nullable.
    //•	Constraint: The borrowing_records table has a relation with books table.
    //•	Constraint: The borrowing_records table has a relation with library_members table.

    @Column(nullable = false, name = "borrow_date")
    private LocalDate borrowDate;

    @Column(nullable = false, name = "return_date")
    private LocalDate returnDate;

    @Column
    private String remarks;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private LibraryMember libraryMember;

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LibraryMember getLibraryMember() {
        return libraryMember;
    }

    public void setLibraryMember(LibraryMember libraryMember) {
        this.libraryMember = libraryMember;
    }

    @Override
    public String toString() {
        return String.format("Book title: %s" + System.lineSeparator() +
                "*Book author: %s" + System.lineSeparator() +
                "**Date borrowed: %s" + System.lineSeparator() +
                "***Borrowed by: %s %s", book.getTitle(),
                book.getAuthor(), getBorrowDate(),
                libraryMember.getFirstName(), libraryMember.getLastName());
    }
}
