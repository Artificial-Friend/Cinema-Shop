package foxtrot.uniform.charlie.kilo.service.implementation.dto;

public interface MapperFromDto<D, E> {
    E fromDto(D dto);
}
