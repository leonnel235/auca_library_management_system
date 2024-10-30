package model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;
@Entity
public class Location {

	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long locationId;
    private String locationCode;
    private String locationName;
   @Enumerated(EnumType.STRING)
    private LocationType locationType;
   
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Location parentLocation;
    
    @JsonManagedReference
    @OneToMany(mappedBy = "parentLocation")
    private List<Location> subLocations;  
    
    @JsonManagedReference
    @OneToMany(mappedBy = "village", cascade = CascadeType.ALL)
    private List<Users> users;  

    // No-argument constructor
    public Location() {}
    public Location(Long locationId, String locationCode, String locationName, LocationType locationType,
			Location parentLocation, List<Location> subLocations, List<Users> users) {
		this.locationId = locationId;
		this.locationCode = locationCode;
		this.locationName = locationName;
		this.locationType = locationType;
		this.parentLocation = parentLocation;
		this.subLocations = subLocations;
		this.users = users;
	}
public Long getLocationId() {
		return locationId;
	}

public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public Location getParentLocation() {
        return parentLocation;
    }

    public void setParentLocation(Location parentLocation) {
        this.parentLocation = parentLocation;
    }

    public List<Location> getSubLocations() {
        return subLocations;
    }

    public void setSubLocations(List<Location> subLocations) {
        this.subLocations = subLocations;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
