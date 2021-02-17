package foxtrot.uniform.charlie.kilo.controller;

import foxtrot.uniform.charlie.kilo.model.Movie;
import foxtrot.uniform.charlie.kilo.model.dto.MovieRequestDto;
import foxtrot.uniform.charlie.kilo.model.dto.MovieResponseDto;
import foxtrot.uniform.charlie.kilo.service.MovieService;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.MapperFromDto;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.MapperToDto;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.MovieRequestMapper;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.MovieResponseMapperToDto;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final MapperToDto<MovieResponseDto, Movie> movieMapperToDto;
    private final MapperFromDto<MovieRequestDto, Movie> movieMapperFromDto;

    @Autowired
    public MovieController(MovieService movieService,
                           MovieResponseMapperToDto responseMapper,
                           MovieRequestMapper movieMapperFromDto) {
        this.movieService = movieService;
        this.movieMapperFromDto = movieMapperFromDto;
        this.movieMapperToDto = responseMapper;
    }

    @PostMapping
    public void add(@RequestBody @Valid MovieRequestDto requestDto) {
        movieService.add(movieMapperFromDto.fromDto(requestDto));
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return movieService.getAll().stream()
                .map(movieMapperToDto::toDto)
                .collect(Collectors.toList());
    }
}
