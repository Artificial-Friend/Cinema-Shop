package foxtrot.uniform.charlie.kilo.dao;

import foxtrot.uniform.charlie.kilo.model.Flight;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FlightDao {
    List<Flight> findAvailableFlights(Long planeId, LocalDate date);

    Flight add(Flight session);

    Flight update(Flight session);

    void deleteById(Long id);

    Optional<Flight> get(Long id);
}
