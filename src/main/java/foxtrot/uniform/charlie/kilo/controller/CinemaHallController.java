package foxtrot.uniform.charlie.kilo.controller;

import foxtrot.uniform.charlie.kilo.model.CinemaHall;
import foxtrot.uniform.charlie.kilo.model.dto.CinemaHallRequestDto;
import foxtrot.uniform.charlie.kilo.model.dto.CinemaHallResponseDto;
import foxtrot.uniform.charlie.kilo.service.CinemaHallService;
import foxtrot.uniform.charlie.kilo.service.Mapper;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.CinemaHallRequestMapper;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.CinemaHallResponseMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private final Mapper<CinemaHallResponseDto, CinemaHall> responseMapper;
    private final Mapper<CinemaHallRequestDto, CinemaHall> requestMapper;

    @Autowired
    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaHallResponseMapper responseMapper,
                                CinemaHallRequestMapper requestMapper) {
        this.cinemaHallService = cinemaHallService;
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
    }

    @PostMapping("/")
    public void add(@RequestBody CinemaHallRequestDto requestDto) {
        cinemaHallService.add(requestMapper.fromDto(requestDto));
    }

    @RequestMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll().stream()
                .map(responseMapper::toDto)
                .collect(Collectors.toList());
    }
}
