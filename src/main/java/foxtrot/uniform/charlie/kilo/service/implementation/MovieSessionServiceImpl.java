package foxtrot.uniform.charlie.kilo.service.implementation;

import foxtrot.uniform.charlie.kilo.dao.MovieSessionDao;
import foxtrot.uniform.charlie.kilo.lib.Inject;
import foxtrot.uniform.charlie.kilo.lib.Service;
import foxtrot.uniform.charlie.kilo.model.MovieSession;
import foxtrot.uniform.charlie.kilo.service.MovieSessionService;
import java.time.LocalDate;
import java.util.List;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {
    @Inject
    private MovieSessionDao movieSessionDao;

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        return movieSessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public MovieSession add(MovieSession session) {
        return movieSessionDao.add(session);
    }
}
