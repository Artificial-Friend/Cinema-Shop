package foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.request;

import foxtrot.uniform.charlie.kilo.model.Spaceport;
import foxtrot.uniform.charlie.kilo.model.dto.request.SpaceportRequestDto;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.MapperFromDto;
import org.springframework.stereotype.Component;

@Component
public class SpaceportRequestMapper implements MapperFromDto<SpaceportRequestDto, Spaceport> {
    @Override
    public Spaceport fromDto(SpaceportRequestDto dto) {
        Spaceport spaceport = new Spaceport();
        spaceport.setDescription(dto.getDescription());
        spaceport.setHangarsQuantity(dto.getHangarsQuantity());
        return spaceport;
    }
}
