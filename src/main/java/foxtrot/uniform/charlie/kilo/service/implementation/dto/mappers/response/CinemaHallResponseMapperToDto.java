package foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.response;

import foxtrot.uniform.charlie.kilo.model.CinemaHall;
import foxtrot.uniform.charlie.kilo.model.dto.response.CinemaHallResponseDto;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.MapperToDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallResponseMapperToDto implements
        MapperToDto<CinemaHallResponseDto, CinemaHall> {
    @Override
    public CinemaHallResponseDto toDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto dto = new CinemaHallResponseDto();
        dto.setCapacity(cinemaHall.getCapacity());
        dto.setDescription(cinemaHall.getDescription());
        dto.setId(cinemaHall.getId());
        return dto;
    }
}
