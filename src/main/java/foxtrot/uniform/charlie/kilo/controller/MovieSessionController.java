package foxtrot.uniform.charlie.kilo.controller;

import foxtrot.uniform.charlie.kilo.model.MovieSession;
import foxtrot.uniform.charlie.kilo.model.dto.MovieSessionRequestDto;
import foxtrot.uniform.charlie.kilo.model.dto.MovieSessionResponseDto;
import foxtrot.uniform.charlie.kilo.service.Mapper;
import foxtrot.uniform.charlie.kilo.service.MovieSessionService;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.MovieSessionRequestMapper;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.MovieSessionResponseMapper;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final Mapper<MovieSessionResponseDto, MovieSession> responseMapper;
    private final Mapper<MovieSessionRequestDto, MovieSession> requestMapper;

    @Autowired
    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionResponseMapper responseMapper,
                                  MovieSessionRequestMapper requestMapper) {
        this.movieSessionService = movieSessionService;
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
    }

    @PostMapping("/")
    public void add(@RequestBody MovieSessionRequestDto requestDto) {
        movieSessionService.add(requestMapper.fromDto(requestDto));
    }

    @RequestMapping("/available")
    public List<MovieSessionResponseDto> getAvailable(@RequestParam Long id, @RequestParam
                                                   @DateTimeFormat(pattern = "dd.MM.yyyy")
                                                           LocalDate date) {
        return movieSessionService.findAvailableSessions(id, date).stream()
                .map(responseMapper::toDto).collect(Collectors.toList());
    }

    @PutMapping("/")
    public void put(@RequestBody MovieSessionRequestDto requestDto) {
        movieSessionService.update(requestMapper.fromDto(requestDto));
    }

    @DeleteMapping("/")
    public void remove(@RequestBody MovieSessionRequestDto requestDto) {
        movieSessionService.delete(requestMapper.fromDto(requestDto));
    }
}
