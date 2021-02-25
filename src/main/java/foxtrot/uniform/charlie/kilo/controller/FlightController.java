package foxtrot.uniform.charlie.kilo.controller;

import foxtrot.uniform.charlie.kilo.model.Flight;
import foxtrot.uniform.charlie.kilo.model.dto.request.FlightRequestDto;
import foxtrot.uniform.charlie.kilo.model.dto.response.FlightResponseDto;
import foxtrot.uniform.charlie.kilo.service.FlightService;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.MapperFromDto;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.MapperToDto;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.request.FlightRequestMapper;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.response.FlightResponseMapperToDto;
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
@RequestMapping("/flights")
public class FlightController {
    private final FlightService flightService;
    private final MapperToDto<FlightResponseDto, Flight> flightMapperToDto;
    private final MapperFromDto<FlightRequestDto, Flight> flightMapperFromDto;

    @Autowired
    public FlightController(FlightService flightService,
                            FlightResponseMapperToDto responseMapper,
                            FlightRequestMapper requestMapper) {
        this.flightService = flightService;
        this.flightMapperFromDto = requestMapper;
        this.flightMapperToDto = responseMapper;
    }

    @PostMapping
    public void add(@RequestBody @Valid FlightRequestDto requestDto) {
        flightService.add(flightMapperFromDto.fromDto(requestDto));
    }

    @GetMapping("/available")
    public List<FlightResponseDto> getAvailable(@RequestParam Long id, @RequestParam
                                                   @DateTimeFormat(pattern = "dd.MM.yyyy")
                                                           LocalDate date) {
        return flightService.findAvailableFlights(id, date).stream()
                .map(flightMapperToDto::toDto).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public void put(@PathVariable Long id, @RequestBody @Valid FlightRequestDto requestDto) {
        Flight flight = flightMapperFromDto.fromDto(requestDto);
        flight.setId(id);
        flightService.update(flight);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        flightService.deleteById(id);
    }
}
