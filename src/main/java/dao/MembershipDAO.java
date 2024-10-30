package dao;

import model.Membership;
import model.MembershipType;
import model.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;
import hibernate.Hibernatecfg;

public class MembershipDAO {

    // Save a membership
    public boolean saveMembership(Membership membership) {
        Transaction transaction = null;
        try (Session session = Hibernatecfg.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(membership);
            transaction.commit();
            System.out.println("Membership saved successfully.");
            return true;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

}
