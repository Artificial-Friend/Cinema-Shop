package foxtrot.uniform.charlie.kilo.dao;

import foxtrot.uniform.charlie.kilo.model.CinemaHall;
import java.util.List;

public interface CinemaHallDao {
    CinemaHall add(CinemaHall cinemaHall);

    CinemaHall get(Long id);

    List<CinemaHall> getAll();
}
