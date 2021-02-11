package foxtrot.uniform.charlie.kilo.dao.implementations;

import foxtrot.uniform.charlie.kilo.dao.CinemaHallDao;
import foxtrot.uniform.charlie.kilo.exception.DataProcessingException;
import foxtrot.uniform.charlie.kilo.model.CinemaHall;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CinemaHallDaoImpl implements CinemaHallDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public CinemaHallDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(cinemaHall);
            transaction.commit();
            return cinemaHall;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("ERROR: can't add cinemaHall " + cinemaHall, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<CinemaHall> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<CinemaHall> getAllMoviesQuery
                    = session.createQuery("from CinemaHall", CinemaHall.class);
            return getAllMoviesQuery.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("ERROR: can't get all cinemaHalls", e);
        }
    }
}
