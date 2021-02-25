package foxtrot.uniform.charlie.kilo.dao.implementations;

import foxtrot.uniform.charlie.kilo.dao.SpaceportDao;
import foxtrot.uniform.charlie.kilo.exception.DataProcessingException;
import foxtrot.uniform.charlie.kilo.model.Spaceport;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SpaceportDaoImpl implements SpaceportDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public SpaceportDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Spaceport add(Spaceport spaceport) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(spaceport);
            transaction.commit();
            return spaceport;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("ERROR: can't add spaceport: " + spaceport, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Spaceport get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Spaceport.class, id);
        } catch (Exception e) {
            throw new DataProcessingException("ERROR: can't get spaceport with id: " + id, e);
        }
    }

    @Override
    public List<Spaceport> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Spaceport> getAllMoviesQuery
                    = session.createQuery("from Spaceport", Spaceport.class);
            return getAllMoviesQuery.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("ERROR: can't get all spaceports", e);
        }
    }
}
