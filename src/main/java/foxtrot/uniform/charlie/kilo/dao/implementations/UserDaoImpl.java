package foxtrot.uniform.charlie.kilo.dao.implementations;

import foxtrot.uniform.charlie.kilo.dao.UserDao;
import foxtrot.uniform.charlie.kilo.exception.DataProcessingException;
import foxtrot.uniform.charlie.kilo.model.User;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User add(User user) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            return user;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("ERROR: can't add user " + user, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<User> getByLogin(String email) {
        try (Session session = sessionFactory.openSession()) {
            User singleResult = session.createQuery("FROM User WHERE email = :email",
                    User.class).setParameter("email", email).uniqueResult();
            return Optional.ofNullable(singleResult);
        } catch (Exception e) {
            throw new DataProcessingException("ERROR: can't get user by login " + email, e);
        }
    }

    @Override
    public Optional<User> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM User WHERE id = :id",
                    User.class).setParameter("id", id).uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("ERROR: can't get user by id " + id, e);
        }
    }
}
