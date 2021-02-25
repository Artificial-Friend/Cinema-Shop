package foxtrot.uniform.charlie.kilo.controller;

import foxtrot.uniform.charlie.kilo.model.Spaceport;
import foxtrot.uniform.charlie.kilo.model.dto.request.SpaceportRequestDto;
import foxtrot.uniform.charlie.kilo.model.dto.response.SpaceportResponseDto;
import foxtrot.uniform.charlie.kilo.service.SpaceportService;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.MapperFromDto;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.MapperToDto;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.request.SpaceportRequestMapper;
import foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers.response.SpaceportResponseMapperToDto;
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
@RequestMapping("/spaceports")
public class SpaceportController {
    private final SpaceportService spaceportService;
    private final MapperToDto<SpaceportResponseDto, Spaceport> spaceportMapperToDto;
    private final MapperFromDto<SpaceportRequestDto, Spaceport> spaceportMapperFromDto;

    @Autowired
    public SpaceportController(SpaceportService spaceportService,
                               SpaceportResponseMapperToDto responseMapper,
                               SpaceportRequestMapper spaceportMapperFromDto) {
        this.spaceportService = spaceportService;
        this.spaceportMapperFromDto = spaceportMapperFromDto;
        this.spaceportMapperToDto = responseMapper;
    }

    @PostMapping
    public void add(@RequestBody @Valid SpaceportRequestDto requestDto) {
        spaceportService.add(spaceportMapperFromDto.fromDto(requestDto));
    }

    @GetMapping
    public List<SpaceportResponseDto> getAll() {
        return spaceportService.getAll().stream()
                .map(spaceportMapperToDto::toDto)
                .collect(Collectors.toList());
    }
}
