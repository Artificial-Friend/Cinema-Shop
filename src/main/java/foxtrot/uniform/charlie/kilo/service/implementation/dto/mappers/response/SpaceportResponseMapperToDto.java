package foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.response;

import foxtrot.uniform.charlie.kilo.model.Spaceport;
import foxtrot.uniform.charlie.kilo.model.dto.response.SpaceportResponseDto;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.MapperToDto;
import org.springframework.stereotype.Component;

@Component
public class SpaceportResponseMapperToDto implements
        MapperToDto<SpaceportResponseDto, Spaceport> {
    @Override
    public SpaceportResponseDto toDto(Spaceport spaceport) {
        SpaceportResponseDto dto = new SpaceportResponseDto();
        dto.setHangarsQuantity(spaceport.getHangarsQuantity());
        dto.setDescription(spaceport.getDescription());
        dto.setId(spaceport.getId());
        return dto;
    }
}
