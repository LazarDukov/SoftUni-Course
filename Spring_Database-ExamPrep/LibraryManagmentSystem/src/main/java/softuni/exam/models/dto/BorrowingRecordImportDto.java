package softuni.exam.models.dto;

import softuni.exam.util.LocalDateAdaptor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlRootElement(name = "borrowing_record")
@XmlAccessorType(XmlAccessType.FIELD)
public class BorrowingRecordImportDto {
    @XmlElement(name = "borrow_date")
    @XmlJavaTypeAdapter(LocalDateAdaptor.class)
    @NotNull
    private LocalDate borrowDate;
    @XmlElement(name = "return_date")
    @XmlJavaTypeAdapter(LocalDateAdaptor.class)
    @NotNull
    private LocalDate returnDate;

    @XmlElement
    @NotNull
    private BookTitle book;

    @XmlElement
    @NotNull
    private MemberBase member;

    @XmlElement
    @Size(min = 3, max = 100)
    private String remarks;

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

    public BookTitle getBook() {
        return book;
    }

    public void setBook(BookTitle book) {
        this.book = book;
    }

    public MemberBase getMember() {
        return member;
    }

    public void setMember(MemberBase member) {
        this.member = member;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
//•	id - accepts integer values, a primary identification field, an auto incremented field.
//•	borrow date - a date in the "yyyy-MM-dd" format.
//•	return date - a date in the "yyyy-MM-dd" format.
//•	remarks - can be used to store any relevant information and might be helpful for tracking and managing the borrowing records. Accepts char sequence (between 3 to 100 inclusive). Can be nullable.
//•	Constraint: The borrowing_records table has a relation with books table.
//•	Constraint: The borrowing_records table has a relation with library_members table.


//<borrowing_record>
//        <borrow_date>2020-01-13</borrow_date>
//        <return_date>2022-09-11</return_date>
//        <book>
//            <title>The Lord of the Rings</title>
//        </book>
//        <member>
//            <id>27</id>
//        </member>
//        <remarks>Handle with care, fragile book.</remarks>
//    </borrowing_record>