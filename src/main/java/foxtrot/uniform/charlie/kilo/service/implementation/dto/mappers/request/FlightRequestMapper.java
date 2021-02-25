package foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.request;

import foxtrot.uniform.charlie.kilo.dao.ShipDao;
import foxtrot.uniform.charlie.kilo.dao.SpaceportDao;
import foxtrot.uniform.charlie.kilo.model.Flight;
import foxtrot.uniform.charlie.kilo.model.Ship;
import foxtrot.uniform.charlie.kilo.model.Spaceport;
import foxtrot.uniform.charlie.kilo.model.dto.request.FlightRequestDto;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.MapperFromDto;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlightRequestMapper implements
        MapperFromDto<FlightRequestDto, Flight> {
    private final ShipDao shipDao;
    private final SpaceportDao spaceportDao;

    @Autowired
    public FlightRequestMapper(ShipDao shipDao, SpaceportDao spaceportDao) {
        this.shipDao = shipDao;
        this.spaceportDao = spaceportDao;
    }

    @Override
    public Flight fromDto(FlightRequestDto dto) {
        Ship ship = shipDao.get(dto.getShipId());
        Spaceport spaceport = spaceportDao.get(dto.getSpaceportId());
        Flight flight = new Flight();
        flight.setShip(ship);
        flight.setSpaceport(spaceport);
        flight.setFlightDateTime(LocalDateTime.parse(dto.getFlightDateTime(),
                DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        return flight;
    }
}
