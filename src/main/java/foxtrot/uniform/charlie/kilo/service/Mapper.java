package foxtrot.uniform.charlie.kilo.service;

public interface Mapper<D, E> {
    D toDto(E entity);

    E fromDto(D dto);
}
