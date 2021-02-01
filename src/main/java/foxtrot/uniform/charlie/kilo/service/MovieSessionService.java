package foxtrot.uniform.charlie.kilo.service;

import foxtrot.uniform.charlie.kilo.model.MovieSession;
import java.time.LocalDate;
import java.util.List;

public interface MovieSessionService {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    MovieSession add(MovieSession session);
}
