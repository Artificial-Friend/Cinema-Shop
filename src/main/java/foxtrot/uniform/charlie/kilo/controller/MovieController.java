package foxtrot.uniform.charlie.kilo.controller;

import foxtrot.uniform.charlie.kilo.model.Movie;
import foxtrot.uniform.charlie.kilo.model.dto.MovieRequestDto;
import foxtrot.uniform.charlie.kilo.model.dto.MovieResponseDto;
import foxtrot.uniform.charlie.kilo.service.Mapper;
import foxtrot.uniform.charlie.kilo.service.MovieService;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.MovieRequestMapper;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.MovieResponseMapper;
import java.util.List;
import java.util.stream.Collectors;
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
    private final Mapper<MovieResponseDto, Movie> responseMapper;
    private final Mapper<MovieRequestDto, Movie> requestMapper;

    @Autowired
    public MovieController(MovieService movieService,
                                MovieResponseMapper responseMapper,
                                MovieRequestMapper requestMapper) {
        this.movieService = movieService;
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
    }

    @PostMapping
    public void add(@RequestBody MovieRequestDto requestDto) {
        movieService.add(requestMapper.fromDto(requestDto));
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return movieService.getAll().stream()
                .map(responseMapper::toDto)
                .collect(Collectors.toList());
    }
}
