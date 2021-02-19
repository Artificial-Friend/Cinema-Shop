package foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.request;

import foxtrot.uniform.charlie.kilo.model.Movie;
import foxtrot.uniform.charlie.kilo.model.dto.request.MovieRequestDto;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.MapperFromDto;
import org.springframework.stereotype.Component;

@Component
public class MovieRequestMapper implements MapperFromDto<MovieRequestDto, Movie> {
    @Override
    public Movie fromDto(MovieRequestDto dto) {
        Movie movie = new Movie();
        movie.setDescription(dto.getDescription());
        movie.setTitle(dto.getTitle());
        return movie;
    }
}
