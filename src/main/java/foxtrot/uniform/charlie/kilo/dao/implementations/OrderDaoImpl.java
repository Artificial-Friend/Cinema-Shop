package foxtrot.uniform.charlie.kilo.dao.implementations;

import foxtrot.uniform.charlie.kilo.dao.OrderDao;
import foxtrot.uniform.charlie.kilo.lib.Dao;
import foxtrot.uniform.charlie.kilo.model.Order;
import foxtrot.uniform.charlie.kilo.model.User;
import foxtrot.uniform.charlie.kilo.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class OrderDaoImpl implements OrderDao {
    @Override
    public Order add(Order order) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(order);
            return order;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("ERROR: can't add order " + order, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Order> getAllByUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT DISTINCT o FROM Order o LEFT JOIN FETCH o.tickets "
                    + "WHERE o.user = :user", Order.class).setParameter("user", user)
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException("ERROR: can't get orders by user " + user, e);
        }
    }
}
