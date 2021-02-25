package foxtrot.uniform.charlie.kilo.dao.implementations;

import foxtrot.uniform.charlie.kilo.dao.ShipDao;
import foxtrot.uniform.charlie.kilo.exception.DataProcessingException;
import foxtrot.uniform.charlie.kilo.model.Ship;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShipDaoImpl implements ShipDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public ShipDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Ship add(Ship ship) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(ship);
            transaction.commit();
            return ship;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("ERROR: can't add ship: " + ship, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Ship get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Ship.class, id);
        } catch (Exception e) {
            throw new DataProcessingException("ERROR: can't get ship with id: " + id, e);
        }
    }

    @Override
    public List<Ship> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Ship> getAllMoviesQuery = session.createQuery("from Ship", Ship.class);
            return getAllMoviesQuery.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("ERROR: can't get all ships", e);
        }
    }
}
