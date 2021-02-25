package foxtrot.uniform.charlie.kilo.service;

import foxtrot.uniform.charlie.kilo.model.Flight;
import java.time.LocalDate;
import java.util.List;

public interface FlightService {
    List<Flight> findAvailableFlights(Long shipId, LocalDate date);

    Flight add(Flight session);

    void update(Flight session);

    void deleteById(Long id);

    Flight get(Long id);
}
