package model;

import javax.persistence.*;

@Entity
public class Book {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    private String title;

    private int edition;

    private String ISBNcode;

    private int publicationYear;

    private String publisherName;

    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;

    @ManyToOne
    @JoinColumn(name = "shelf_id")
    private Shelf shelf;

    // No-argument constructor
    public Book() {}

    // Getters and Setters
 

    public Book(Long bookId, String title, int edition, String iSBNcode, int publicationYear, String publisherName,
			BookStatus bookStatus, Shelf shelf) {
		this.bookId = bookId;
		this.title = title;
		this.edition = edition;
		ISBNcode = iSBNcode;
		this.publicationYear = publicationYear;
		this.publisherName = publisherName;
		this.bookStatus = bookStatus;
		this.shelf = shelf;
	}

	public String getTitle() {
        return title;
    }

    public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public void setTitle(String title) {
        this.title = title;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public String getISBNcode() {
        return ISBNcode;
    }

    public void setISBNcode(String ISBNcode) {
        this.ISBNcode = ISBNcode;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public Shelf getShelf() {
        return shelf;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }

}