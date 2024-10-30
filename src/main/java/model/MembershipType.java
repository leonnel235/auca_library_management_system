package  model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

@Entity
public class MembershipType {

	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
      private Long  membershipTypeId;
      private String membershipName;
       private int maxBooks;
       private float price;

    // One-to-many relationship with Membership (a type can have many memberships)
    @JsonManagedReference
    @OneToMany(mappedBy = "membershipType", cascade = CascadeType.ALL)
    private List<Membership> memberships;  // Represents all memberships of this type

    // No-argument constructor
    public MembershipType() {}
     
    public MembershipType(Long membershipTypeId, String membershipName, int maxBooks, float price,
			List<Membership> memberships) {
		super();
		this.membershipTypeId = membershipTypeId;
		this.membershipName = membershipName;
		this.maxBooks = maxBooks;
		this.price = price;
		this.memberships = memberships;
	}

	// Getters and Setters
      public String getMembershipName() {
        return membershipName;
    }

    public Long getMembershipTypeId() {
		return membershipTypeId;
	}

	public void setMembershipTypeId(Long membershipTypeId) {
		this.membershipTypeId = membershipTypeId;
	}

	public void setMembershipName(String membershipName) {
        this.membershipName = membershipName;
    }

    public int getMaxBooks() {
        return maxBooks;
    }

    public void setMaxBooks(int maxBooks) {
        this.maxBooks = maxBooks;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<Membership> getMemberships() {
        return memberships;
    }

    public void setMemberships(List<Membership> memberships) {
        this.memberships = memberships;
    }
}
