package foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.request;

import foxtrot.uniform.charlie.kilo.model.Ship;
import foxtrot.uniform.charlie.kilo.model.dto.request.ShipRequestDto;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.MapperFromDto;
import org.springframework.stereotype.Component;

@Component
public class ShipRequestMapper implements MapperFromDto<ShipRequestDto, Ship> {
    @Override
    public Ship fromDto(ShipRequestDto dto) {
        Ship ship = new Ship();
        ship.setIdentifier(dto.getDescription());
        ship.setName(dto.getTitle());
        ship.setCapacity(dto.getCapacity());
        return ship;
    }
}
