package foxtrot.uniform.charlie.kilo.service.implementation.dto;

public interface MapperToDto<D, E> {
    D toDto(E entity);
}
