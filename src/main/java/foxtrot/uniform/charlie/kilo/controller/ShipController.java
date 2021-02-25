package foxtrot.uniform.charlie.kilo.controller;

import foxtrot.uniform.charlie.kilo.model.Ship;
import foxtrot.uniform.charlie.kilo.model.dto.request.ShipRequestDto;
import foxtrot.uniform.charlie.kilo.model.dto.response.ShipResponseDto;
import foxtrot.uniform.charlie.kilo.service.ShipService;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.MapperFromDto;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.MapperToDto;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.request.ShipRequestMapper;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.response.ShipResponseMapperToDto;
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
@RequestMapping("/ships")
public class ShipController {
    private final ShipService shipService;
    private final MapperToDto<ShipResponseDto, Ship> shipMapperToDto;
    private final MapperFromDto<ShipRequestDto, Ship> shipMapperFromDto;

    @Autowired
    public ShipController(ShipService shipService,
                          ShipResponseMapperToDto responseMapper,
                          ShipRequestMapper shipMapperFromDto) {
        this.shipService = shipService;
        this.shipMapperFromDto = shipMapperFromDto;
        this.shipMapperToDto = responseMapper;
    }

    @PostMapping
    public void add(@RequestBody @Valid ShipRequestDto requestDto) {
        shipService.add(shipMapperFromDto.fromDto(requestDto));
    }

    @GetMapping
    public List<ShipResponseDto> getAll() {
        return shipService.getAll().stream()
                .map(shipMapperToDto::toDto)
                .collect(Collectors.toList());
    }
}
