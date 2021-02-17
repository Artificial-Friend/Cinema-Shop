package foxtrot.uniform.charlie.kilo.service.implementation.dto;

import foxtrot.uniform.charlie.kilo.model.MovieSession;
import foxtrot.uniform.charlie.kilo.model.dto.MovieSessionResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionResponseMapperToDto implements
        MapperToDto<MovieSessionResponseDto, MovieSession> {
    @Override
    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto dto = new MovieSessionResponseDto();
        dto.setId(movieSession.getId());
        dto.setShowTime(movieSession.getShowTime().toString());
        dto.setMovieId(movieSession.getMovie().getId());
        dto.setMovieTitle(movieSession.getMovie().getTitle());
        dto.setMovieDescription(movieSession.getMovie().getDescription());
        dto.setCinemaHallId(movieSession.getCinemaHall().getId());
        dto.setCinemaHallDescription(movieSession.getCinemaHall().getDescription());
        return dto;
    }
}
