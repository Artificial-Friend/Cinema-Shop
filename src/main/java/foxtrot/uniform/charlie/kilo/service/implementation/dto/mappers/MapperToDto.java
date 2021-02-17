package foxtrot.uniform.charlie.kilo.service.implementation.dto.mappers;

public interface MapperToDto<D, E> {
    D toDto(E entity);
}
