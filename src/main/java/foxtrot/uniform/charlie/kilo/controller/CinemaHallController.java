package foxtrot.uniform.charlie.kilo.controller;

import foxtrot.uniform.charlie.kilo.model.CinemaHall;
import foxtrot.uniform.charlie.kilo.model.dto.CinemaHallRequestDto;
import foxtrot.uniform.charlie.kilo.model.dto.CinemaHallResponseDto;
import foxtrot.uniform.charlie.kilo.service.CinemaHallService;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.CinemaHallRequestMapper;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.CinemaHallResponseMapperToDto;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.MapperFromDto;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.MapperToDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private final MapperToDto<CinemaHallResponseDto, CinemaHall> cinemaHallMapperToDto;
    private final MapperFromDto<CinemaHallRequestDto, CinemaHall> cinemaHallMapperFromDto;

    @Autowired
    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaHallResponseMapperToDto responseMapper,
                                CinemaHallRequestMapper cinemaHallMapperFromDto) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallMapperFromDto = cinemaHallMapperFromDto;
        this.cinemaHallMapperToDto = responseMapper;
    }

    @PostMapping
    public void add(@RequestBody CinemaHallRequestDto requestDto) {
        cinemaHallService.add(cinemaHallMapperFromDto.fromDto(requestDto));
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHallMapperToDto::toDto)
                .collect(Collectors.toList());
    }
}
