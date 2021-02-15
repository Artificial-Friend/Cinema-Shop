package foxtrot.uniform.charlie.kilo.dao;

import foxtrot.uniform.charlie.kilo.model.Movie;
import java.util.List;

public interface MovieDao {
    Movie add(Movie movie);

    Movie get(Long id);

    List<Movie> getAll();
}
