package foxtrot.uniform.charlie.kilo.service.implementation.dto;

import foxtrot.uniform.charlie.kilo.model.Movie;
import foxtrot.uniform.charlie.kilo.model.dto.MovieResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieResponseMapperToDto implements MapperToDto<MovieResponseDto, Movie> {
    @Override
    public MovieResponseDto toDto(Movie movie) {
        MovieResponseDto dto = new MovieResponseDto();
        dto.setDescription(movie.getDescription());
        dto.setTitle(movie.getTitle());
        dto.setId(movie.getId());
        return dto;
    }
}
