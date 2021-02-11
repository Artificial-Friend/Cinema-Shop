package foxtrot.uniform.charlie.kilo.dao.implementations;

import foxtrot.uniform.charlie.kilo.dao.ShoppingCartDao;
import foxtrot.uniform.charlie.kilo.exception.DataProcessingException;
import foxtrot.uniform.charlie.kilo.model.ShoppingCart;
import foxtrot.uniform.charlie.kilo.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShoppingCartDaoImpl implements ShoppingCartDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public ShoppingCartDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public ShoppingCart add(ShoppingCart shoppingCart) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(shoppingCart);
            transaction.commit();
            return shoppingCart;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("ERROR: Can't add shoppingCart " + shoppingCart, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public ShoppingCart getByUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM ShoppingCart sc "
                    + "LEFT JOIN FETCH sc.tickets WHERE sc.user = :user", ShoppingCart.class)
                    .setParameter("user", user).uniqueResult();
        } catch (Exception e) {
            throw new DataProcessingException("ERROR: can't get shopping cart by user " + user, e);
        }
    }

    @Override
    public void update(ShoppingCart shoppingCart) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(shoppingCart);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("ERROR: Can't update shoppingCart "
                    + shoppingCart, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
