package foxtrot.uniform.charlie.kilo.service.implementation.dto;

import foxtrot.uniform.charlie.kilo.model.Movie;
import foxtrot.uniform.charlie.kilo.model.dto.MovieResponseDto;
import foxtrot.uniform.charlie.kilo.service.Mapper;
import org.springframework.stereotype.Component;

@Component
public class MovieResponseMapper implements Mapper<MovieResponseDto, Movie> {
    @Override
    public MovieResponseDto toDto(Movie movie) {
        MovieResponseDto dto = new MovieResponseDto();
        dto.setDescription(movie.getDescription());
        dto.setTitle(movie.getTitle());
        dto.setId(movie.getId());
        return dto;
    }

    @Override
    public Movie fromDto(MovieResponseDto dto) {
        Movie movie = new Movie();
        movie.setDescription(dto.getDescription());
        movie.setId(dto.getId());
        movie.setTitle(dto.getTitle());
        return movie;
    }
}
