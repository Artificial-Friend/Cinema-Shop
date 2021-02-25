package foxtrot.uniform.charlie.kilo.service.implementation;

import foxtrot.uniform.charlie.kilo.dao.FlightDao;
import foxtrot.uniform.charlie.kilo.model.Flight;
import foxtrot.uniform.charlie.kilo.service.FlightService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightDao flightDao;

    @Autowired
    public FlightServiceImpl(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    @Override
    public List<Flight> findAvailableFlights(Long movieId, LocalDate date) {
        return flightDao.findAvailableFlights(movieId, date);
    }

    @Override
    public Flight add(Flight session) {
        return flightDao.add(session);
    }

    @Override
    public void update(Flight session) {
        flightDao.update(session);
    }

    @Override
    public void deleteById(Long id) {
        flightDao.deleteById(id);
    }

    @Override
    public Flight get(Long id) {
        return flightDao.get(id).orElseThrow(() ->
                new RuntimeException("Can't get flight with id " + id));
    }
}
