package model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Date;

@Entity
public class Borrower {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long borrower_id;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Users reader;  

    private Date dueDate;
    private float fine;
    private Date pickUpDate;
    private Date returnedDate;

    // No-argument constructor
    public Borrower() {}

    // Getters and Setters
  
    public Borrower(Long borrower_id, Book book, Users reader, Date dueDate, float fine, Date pickUpDate,
	Date returnedDate) {
		this.borrower_id = borrower_id;
		this.book = book;
		this.reader = reader;
		this.dueDate = dueDate;
		this.fine = fine;
		this.pickUpDate = pickUpDate;
		this.returnedDate = returnedDate;
	}

	public Book getBook() {
        return book;
    }

    public Long getBorrower_id() {
		return borrower_id;
	}

	public void setBorrower_id(Long borrower_id) {
		this.borrower_id = borrower_id;
	}

	public void setBook(Book book) {
        this.book = book;
    }

    public Users getReader() {
        return reader;
    }

    public void setReader(Users reader) {
        this.reader = reader;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public float getFine() {
        return fine;
    }

    public void setFine(float fine) {
        this.fine = fine;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }
  
}
