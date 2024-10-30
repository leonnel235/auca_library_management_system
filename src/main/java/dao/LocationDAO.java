package dao;

import model.Location;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import hibernate.Hibernatecfg;

import java.util.List;
import java.util.UUID;

public class LocationDAO {

    // Method to save a new location
    public void saveLocation(Location location) {
        Transaction transaction = null;
        try (Session session = Hibernatecfg.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(location);  // Use save or persist to save the location
            transaction.commit();
            System.out.println("Location saved successfully.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Log the exception for debugging
        }
    }

    // Method to update an existing location
    public void updateLocation(Location location) {
        Transaction transaction = null;
        try (Session session = Hibernatecfg.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(location);  // Update the existing location
            transaction.commit();
            System.out.println("Location updated successfully.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Method to delete a location by its ID
    public void deleteLocation(UUID locationId) {
        Transaction transaction = null;
        try (Session session = Hibernatecfg.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            @SuppressWarnings("deprecation")
			Location location = session.get(Location.class, locationId); // Retrieve the location
            if (location != null) {
                session.delete(location);  // Delete the location
                System.out.println("Location deleted successfully.");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Method to get a location by its ID
    @SuppressWarnings("deprecation")
	public Location getLocationById(UUID locationId) {
        try (Session session = Hibernatecfg.getSessionFactory().openSession()) {
            return session.get(Location.class, locationId); // Retrieve the location
        }
    }

    // Method to get all locations
    public List<Location> getAllLocations(String villageId) {
        try (Session session = Hibernatecfg.getSessionFactory().openSession()) {
            Query<Location> query = session.createQuery("FROM Location", Location.class);
            return query.getResultList(); // Return all locations
        }
    }
    
}
