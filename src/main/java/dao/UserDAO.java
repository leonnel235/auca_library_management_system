package dao;

import model.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;
import hibernate.Hibernatecfg;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class UserDAO {

    // Helper method to hash password using SHA-256
    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not found", e);
        }
    }

    public boolean saveUser(Users user) {
        Transaction transaction = null;
        try (Session session = Hibernatecfg.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            user.setPassword(hashPassword(user.getPassword()));
            session.persist(user);
            transaction.commit();
            System.out.println("User  saved successfully.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Log the complete stack trace for debugging
            throw new RuntimeException("Error saving user: " + e.getMessage(), e);
        }
		return false;
    }
    
    
 // Method to fetch Users entity by ID
    public Users getUserById(Long id) {
        try (Session session = Hibernatecfg.getSessionFactory().openSession()) {
            return session.get(Users.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    }

