package foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers;

public interface MapperFromDto<D, E> {
    E fromDto(D dto);
}
