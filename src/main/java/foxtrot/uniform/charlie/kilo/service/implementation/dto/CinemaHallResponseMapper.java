package foxtrot.uniform.charlie.kilo.service.implementation.dto;

import foxtrot.uniform.charlie.kilo.model.CinemaHall;
import foxtrot.uniform.charlie.kilo.model.dto.CinemaHallResponseDto;
import foxtrot.uniform.charlie.kilo.service.Mapper;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallResponseMapper implements Mapper<CinemaHallResponseDto, CinemaHall> {
    @Override
    public CinemaHallResponseDto toDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto dto = new CinemaHallResponseDto();
        dto.setCapacity(cinemaHall.getCapacity());
        dto.setDescription(cinemaHall.getDescription());
        dto.setId(cinemaHall.getId());
        return dto;
    }

    @Override
    public CinemaHall fromDto(CinemaHallResponseDto dto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setDescription(dto.getDescription());
        cinemaHall.setId(dto.getId());
        cinemaHall.setCapacity(dto.getCapacity());
        return cinemaHall;
    }
}
