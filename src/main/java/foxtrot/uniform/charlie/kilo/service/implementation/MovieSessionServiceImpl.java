package foxtrot.uniform.charlie.kilo.service.implementation;

import foxtrot.uniform.charlie.kilo.dao.MovieSessionDao;
import foxtrot.uniform.charlie.kilo.model.MovieSession;
import foxtrot.uniform.charlie.kilo.service.MovieSessionService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {
    private final MovieSessionDao movieSessionDao;

    @Autowired
    public MovieSessionServiceImpl(MovieSessionDao movieSessionDao) {
        this.movieSessionDao = movieSessionDao;
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        return movieSessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public MovieSession add(MovieSession session) {
        return movieSessionDao.add(session);
    }

    @Override
    public MovieSession update(MovieSession session) {
        return movieSessionDao.update(session);
    }

    @Override
    public MovieSession delete(MovieSession session) {
        return movieSessionDao.delete(session);
    }
}
