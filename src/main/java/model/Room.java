package model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.*;

@Entity
public class Room {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  roomId;

    private String roomCode;

    @JsonManagedReference
    @OneToMany(mappedBy = "room")
    private List<Shelf> shelves;

    // No-argument constructor
    public Room() {}
    public Room(Long roomId, String roomCode, List<Shelf> shelves) {

		this.roomId = roomId;
		this.roomCode = roomCode;
		this.shelves = shelves;
	}


	public Long getRoomId() {
		return roomId;
	}


	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}


	public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public List<Shelf> getShelves() {
        return shelves;
    }

    public void setShelves(List<Shelf> shelves) {
        this.shelves = shelves;
    }
}
