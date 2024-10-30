package model;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Shelf {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  shelfId; 
    private int availableStock;  
    private String bookCategory;  
    private int borrowedNumber;  
    private int initialStock;  
    
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;  

    // No-argument constructor
    public Shelf() {}

    // Getters and Setters
     public Shelf(Long shelfId, int availableStock, String bookCategory, int borrowedNumber, int initialStock,
			Room room) {

		this.shelfId = shelfId;
		this.availableStock = availableStock;
		this.bookCategory = bookCategory;
		this.borrowedNumber = borrowedNumber;
		this.initialStock = initialStock;
		this.room = room;
	}

	public void setAvailableStock(int availableStock) {
        this.availableStock = availableStock;
    }

    public Long getShelfId() {
		return shelfId;
	}

	public void setShelfId(Long shelfId) {
		this.shelfId = shelfId;
	}

	public int getAvailableStock() {
		return availableStock;
	}

	public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public int getBorrowedNumber() {
        return borrowedNumber;
    }

    public void setBorrowedNumber(int borrowedNumber) {
        this.borrowedNumber = borrowedNumber;
    }

    public int getInitialStock() {
        return initialStock;
    }

    public void setInitialStock(int initialStock) {
        this.initialStock = initialStock;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
