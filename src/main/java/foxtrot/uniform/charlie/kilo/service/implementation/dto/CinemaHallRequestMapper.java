package foxtrot.uniform.charlie.kilo.service.implementation.dto;

import foxtrot.uniform.charlie.kilo.model.CinemaHall;
import foxtrot.uniform.charlie.kilo.model.dto.CinemaHallRequestDto;
import foxtrot.uniform.charlie.kilo.service.Mapper;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallRequestMapper implements Mapper<CinemaHallRequestDto, CinemaHall> {
    @Override
    public CinemaHallRequestDto toDto(CinemaHall cinemaHall) {
        CinemaHallRequestDto dto = new CinemaHallRequestDto();
        dto.setCapacity(cinemaHall.getCapacity());
        dto.setDescription(cinemaHall.getDescription());
        dto.setId(cinemaHall.getId());
        return dto;
    }

    @Override
    public CinemaHall fromDto(CinemaHallRequestDto dto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setDescription(dto.getDescription());
        cinemaHall.setId(dto.getId());
        cinemaHall.setCapacity(dto.getCapacity());
        return cinemaHall;
    }
}
