package foxtrot.uniform.charlie.kilo.controller;

import foxtrot.uniform.charlie.kilo.model.MovieSession;
import foxtrot.uniform.charlie.kilo.model.dto.request.MovieSessionRequestDto;
import foxtrot.uniform.charlie.kilo.model.dto.response.MovieSessionResponseDto;
import foxtrot.uniform.charlie.kilo.service.MovieSessionService;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.MapperFromDto;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.MapperToDto;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.request.MovieSessionRequestMapper;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.response.MovieSessionResponseMapperToDto;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private final MapperToDto<MovieSessionResponseDto, MovieSession> movieSessionMapperToDto;
    private final MapperFromDto<MovieSessionRequestDto, MovieSession> movieSessionMapperFromDto;

    @Autowired
    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionResponseMapperToDto responseMapper,
                                  MovieSessionRequestMapper requestMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionMapperFromDto = requestMapper;
        this.movieSessionMapperToDto = responseMapper;
    }

    @PostMapping
    public void add(@RequestBody @Valid MovieSessionRequestDto requestDto) {
        movieSessionService.add(movieSessionMapperFromDto.fromDto(requestDto));
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAvailable(@RequestParam Long id, @RequestParam
                                                   @DateTimeFormat(pattern = "dd.MM.yyyy")
                                                           LocalDate date) {
        return movieSessionService.findAvailableSessions(id, date).stream()
                .map(movieSessionMapperToDto::toDto).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public void put(@PathVariable Long id, @RequestBody @Valid MovieSessionRequestDto requestDto) {
        MovieSession movieSession = movieSessionMapperFromDto.fromDto(requestDto);
        movieSession.setId(id);
        movieSessionService.update(movieSession);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        movieSessionService.deleteById(id);
    }
}
