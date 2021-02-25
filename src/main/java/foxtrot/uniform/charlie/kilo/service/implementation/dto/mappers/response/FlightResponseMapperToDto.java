package foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.response;

import foxtrot.uniform.charlie.kilo.model.Flight;
import foxtrot.uniform.charlie.kilo.model.dto.response.FlightResponseDto;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.MapperToDto;
import org.springframework.stereotype.Component;

@Component
public class FlightResponseMapperToDto implements
        MapperToDto<FlightResponseDto, Flight> {
    @Override
    public FlightResponseDto toDto(Flight flight) {
        FlightResponseDto dto = new FlightResponseDto();
        dto.setId(flight.getId());
        dto.setFlightDateTime(flight.getFlightDateTime().toString());
        dto.setShipId(flight.getShip().getId());
        dto.setShipName(flight.getShip().getName());
        dto.setShipCapacity(flight.getShip().getCapacity());
        dto.setShipIdentifier(flight.getShip().getIdentifier());
        dto.setFlightId(flight.getSpaceport().getId());
        dto.setFlightDescription(flight.getSpaceport().getDescription());
        return dto;
    }
}
