package foxtrot.uniform.charlie.kilo.dao;

import foxtrot.uniform.charlie.kilo.model.MovieSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieSessionDao {
    List<MovieSession> findAvailableSessions(Long movieSessionId, LocalDate date);

    MovieSession add(MovieSession session);

    MovieSession update(MovieSession session);

    void deleteById(Long id);

    Optional<MovieSession> get(Long id);
}
