package foxtrot.uniform.charlie.kilo.dao.implementations;

import foxtrot.uniform.charlie.kilo.dao.MovieDao;
import foxtrot.uniform.charlie.kilo.exception.DataProcessingException;
import foxtrot.uniform.charlie.kilo.model.Movie;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDaoImpl implements MovieDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public MovieDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Movie add(Movie movie) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(movie);
            transaction.commit();
            return movie;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("ERROR: can't add movie " + movie, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Movie get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Movie.class, id);
        } catch (Exception e) {
            throw new DataProcessingException("Can't get movie with id " + id, e);
        }
    }

    @Override
    public List<Movie> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Movie> getAllMoviesQuery = session.createQuery("from Movie", Movie.class);
            return getAllMoviesQuery.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("ERROR: can't get all movies", e);
        }
    }
}
