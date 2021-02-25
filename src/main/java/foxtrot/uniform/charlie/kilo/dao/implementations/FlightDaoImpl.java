package foxtrot.uniform.charlie.kilo.dao.implementations;

import foxtrot.uniform.charlie.kilo.dao.FlightDao;
import foxtrot.uniform.charlie.kilo.exception.DataProcessingException;
import foxtrot.uniform.charlie.kilo.model.Flight;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FlightDaoImpl implements FlightDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public FlightDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Flight> findAvailableFlights(Long shipId, LocalDate date) {
        try (Session session = sessionFactory.openSession()) {
            Query<Flight> query = session.createQuery("SELECT f FROM Flight f "
                    + "LEFT JOIN FETCH f.spaceport "
                    + "LEFT JOIN FETCH f.ship "
                    + "WHERE f.ship.id = :shipId "
                    + "AND TO_CHAR(f.flightDateTime, 'YYYY-MM-DD') = :date ",
                    Flight.class);
            query.setParameter("shipId", shipId);
            query.setParameter("date", DateTimeFormatter.ISO_LOCAL_DATE.format(date));
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("ERROR: can't find available flights with ship id "
                    + shipId + " and date " + date, e);
        }
    }

    @Override
    public Flight add(Flight flight) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(flight);
            transaction.commit();
            return flight;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("ERROR: can't add flight: " + flight, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Flight update(Flight flight) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(flight);
            transaction.commit();
            return flight;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("ERROR: can't update flight: "
                    + flight, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void deleteById(Long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Flight flight = session.load(Flight.class, id);
            session.delete(flight);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("ERROR: can't delete flight with id "
                    + id, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<Flight> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(Flight.class, id));
        } catch (Exception e) {
            throw new DataProcessingException("Can't get flight with id " + id, e);
        }
    }
}
