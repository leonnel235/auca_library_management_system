package model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

@Entity
@Table(name = "Login_Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long personId;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String gender;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private String role;

    @Column
    private String phonenumber;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "village_id")
    private Location village;

    @JsonManagedReference
    @OneToMany(mappedBy = "reader", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Membership> memberships;

    @JsonManagedReference
    @OneToMany(mappedBy = "reader", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Borrower> borrowedBooks;

    // Default constructor
    public Users() {}
    
     
    public Users(Long personId, String firstname, String lastname, String gender, String username, String password,
			String role, String phonenumber, Location village, List<Membership> memberships,
			List<Borrower> borrowedBooks) {
		this.personId = personId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.username = username;
		this.password = password;
		this.role = role;
		this.phonenumber = phonenumber;
		this.village = village;
		this.memberships = memberships;
		this.borrowedBooks = borrowedBooks;
	}


	// Getters and Setters
    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Location getVillage() {
        return village;
    }

    public void setVillage(Location village) {
        this.village = village;
    }

    public List<Membership> getMemberships() {
        return memberships;
    }

    public void setMemberships(List<Membership> memberships) {
        this.memberships = memberships;
    }

    public List<Borrower> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Borrower> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}
