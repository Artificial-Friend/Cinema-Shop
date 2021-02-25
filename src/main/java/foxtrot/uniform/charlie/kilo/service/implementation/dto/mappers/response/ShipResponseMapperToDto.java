package foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.response;

import foxtrot.uniform.charlie.kilo.model.Ship;
import foxtrot.uniform.charlie.kilo.model.dto.response.ShipResponseDto;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.MapperToDto;
import org.springframework.stereotype.Component;

@Component
public class ShipResponseMapperToDto implements MapperToDto<ShipResponseDto, Ship> {
    @Override
    public ShipResponseDto toDto(Ship ship) {
        ShipResponseDto dto = new ShipResponseDto();
        dto.setIdentifier(ship.getIdentifier());
        dto.setName(ship.getName());
        dto.setCapacity(ship.getCapacity());
        dto.setId(ship.getId());
        return dto;
    }
}
