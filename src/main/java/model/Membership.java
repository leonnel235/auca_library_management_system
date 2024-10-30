package model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.*;

@Entity
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long membershipId;

    @Column(nullable = false)
    private String membershipCode;

    @Column(nullable = false)
    private String membershipStatus;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "membership_type_id")
    private MembershipType membershipType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date expiringTime;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reader_id")
    private Users reader;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    // Default constructor
    public Membership() {}

    // Constructor for required fields
    public Membership(String membershipCode, String membershipStatus, Date registrationDate) {
        this.membershipCode = membershipCode;
        this.membershipStatus = membershipStatus;
        this.registrationDate = registrationDate;
    }

    // Getters and Setters
    // ...

    public Long getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(Long membershipId) {
		this.membershipId = membershipId;
	}

	public String getMembershipCode() {
		return membershipCode;
	}

	public void setMembershipCode(String membershipCode) {
		this.membershipCode = membershipCode;
	}

	public String getMembershipStatus() {
		return membershipStatus;
	}

	public void setMembershipStatus(String membershipStatus) {
		this.membershipStatus = membershipStatus;
	}

	public MembershipType getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(MembershipType membershipType) {
		this.membershipType = membershipType;
	}

	public Date getExpiringTime() {
		return expiringTime;
	}

	public void setExpiringTime(Date expiringTime) {
		this.expiringTime = expiringTime;
	}

	public Users getReader() {
		return reader;
	}

	public void setReader(Users reader) {
		this.reader = reader;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
}
