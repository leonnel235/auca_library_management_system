package dao;

import model.MembershipType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import hibernate.Hibernatecfg;

public class MembershipTypeDAO {

    // Save MembershipType
    public void saveMembershipType(MembershipType membershipType) {
        Transaction transaction = null;
        try (Session session = Hibernatecfg.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(membershipType);
            transaction.commit();
            System.out.println("MembershipType saved successfully.");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            throw new RuntimeException("Error saving MembershipType: " + e.getMessage(), e);
        }
    }
    public MembershipType getMembershipTypeById(Long membershipTypeId) {
        try (Session session = Hibernatecfg.getSessionFactory().openSession()) {
            return session.get(MembershipType.class, membershipTypeId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}