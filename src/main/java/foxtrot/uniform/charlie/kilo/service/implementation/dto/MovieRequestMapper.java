package foxtrot.uniform.charlie.kilo.service.implementation.dto;

import foxtrot.uniform.charlie.kilo.model.Movie;
import foxtrot.uniform.charlie.kilo.model.dto.MovieRequestDto;
import foxtrot.uniform.charlie.kilo.service.Mapper;
import org.springframework.stereotype.Component;

@Component
public class MovieRequestMapper implements Mapper<MovieRequestDto, Movie> {
    @Override
    public MovieRequestDto toDto(Movie movie) {
        MovieRequestDto dto = new MovieRequestDto();
        dto.setDescription(movie.getDescription());
        dto.setTitle(movie.getTitle());
        dto.setId(movie.getId());
        return dto;
    }

    @Override
    public Movie fromDto(MovieRequestDto dto) {
        Movie movie = new Movie();
        movie.setDescription(dto.getDescription());
        movie.setId(dto.getId());
        movie.setTitle(dto.getTitle());
        return movie;
    }
}
