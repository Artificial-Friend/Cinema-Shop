package foxtrot.uniform.charlie.kilo.dao;

import foxtrot.uniform.charlie.kilo.model.MovieSession;
import java.time.LocalDate;
import java.util.List;

public interface MovieSessionDao {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    MovieSession add(MovieSession session);
}
