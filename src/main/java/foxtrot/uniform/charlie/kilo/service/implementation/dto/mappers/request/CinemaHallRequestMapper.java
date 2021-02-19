package foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.request;

import foxtrot.uniform.charlie.kilo.model.CinemaHall;
import foxtrot.uniform.charlie.kilo.model.dto.request.CinemaHallRequestDto;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.MapperFromDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallRequestMapper implements MapperFromDto<CinemaHallRequestDto, CinemaHall> {
    @Override
    public CinemaHall fromDto(CinemaHallRequestDto dto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setDescription(dto.getDescription());
        cinemaHall.setCapacity(dto.getCapacity());
        return cinemaHall;
    }
}
