package foxtrot.uniform.charlie.kilo.service;

import foxtrot.uniform.charlie.kilo.model.CinemaHall;
import java.util.List;

public interface CinemaHallService {
    CinemaHall add(CinemaHall cinemaHall);

    List<CinemaHall> getAll();
}
